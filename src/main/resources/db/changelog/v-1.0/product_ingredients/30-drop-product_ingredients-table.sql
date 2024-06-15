ALTER TABLE IF EXISTS product_ingredients DROP CONSTRAINT IF EXISTS ingredient

GO

ALTER TABLE IF EXISTS product_ingredients DROP CONSTRAINT IF EXISTS ingredient_id

GO

drop table if exists product_ingredients

GO