-- ==============================
-- 1. Table: RefEngineType
-- ==============================
CREATE TABLE RefEngineType (
                               Id INT IDENTITY(1,1) PRIMARY KEY,
                               Code NVARCHAR(50) NOT NULL UNIQUE,
                               Label NVARCHAR(100) NOT NULL
);

INSERT INTO RefEngineType (Code, Label)
VALUES
    ('petrol', 'Essence'),
    ('diesel', 'Diesel'),
    ('electric', 'Électrique'),
    ('hybrid', 'Hybride');


-- ==============================
-- 2. Table: RefTransmission
-- ==============================
CREATE TABLE RefTransmission (
                                 Id INT IDENTITY(1,1) PRIMARY KEY,
                                 Code NVARCHAR(50) NOT NULL UNIQUE,
                                 Label NVARCHAR(100) NOT NULL
);

INSERT INTO RefTransmission (Code, Label)
VALUES
    ('manual', 'Manuelle'),
    ('automatic', 'Automatique');


-- ==============================
-- 3. Table: RefFuelType
-- ==============================
CREATE TABLE RefFuelType (
                             Id INT IDENTITY(1,1) PRIMARY KEY,
                             Code NVARCHAR(50) NOT NULL UNIQUE,
                             Label NVARCHAR(100) NOT NULL
);

INSERT INTO RefFuelType (Code, Label)
VALUES
    ('petrol', 'Essence'),
    ('diesel', 'Diesel'),
    ('electric', 'Électrique'),
    ('hybrid', 'Hybride');


-- ==============================
-- 4. Table: RefCarStatus
-- ==============================
CREATE TABLE RefCarStatus (
                              Id INT IDENTITY(1,1) PRIMARY KEY,
                              Code NVARCHAR(50) NOT NULL UNIQUE,
                              Label NVARCHAR(100) NOT NULL
);

INSERT INTO RefCarStatus (Code, Label)
VALUES
    ('available', 'Disponible'),
    ('rented', 'En location'),
    ('maintenance', 'En maintenance'),
    ('sold', 'Vendu');


-- ==============================
-- 5. Table: RefPaymentMethod
-- ==============================
CREATE TABLE RefPaymentMethod (
                                  Id INT IDENTITY(1,1) PRIMARY KEY,
                                  Code NVARCHAR(50) NOT NULL UNIQUE,
                                  Label NVARCHAR(100) NOT NULL
);

INSERT INTO RefPaymentMethod (Code, Label)
VALUES
    ('cash', 'Espèces'),
    ('card', 'Carte bancaire'),
    ('transfer', 'Virement'),
    ('mobile', 'Mobile Money');


-- ==============================
-- 1. Table: Car
-- ==============================
CREATE TABLE Car (
                     Id INT IDENTITY(1,1) PRIMARY KEY,
                     Make NVARCHAR(100) NOT NULL,
                     Model NVARCHAR(100) NOT NULL,
    [Year] INT NOT NULL CHECK ([Year] >= 1900 AND [Year] <= YEAR(GETDATE()) + 1),
    LicensePlate NVARCHAR(50),
    Color NVARCHAR(50),
    Mileage INT,
    EngineTypeId INT NOT NULL FOREIGN KEY REFERENCES RefEngineType(Id),
    TransmissionId INT NOT NULL FOREIGN KEY REFERENCES RefTransmission(Id),
    FuelTypeId INT NOT NULL FOREIGN KEY REFERENCES RefFuelType(Id),
    PricePerDay DECIMAL(10,2),
    Notes NVARCHAR(MAX),
    StatusId INT NOT NULL FOREIGN KEY REFERENCES RefCarStatus(Id),
    CreatedAt DATETIME DEFAULT GETDATE()
    );


-- ==============================
-- 2. Table: Client
-- ==============================
CREATE TABLE Client (
                        Id INT IDENTITY(1,1) PRIMARY KEY,
    [Name] NVARCHAR(150) NOT NULL,
    Phone NVARCHAR(50),
    Email NVARCHAR(100),
    Address NVARCHAR(255)
    );


-- ==============================
-- 3. Table: Rental
-- ==============================
CREATE TABLE Rental (
                        Id INT IDENTITY(1,1) PRIMARY KEY,
                        CarId INT NOT NULL FOREIGN KEY REFERENCES Car(Id),
                        ClientId INT NOT NULL FOREIGN KEY REFERENCES Client(Id),
                        StartDate DATE NOT NULL,
                        EndDate DATE NOT NULL,
                        GPS BIT DEFAULT 0,
                        ChildSeat BIT DEFAULT 0,
                        Insurance BIT DEFAULT 0,
                        TotalPrice DECIMAL(10,2),
                        CreatedAt DATETIME DEFAULT GETDATE()
);


-- ==============================
-- 4. Table: Sale
-- ==============================
CREATE TABLE Sale (
                      Id INT IDENTITY(1,1) PRIMARY KEY,
                      CarId INT NOT NULL FOREIGN KEY REFERENCES Car(Id),
                      ClientId INT NOT NULL FOREIGN KEY REFERENCES Client(Id),
                      SaleDate DATETIME NOT NULL,
                      Mileage INT,
                      PaymentMethodId INT NOT NULL FOREIGN KEY REFERENCES RefPaymentMethod(Id),
                      GPS BIT DEFAULT 0,
                      ChildSeat BIT DEFAULT 0,
                      Insurance BIT DEFAULT 0,
                      Discount DECIMAL(10,2) DEFAULT 0,
                      StatusId INT NOT NULL FOREIGN KEY REFERENCES RefCarStatus(Id),
                      Note NVARCHAR(MAX),
                      TotalPrice DECIMAL(10,2) NOT NULL
);
