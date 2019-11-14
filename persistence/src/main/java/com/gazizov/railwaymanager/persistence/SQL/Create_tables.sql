create SCHEMA IF NOT EXISTS railwaymanager;

create TABLE railwaymanager.passengers
(
    passenger_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    login        VARCHAR(64) NOT NULL,
    password     VARCHAR(32) NOT NULL,
    first_name   VARCHAR(32) NOT NULL,
    last_name    VARCHAR(32) NOT NULL,
    birth_date   DATE NOT NULL,
    role_id      INTEGER NOT NULL,
    active       BOOLEAN default true
);

create TABLE railwaymanager.trains
(
    train_id        INTEGER AUTO_INCREMENT PRIMARY KEY,
    passenger_count INTEGER NOT NULL
);

create TABLE railwaymanager.stations
(
    station_id   INTEGER AUTO_INCREMENT PRIMARY KEY,
    station_name VARCHAR(64) NOT NULL
);

create TABLE railwaymanager.schedule
(
    station_id     INTEGER NOT NULL,
    train_id       INTEGER NOT NULL,
    arrival_time DATE,
    departure_time DATE,
    PRIMARY KEY (station_id, train_id),
    FOREIGN KEY (train_id) REFERENCES railwaymanager.trains (train_id)
        ON delete CASCADE ON update CASCADE,
    FOREIGN KEY (station_id) REFERENCES railwaymanager.stations (station_id)
        ON delete CASCADE ON update CASCADE
);

create TABLE railwaymanager.routes
(
    route_id          INTEGER AUTO_INCREMENT PRIMARY KEY,
    route_name        VARCHAR(64) NOT NULL,
    train_id          INTEGER
);


create TABLE railwaymanager.route_segments
(
    route_segments_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    route_id          INTEGER NOT NULL,
    station_id        INTEGER NOT NULL,
    order_number      INTEGER NOT NULL,
    FOREIGN KEY (route_id) REFERENCES railwaymanager.routes (route_id)
    ON delete CASCADE ON update CASCADE,
    FOREIGN KEY (station_id) REFERENCES railwaymanager.stations (station_id)
    ON delete CASCADE ON update CASCADE
);

create TABLE railwaymanager.tickets
(
    ticket_id    INTEGER AUTO_INCREMENT PRIMARY KEY,
    train_id     INTEGER NOT NULL,
    passenger_id INTEGER NOT NULL,
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

