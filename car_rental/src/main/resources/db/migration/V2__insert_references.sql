-- ==============================
-- ref_engine_type
-- ==============================
IF NOT EXISTS (SELECT 1 FROM ref_engine_type WHERE code = 'petrol')
    INSERT INTO ref_engine_type (code, label) VALUES ('petrol', 'Essence');

IF NOT EXISTS (SELECT 1 FROM ref_engine_type WHERE code = 'diesel')
    INSERT INTO ref_engine_type (code, label) VALUES ('diesel', 'Diesel');

IF NOT EXISTS (SELECT 1 FROM ref_engine_type WHERE code = 'electric')
    INSERT INTO ref_engine_type (code, label) VALUES ('electric', 'Électrique');

IF NOT EXISTS (SELECT 1 FROM ref_engine_type WHERE code = 'hybrid')
    INSERT INTO ref_engine_type (code, label) VALUES ('hybrid', 'Hybride');


-- ==============================
-- ref_transmission
-- ==============================
IF NOT EXISTS (SELECT 1 FROM ref_transmission WHERE code = 'manual')
    INSERT INTO ref_transmission (code, label) VALUES ('manual', 'Manuelle');

IF NOT EXISTS (SELECT 1 FROM ref_transmission WHERE code = 'automatic')
    INSERT INTO ref_transmission (code, label) VALUES ('automatic', 'Automatique');


-- ==============================
-- ref_fuel_type
-- ==============================
IF NOT EXISTS (SELECT 1 FROM ref_fuel_type WHERE code = 'petrol')
    INSERT INTO ref_fuel_type (code, label) VALUES ('petrol', 'Essence');

IF NOT EXISTS (SELECT 1 FROM ref_fuel_type WHERE code = 'diesel')
    INSERT INTO ref_fuel_type (code, label) VALUES ('diesel', 'Diesel');

IF NOT EXISTS (SELECT 1 FROM ref_fuel_type WHERE code = 'electric')
    INSERT INTO ref_fuel_type (code, label) VALUES ('electric', 'Électrique');

IF NOT EXISTS (SELECT 1 FROM ref_fuel_type WHERE code = 'hybrid')
    INSERT INTO ref_fuel_type (code, label) VALUES ('hybrid', 'Hybride');


-- ==============================
-- ref_car_status
-- ==============================
IF NOT EXISTS (SELECT 1 FROM ref_car_status WHERE code = 'available')
    INSERT INTO ref_car_status (code, label) VALUES ('available', 'Disponible');

IF NOT EXISTS (SELECT 1 FROM ref_car_status WHERE code = 'rented')
    INSERT INTO ref_car_status (code, label) VALUES ('rented', 'En location');

IF NOT EXISTS (SELECT 1 FROM ref_car_status WHERE code = 'maintenance')
    INSERT INTO ref_car_status (code, label) VALUES ('maintenance', 'En maintenance');

IF NOT EXISTS (SELECT 1 FROM ref_car_status WHERE code = 'sold')
    INSERT INTO ref_car_status (code, label) VALUES ('sold', 'Vendu');


-- ==============================
-- ref_payment_method
-- ==============================
IF NOT EXISTS (SELECT 1 FROM ref_payment_method WHERE code = 'cash')
    INSERT INTO ref_payment_method (code, label) VALUES ('cash', 'Espèces');

IF NOT EXISTS (SELECT 1 FROM ref_payment_method WHERE code = 'card')
    INSERT INTO ref_payment_method (code, label) VALUES ('card', 'Carte bancaire');

IF NOT EXISTS (SELECT 1 FROM ref_payment_method WHERE code = 'transfer')
    INSERT INTO ref_payment_method (code, label) VALUES ('transfer', 'Virement');

IF NOT EXISTS (SELECT 1 FROM ref_payment_method WHERE code = 'mobile')
    INSERT INTO ref_payment_method (code, label) VALUES ('mobile', 'Mobile Money');


-- ==============================
-- ref_depense_type
-- ==============================
IF NOT EXISTS (SELECT 1 FROM ref_depense_type WHERE code = 'fuel')
    INSERT INTO ref_depense_type (code, label) VALUES ('fuel', 'Carburant');

IF NOT EXISTS (SELECT 1 FROM ref_depense_type WHERE code = 'maintenance')
    INSERT INTO ref_depense_type (code, label) VALUES ('maintenance', 'Entretien');

IF NOT EXISTS (SELECT 1 FROM ref_depense_type WHERE code = 'insurance')
    INSERT INTO ref_depense_type (code, label) VALUES ('insurance', 'Assurance');

IF NOT EXISTS (SELECT 1 FROM ref_depense_type WHERE code = 'repair')
    INSERT INTO ref_depense_type (code, label) VALUES ('repair', 'Réparation');

IF NOT EXISTS (SELECT 1 FROM ref_depense_type WHERE code = 'other')
    INSERT INTO ref_depense_type (code, label) VALUES ('other', 'Autre');
