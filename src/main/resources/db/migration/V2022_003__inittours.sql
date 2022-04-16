CREATE TABLE IF NOT EXISTS tours
(
    id              BIGSERIAL PRIMARY KEY,
    arrival_date    TIMESTAMP NOT NULL,
    departure_date  TIMESTAMP NOT NULL,
    count_transfers INTEGER   NOT NULL,
    hotel_id        BIGSERIAL NOT NULL,
    CONSTRAINT fk_hotel FOREIGN KEY (hotel_id) REFERENCES hotels (id)
);