CREATE TABLE IF NOT EXISTS order_items
(
    id         SERIAL PRIMARY KEY,
    order_id   INTEGER REFERENCES orders (id),
    product_id INTEGER REFERENCES products (id),
    quantity   INTEGER NOT NULL
)

GO
