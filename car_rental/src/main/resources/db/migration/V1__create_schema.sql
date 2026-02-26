-- ==============================
-- Reference Tables
-- ==============================

IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'ref_engine_type')
CREATE TABLE ref_engine_type (
                                 id INT IDENTITY(1,1) PRIMARY KEY,
                                 code NVARCHAR(50) NOT NULL UNIQUE,
                                 label NVARCHAR(100) NOT NULL
);

IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'ref_transmission')
CREATE TABLE ref_transmission (
                                  id INT IDENTITY(1,1) PRIMARY KEY,
                                  code NVARCHAR(50) NOT NULL UNIQUE,
                                  label NVARCHAR(100) NOT NULL
);

IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'ref_fuel_type')
CREATE TABLE ref_fuel_type (
                               id INT IDENTITY(1,1) PRIMARY KEY,
                               code NVARCHAR(50) NOT NULL UNIQUE,
                               label NVARCHAR(100) NOT NULL
);

IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'ref_car_status')
CREATE TABLE ref_car_status (
                                id INT IDENTITY(1,1) PRIMARY KEY,
                                code NVARCHAR(50) NOT NULL UNIQUE,
                                label NVARCHAR(100) NOT NULL
);

IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'ref_payment_method')
CREATE TABLE ref_payment_method (
                                    id INT IDENTITY(1,1) PRIMARY KEY,
                                    code NVARCHAR(50) NOT NULL UNIQUE,
                                    label NVARCHAR(100) NOT NULL
);

IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'ref_depense_type')
CREATE TABLE ref_depense_type (
                                  id INT IDENTITY(1,1) PRIMARY KEY,
                                  code NVARCHAR(50) NOT NULL UNIQUE,
                                  label NVARCHAR(100) NOT NULL
);

-- ==============================
-- Core Tables
-- ==============================

IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'car')
CREATE TABLE car (
                     id INT IDENTITY(1,1) PRIMARY KEY,
                     make NVARCHAR(100) NOT NULL,
                     model NVARCHAR(100) NOT NULL,
                     year INT NOT NULL CHECK (year >= 1900 AND year <= YEAR(GETDATE()) + 1),
    license_plate NVARCHAR(50),
    color NVARCHAR(50),
    mileage INT,
    engine_type_id INT NOT NULL REFERENCES ref_engine_type(id),
    transmission_id INT NOT NULL REFERENCES ref_transmission(id),
    fuel_type_id INT NOT NULL REFERENCES ref_fuel_type(id),
    price_per_day DECIMAL(10,2),
    notes NVARCHAR(MAX),
    status_id INT NOT NULL REFERENCES ref_car_status(id),
    created_at DATETIME DEFAULT GETDATE()
);

IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'client')
CREATE TABLE client (
                        id INT IDENTITY(1,1) PRIMARY KEY,
                        name NVARCHAR(150) NOT NULL,
                        phone NVARCHAR(50),
                        email NVARCHAR(100),
                        address NVARCHAR(255)
);

IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'rental')
CREATE TABLE rental (
                        id INT IDENTITY(1,1) PRIMARY KEY,
                        car_id INT NOT NULL REFERENCES car(id),
                        client_id INT NOT NULL REFERENCES client(id),
                        start_date DATE NOT NULL,
                        end_date DATE NOT NULL,
                        gps BIT DEFAULT 0,
                        child_seat BIT DEFAULT 0,
                        insurance BIT DEFAULT 0,
                        total_price DECIMAL(10,2),
                        created_at DATETIME DEFAULT GETDATE()
);

IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'sale')
CREATE TABLE sale (
                      id INT IDENTITY(1,1) PRIMARY KEY,
                      car_id INT NOT NULL REFERENCES car(id),
                      client_id INT NOT NULL REFERENCES client(id),
                      sale_date DATETIME NOT NULL,
                      mileage INT,
                      payment_method_id INT NOT NULL REFERENCES ref_payment_method(id),
                      gps BIT DEFAULT 0,
                      child_seat BIT DEFAULT 0,
                      insurance BIT DEFAULT 0,
                      discount DECIMAL(10,2) DEFAULT 0,
                      status_id INT NOT NULL REFERENCES ref_car_status(id),
                      note NVARCHAR(MAX),
                      total_price DECIMAL(10,2) NOT NULL
);

IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'depense')
CREATE TABLE depense (
                         id INT IDENTITY(1,1) PRIMARY KEY,
                         voiture_id INT NOT NULL REFERENCES car(id),
                         type_id INT NOT NULL REFERENCES ref_depense_type(id),
                         montant DECIMAL(10,2) NOT NULL,
                         date_depense DATE NOT NULL,
                         description NVARCHAR(MAX)
);

-- ==============================
-- Auth Tables
-- ==============================

IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'app_user')
CREATE TABLE app_user (
                          id BIGINT IDENTITY(1,1) PRIMARY KEY,
                          username NVARCHAR(100) NOT NULL UNIQUE,
                          email NVARCHAR(150) NOT NULL UNIQUE,
                          password NVARCHAR(255) NOT NULL
);

IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'user_role')
CREATE TABLE user_role (
                           user_id BIGINT NOT NULL REFERENCES app_user(id),
                           role NVARCHAR(50) NOT NULL
);

-- ==============================
-- Menu Tables
-- ==============================

IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'sys_menu')
CREATE TABLE sys_menu (
                          id BIGINT IDENTITY(1,1) PRIMARY KEY,
                          label NVARCHAR(100) NOT NULL,
                          route NVARCHAR(200),
                          ordre INT,
                          parent_id BIGINT REFERENCES sys_menu(id)
);

IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'sys_menu_roles')
CREATE TABLE sys_menu_roles (
                                menu_id BIGINT NOT NULL REFERENCES sys_menu(id),
                                role NVARCHAR(50) NOT NULL
);
