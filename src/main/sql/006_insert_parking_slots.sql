INSERT INTO parking_slot (parking_area_id, slot_number, status)
SELECT 
    1,
    'A-' || generate_series(1, 100),
    'AVAILABLE';
    
INSERT INTO parking_slot (parking_area_id, slot_number, status)
SELECT 
    2,
    'B-' || generate_series(1, 80),
    'AVAILABLE';