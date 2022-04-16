CREATE TABLE IF NOT EXISTS orders
(
    id          BIGSERIAL PRIMARY KEY,
    order_time  TIMESTAMP                       NOT NULL,
    total_price NUMERIC                         NOT NULL,
    tour_id     BIGSERIAL REFERENCES tours (id)   NOT NULL,
    client_id   BIGSERIAL REFERENCES clients (id) NOT NULL
);