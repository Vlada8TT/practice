INSERT INTO users (email, password, role_id)
VALUES ('admin@gmail.com',
        '$2a$12$sTwe0L25P1s9oGTHSHPwQOaZyV21ji59mCBzkumunjZCvy6gUg0ui',
        (SELECT id FROM roles WHERE roles.name = 'ROLE_ADMIN'))

GO
