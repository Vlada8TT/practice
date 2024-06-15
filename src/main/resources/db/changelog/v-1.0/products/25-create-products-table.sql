CREATE TABLE IF NOT EXISTS products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price numeric(38, 2) NOT NULL,
    category_id integer REFERENCES categories(id),
    image_id integer REFERENCES images(id)
)

GO