ALTER TABLE IF EXISTS users
    DROP CONSTRAINT IF EXISTS address_id

GO

ALTER TABLE IF EXISTS users
    DROP CONSTRAINT IF EXISTS role_id

GO

drop table if exists users

GO