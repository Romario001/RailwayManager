create SCHEMA IF NOT EXISTS railwaymanager;

create TABLE railwaymanager.passengers
(
    passenger_id SERIAL PRIMARY KEY,
    login        VARCHAR(64) NOT NULL,
    password     VARCHAR(32) NOT NULL,
    first_name   VARCHAR(32) NOT NULL,
    last_name    VARCHAR(32) NOT NULL,
    birth_date   DATE NOT NULL,
    role_id      INTEGER NOT NULL
);

create TABLE railwaymanager.trains
(
    train_id        SERIAL PRIMARY KEY,
    passenger_count INTEGER NOT NULL
);

create TABLE railwaymanager.stations
(
    station_id   SERIAL PRIMARY KEY,
    station_name VARCHAR(64) NOT NULL
);

create TABLE railwaymanager.schedule
(
    station_id     BIGINT UNSIGNED NOT NULL,
    train_id       BIGINT UNSIGNED NOT NULL,
    departure_time DATE,
    PRIMARY KEY (station_id, train_id),
    FOREIGN KEY (train_id) REFERENCES railwaymanager.trains (train_id)
        ON delete CASCADE ON update CASCADE,
    FOREIGN KEY (station_id) REFERENCES railwaymanager.stations (station_id)
        ON delete CASCADE ON update CASCADE
);

create TABLE railwaymanager.tickets
(
    ticket_id    SERIAL PRIMARY KEY,
    train_id     BIGINT UNSIGNED NOT NULL,
    passenger_id BIGINT UNSIGNED NOT NULL,
    FOREIGN KEY (train_id) REFERENCES railwaymanager.trains (train_id),
    FOREIGN KEY (passenger_id) REFERENCES railwaymanager.passengers (passenger_id)
);

create TABLE railwaymanager.roles
(
    role_id   INTEGER PRIMARY KEY,
    role_name VARCHAR(32) NOT NULL
);

insert into railwaymanager.roles (role_id, role_name)
values (1, 'STAFF'),
       (2, 'PASSENGER');

