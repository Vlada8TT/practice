CREATE TABLE IF NOT EXISTS product_ingredients
(
    product_id integer NOT NULL,
    ingredient_id integer NOT NULL
)

GO

ALTER TABLE IF EXISTS product_ingredients
    ADD CONSTRAINT fka69i4fo6fys3gt2cbrxsrbn4 FOREIGN KEY (product_id)
        REFERENCES public.products (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION

GO

ALTER TABLE IF EXISTS product_ingredients
    ADD CONSTRAINT fkgwkoppq4tgrpjn63yi9gpeg9p FOREIGN KEY (ingredient_id)
        REFERENCES public.ingredients (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION

GO