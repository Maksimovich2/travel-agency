CREATE TABLE IF NOT EXISTS clients
(
    id         BIGSERIAL PRIMARY KEY,
    first_name TEXT    NOT NULL,
    last_name  TEXT    NOT NULL,
    email      TEXT    NOT NULL,
    age        INTEGER NOT NULL,
    sex        TEXT    NOT NULL
);