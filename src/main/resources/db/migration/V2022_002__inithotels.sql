CREATE TABLE IF NOT EXISTS hotels
(
    id          BIGSERIAL PRIMARY KEY,
    name        TEXT NOT NULL,
    location    TEXT NOT NULL,
    count_stars INT  NOT NULL
);