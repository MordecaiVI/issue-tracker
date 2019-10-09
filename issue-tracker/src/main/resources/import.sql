INSERT INTO user (user_name, password) VALUES ('admin', 'admin');
INSERT INTO user (user_name, password) VALUES ('zek', 'zek');

INSERT INTO issue (title, description, place, created_by_id, created_at, updated_by_id, updated_at) VALUES ('CIM1', 'Füstöl a gép (001-es)', 'PC8', 2, '2019-05-05', 2, '2019-05-05');
INSERT INTO issue (title, description, place, created_by_id, created_at, updated_by_id, updated_at) VALUES ('CIM2', 'Rossz a projektor', 'PC2', 1, '2019-08-12', 1, '2019-08-12');
INSERT INTO issue (title, description, place, created_by_id, created_at, updated_by_id, updated_at) VALUES ('CIM3', 'Leégett a fél terem', 'PC4', 2, '2019-09-03', 2, '2019-09-03');

INSERT INTO label (label, created_by_id, created_at) VALUES ('ERROR1', 1, '2019-01-01');
INSERT INTO label (label, created_by_id, created_at) VALUES ('ERROR2', 1, '2019-01-01');
INSERT INTO label (label, created_by_id, created_at) VALUES ('ERROR3', 1, '2019-01-01');


INSERT INTO message (issue_id, message, created_by_id, created_at) VALUES (2, 'Kezdeti üzenet', 2, '2019-05-05');
INSERT INTO message (issue_id, message, created_by_id, created_at) VALUES (1, 'Kezdeti üzenet', 2, '2019-05-05');

INSERT INTO issue_label (issue_id, label_id) VALUES (2, 1);
INSERT INTO issue_label (issue_id, label_id) VALUES (2, 3);
