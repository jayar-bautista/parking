CREATE TABLE parking_slot (
    id BIGSERIAL PRIMARY KEY,
    parking_area_id BIGINT NOT NULL,
    slot_number VARCHAR(50) NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'AVAILABLE',

    CONSTRAINT fk_parking_area
        FOREIGN KEY (parking_area_id)
        REFERENCES parking_area(id)
        ON DELETE CASCADE,

    CONSTRAINT uq_slot_per_area
        UNIQUE (parking_area_id, slot_number)
);