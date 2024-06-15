ALTER TABLE IF EXISTS order_items DROP CONSTRAINT IF EXISTS product_id

GO

ALTER TABLE IF EXISTS order_items DROP CONSTRAINT IF EXISTS order_id

GO

drop table if exists order_items

GO

