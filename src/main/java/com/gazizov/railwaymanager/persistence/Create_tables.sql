CREATE SCHEMA IF NOT EXISTS railwaymanager;

CREATE TABLE railwaymanager.passengers
(
    passenger_id SERIAL PRIMARY KEY,
    login        VARCHAR(64) NOT NULL,
    password     VARCHAR(32) NOT NULL,
    first_name   VARCHAR(32) NOT NULL,
    last_name    VARCHAR(32) NOT NULL,
    birth_date   DATE
);

CREATE TABLE railwaymanager.trains
(
    train_id        SERIAL PRIMARY KEY,
    passenger_count INTEGER NOT NULL
);

CREATE TABLE railwaymanager.stations
(
    station_id   SERIAL PRIMARY KEY,
    station_name VARCHAR(64) NOT NULL
);

CREATE TABLE railwaymanager.schedule
(
    station_id     BIGINT UNSIGNED NOT NULL,
    train_id       BIGINT UNSIGNED NOT NULL,
    departure_time DATE,
    PRIMARY KEY (station_id, train_id),
    FOREIGN KEY (train_id) REFERENCES railwaymanager.trains (train_id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (station_id) REFERENCES railwaymanager.stations (station_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE railwaymanager.tickets
(
    ticket_id    SERIAL PRIMARY KEY,
    train_id     BIGINT UNSIGNED NOT NULL,
    passenger_id BIGINT UNSIGNED NOT NULL,
    FOREIGN KEY (train_id) REFERENCES railwaymanager.trains (train_id),
    FOREIGN KEY (passenger_id) REFERENCES railwaymanager.passengers (passenger_id)
);

CREATE TABLE railwaymanager.roles
(
    role_id   INTEGER PRIMARY KEY,
    role_name VARCHAR(32) NOT NULL
);

INSERT INTO railwaymanager.roles (role_id, role_name)
VALUES (1, 'STAFF'),
       (2, 'PASSENGER');

