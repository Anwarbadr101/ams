
INSERT INTO patient(id, name) VALUES (1,'Anwar');

INSERT INTO appointment (id, appointment_date, is_canceled,cancel_reason,patient_id) VALUES (1,'2022-01-01',NULL,NULL,1);
INSERT INTO appointment (id, appointment_date, is_canceled,cancel_reason,patient_id) VALUES (2,'2022-05-18',NULL,NULL,1);

-- future appointment
INSERT INTO appointment (id, appointment_date, is_canceled,cancel_reason,patient_id) VALUES (3,'2022-05-19',NULL,NULL,1);
