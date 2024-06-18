CREATE TABLE IF NOT EXISTS users
(
    id           SERIAL PRIMARY KEY,
    name         VARCHAR(255),
    mobile_phone VARCHAR(255),
    email        VARCHAR(255) NOT NULL UNIQUE,
    password     VARCHAR(255) NOT NULL,
    address_id   integer REFERENCES addresses (id),
    role_id      integer REFERENCES roles (id)
)

GO
