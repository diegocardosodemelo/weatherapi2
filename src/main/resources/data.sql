INSERT INTO sensor (id, name) VALUES (1, 'Sensor1');
INSERT INTO sensor (id, name) VALUES (2, 'Sensor2');

INSERT INTO metric (id, sensor_id, temperature, humidity, wind_speed, timestamp) VALUES
(1, 1, 22.5, 35.0, 5.5, CURRENT_TIMESTAMP - INTERVAL '7' DAY),
(2, 1, 23.0, 36.0, 4.8, CURRENT_TIMESTAMP - INTERVAL '7' DAY),
(3, 2, 19.5, 45.0, 7.2, CURRENT_TIMESTAMP - INTERVAL '7' DAY),
(4, 2, 20.0, 44.0, 6.9, CURRENT_TIMESTAMP - INTERVAL '7' DAY);