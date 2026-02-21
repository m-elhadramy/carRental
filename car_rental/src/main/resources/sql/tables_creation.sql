CREATE TABLE clients (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         nom VARCHAR(100) NOT NULL,
                         prenom VARCHAR(100) NOT NULL,
                         email VARCHAR(100) NOT NULL UNIQUE,
                         telephone VARCHAR(20),
                         date_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE cars (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      marque VARCHAR(50) NOT NULL,
                      modele VARCHAR(50) NOT NULL,
                      annee INT NOT NULL,
                      prix_vente DECIMAL(10,2),
                      tarif_location DECIMAL(10,2),
                      statut ENUM('DISPONIBLE','LOUEE','VENDUE') DEFAULT 'DISPONIBLE',
                      date_ajout TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE rentals (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         client_id BIGINT NOT NULL,
                         car_id BIGINT NOT NULL,
                         date_debut DATE NOT NULL,
                         date_fin DATE NOT NULL,
                         montant DECIMAL(10,2),
                         statut ENUM('EN_COURS','TERMINEE') DEFAULT 'EN_COURS',
                         date_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         FOREIGN KEY (client_id) REFERENCES clients(id) ON DELETE CASCADE,
                         FOREIGN KEY (car_id) REFERENCES cars(id) ON DELETE CASCADE
);


CREATE TABLE sales (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       client_id BIGINT NOT NULL,
                       car_id BIGINT NOT NULL,
                       prix DECIMAL(10,2) NOT NULL,
                       date_vente DATE,
                       FOREIGN KEY (client_id) REFERENCES clients(id) ON DELETE CASCADE,
                       FOREIGN KEY (car_id) REFERENCES cars(id) ON DELETE CASCADE
);

CREATE INDEX idx_car_status ON cars(statut);
CREATE INDEX idx_rental_client ON rentals(client_id);
CREATE INDEX idx_sale_client ON sales(client_id);
