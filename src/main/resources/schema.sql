DROP TABLE IF EXISTS customer_profile;
DROP TABLE IF EXISTS customer_orders;
DROP TABLE IF EXISTS customer;

CREATE TABLE IF NOT EXISTS customer
(
    id SERIAL PRIMARY KEY,
    name TEXT
);

CREATE TABLE IF NOT EXISTS customer_orders
(
    id SERIAL PRIMARY KEY,
    customer BIGINT REFERENCES customer(id) NOT NULL,
    name CHAR(255)
);

CREATE TABLE IF NOT EXISTS customer_profile (
    id SERIAL PRIMARY KEY,
    customer BIGINT REFERENCES customer(id) NOT NULL,
    username TEXT NOT NULL,
    password TEXT NOT NULL
);

DELETE FROM customer_profile;
DELETE FROM customer_orders;
DELETE FROM customer;
