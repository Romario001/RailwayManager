insert into railwaymanager.routes (route_id, route_name, train_id)
        values  (1, 'Voronezh-St.Peterburg', 1),
        (2, 'Voronezh-Moskva',	3),
        (3,	'Moskva-St.Peterburg',	7),
        (4,	'Voronezh-Rostov',	5),
        (5,	'Voronezh-Krasnodar',	2),
        (6,	'St.Peterburg-Arkhangelsk',	13),
        (7,	'Moskva-Novgorod',	15),
        (8,	'Novgorod-Vladivostok',	8),
        (9,	'Moskva-Saratov',	4),
        (10, 'Kazan-Saratov',	6);


        insert into railwaymanager.trains (train_id, passenger_count)
        values  (1,	5),
        (2,	10),
        (3,	10),
        (4,	5),
        (5,	5),
        (6,	10),
        (7,	5),
        (8,	5),
        (9,	5),
        (10,	2),
        (11,	1),
        (12,	1),
        (13,	2),
        (14,	3),
        (15,	4);

        insert into railwaymanager.stations (station_id, station_name)
        values  (1,	'Voronezh'),
        (2,	'Tula'),
        (3,	'Moskva'),
        (4,	'St.Peterburg'),
        (5,	'Tver'),
        (6,	'Rostov'),
        (7,	'Krasnodar'),
        (8,	'Arkhangelsk'),
        (9,	'Novgorod'),
        (10,	'Kazan'),
        (11,	'Ufa'),
        (12,	'Ekaterinburg'),
        (13,	'Vladivostok'),
        (14,	'Saratov'),
        (15,	'Samara');

        insert into railwaymanager.route_segments (route_segments_id, route_id,
        station_id_start, station_id_end, order_number, travel_time)
        values  (1,	1,	1,	2,	1,	1),
                (2,	1,	2,	3,	2,	1),
                (3,	1,	3,	4,	3,	1),
                (4,	2,	1,	3,	1,	1),
                (5,	3,	3,	5,	1,	1),
                (6,	3,	5,	4,	2,	1),
                (7,	4,	1,	6,	1,	1),
                (8,	5,	1,	6,	1,	1),
                (9,	5,	6,	7,	2,	1),
                (10,	6,	4,	8,	1,	1),
                (11,	7,	3,	9,	1,	1),
                (12,	8,	9,	10,	1,	1),
                (13,	8,	10,	11,	2,	1),
                (14,	8,	11,	12,	3,	1),
                (15,	8,	12,	13,	4,	1),
                (16,	9,	3,	9,	1,	1),
                (17,	9,	9,	14,	2,	1),
                (18,	10,	10,	15,	1,	1),
                (19,	10,	15,	14,	2,	1);

