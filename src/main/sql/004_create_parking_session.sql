CREATE TABLE parking_session (
    id BIGSERIAL PRIMARY KEY,
    car_id BIGINT NOT NULL,
    parking_slot_id BIGINT NOT NULL,
    time_in TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    time_out TIMESTAMP NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',

    CONSTRAINT fk_car
        FOREIGN KEY (car_id)
        REFERENCES car(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_parking_slot
        FOREIGN KEY (parking_slot_id)
        REFERENCES parking_slot(id)
        ON DELETE CASCADE
);