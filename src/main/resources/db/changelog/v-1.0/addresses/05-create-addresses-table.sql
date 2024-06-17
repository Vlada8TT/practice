CREATE TABLE IF NOT EXISTS addresses
(
    id               SERIAL PRIMARY KEY,
    city             VARCHAR(255),
    street           VARCHAR(255) NOT NULL,
    house_number     VARCHAR(255) NOT NULL,
    apartment_number VARCHAR(255)
)

GO
