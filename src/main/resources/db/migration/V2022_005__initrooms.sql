CREATE TABLE IF NOT EXISTS rooms
(
    id       BIGSERIAL PRIMARY KEY,
    capacity INTEGER                        NOT NULL,
    number   INTEGER                        NOT NULL,
    status   TEXT                           NOT NULL,
    price    NUMERIC                        NOT NULL,
    hotel_id BIGSERIAL REFERENCES hotels (id) NOT NULL
);