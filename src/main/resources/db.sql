CREATE TABLE products
(
    id    int NOT NULL AUTO_INCREMENT,
    name  varchar(255),
    cost NUMERIC,
    PRIMARY KEY (id)
);

CREATE TABLE orders
(
    id    int NOT NULL AUTO_INCREMENT,
    date timestamp,
    cost numeric,
    PRIMARY KEY (id)
);