CREATE TABLE car (
    id BIGSERIAL PRIMARY KEY,
    plate_number VARCHAR(20) NOT NULL UNIQUE,
    owner_name VARCHAR(100)
);