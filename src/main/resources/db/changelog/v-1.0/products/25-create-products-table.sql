CREATE TABLE IF NOT EXISTS products
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    price numeric(38, 2) NOT NULL,
    category_id integer,
    image_id integer,
    CONSTRAINT products_pkey PRIMARY KEY (id),
    CONSTRAINT ukaox0mf8fyerjsh7u4evl70r5e UNIQUE (image_id)
    )

GO

ALTER TABLE IF EXISTS products
    ADD CONSTRAINT fkn18ti2byyc5pbjr9cpjj7qkl9 FOREIGN KEY (image_id)
        REFERENCES images (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION;
CREATE INDEX IF NOT EXISTS ukaox0mf8fyerjsh7u4evl70r5e
    ON products(image_id)

GO

ALTER TABLE IF EXISTS products
    ADD CONSTRAINT fkog2rp4qthbtt2lfyhfo32lsw9 FOREIGN KEY (category_id)
        REFERENCES categories (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION

GO