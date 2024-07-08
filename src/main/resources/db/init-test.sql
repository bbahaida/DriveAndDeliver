INSERT INTO delivery_method (method_name) VALUES ('DRIVE');
INSERT INTO delivery_method (method_name) VALUES ('DELIVERY');
INSERT INTO delivery_method (method_name) VALUES ('DELIVERY_TODAY');
INSERT INTO delivery_method (method_name) VALUES ('DELIVERY_ASAP');

INSERT INTO time_slot (start_time, end_time, delivery_method_id, is_booked) VALUES ('2024-07-01 10:00:00', '2024-07-01 12:00:00', 1, false);
INSERT INTO time_slot (start_time, end_time, delivery_method_id, is_booked) VALUES ('2024-07-01 13:00:00', '2024-07-01 15:00:00', 2, false);
INSERT INTO time_slot (start_time, end_time, delivery_method_id, is_booked) VALUES ('2024-07-02 09:00:00', '2024-07-02 11:00:00', 3, false);
INSERT INTO time_slot (start_time, end_time, delivery_method_id, is_booked) VALUES ('2024-07-03 14:00:00', '2024-07-03 16:00:00', 4, false);