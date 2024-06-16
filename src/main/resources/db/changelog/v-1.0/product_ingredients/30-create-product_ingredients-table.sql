CREATE TABLE IF NOT EXISTS product_ingredients
(
    product_id    integer REFERENCES products (id)    NOT NULL,
    ingredient_id integer REFERENCES ingredients (id) NOT NULL
)

GO
