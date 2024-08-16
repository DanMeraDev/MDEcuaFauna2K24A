-- database: EcuaFauna.sqlite

DROP TABLE IF EXISTS GenoAlimento;
DROP TABLE IF EXISTS Hormiga;
DROP TABLE IF EXISTS Sexo;
DROP TABLE IF EXISTS IngestaNativa;
DROP TABLE IF EXISTS Provincia;
DROP TABLE IF EXISTS Region;

CREATE TABLE Region (
     IdRegion INTEGER PRIMARY KEY AUTOINCREMENT 
    ,NombreRegion VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE Provincia (
     IdProvincia INTEGER PRIMARY KEY AUTOINCREMENT
    ,NombreProvincia VARCHAR(50) NOT NULL UNIQUE
    ,IdRegion INTEGER
    ,FOREIGN KEY (IdRegion) REFERENCES Region(IdRegion)
);

CREATE TABLE IngestaNativa (
     IdIngesta INTEGER PRIMARY KEY AUTOINCREMENT
    ,TipoAnimal VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE GenoAlimento (
     IdGenoAlimento INTEGER PRIMARY KEY AUTOINCREMENT
    ,Gen VARCHAR(2) NOT NULL UNIQUE
);

CREATE TABLE Sexo (
     IdSexo INTEGER PRIMARY KEY AUTOINCREMENT
    ,TipoSexo VARCHAR(15) NOT NULL UNIQUE
);

CREATE TABLE Hormiga (
     IdHormiga INTEGER PRIMARY KEY AUTOINCREMENT
    ,TipoHormiga VARCHAR(10) NOT NULL
    ,IdSexo INTEGER NOT NULL
    ,IdProvincia INTEGER NOT NULL
    ,IdGenoAlimento INTEGER NOT NULL
    ,IdIngesta INTEGER NOT NULL
    ,Estado VARCHAR(1) NOT NULL
    ,FOREIGN KEY (idSexo) REFERENCES Sexo(IdSexo)
    ,FOREIGN KEY (IdProvincia) REFERENCES Provincia(IdProvincia)
    ,FOREIGN KEY (IdGenoAlimento) REFERENCES GenoAlimento(IdGenoAlimento)
    ,FOREIGN KEY (IdIngesta) REFERENCES IngestaNativa(IdIngesta)
    ,CHECK (Estado IN ("X", "A"))
);


INSERT INTO Region (NombreRegion)
    VALUES
     ("Costa")
    ,("Sierra")
    ,("Oriente")
    ,("Galápagos");


INSERT INTO Provincia (NombreProvincia, IdRegion) VALUES
    ('Esmeraldas', 1),
    ('Manabí', 1),
    ('Los Ríos', 1),
    ('Guayas', 1),
    ('Santa Elena', 1),
    ('El Oro', 1),
    ('Santo Domingo de los Tsáchilas', 1),

    ('Carchi', 2),
    ('Imbabura', 2),
    ('Pichincha', 2),
    ('Cotopaxi', 2),
    ('Tungurahua', 2),
    ('Bolívar', 2),
    ('Chimborazo', 2),
    ('Cañar', 2),
    ('Azuay', 2),
    ('Loja', 2),

    ('Sucumbíos', 3),
    ('Napo', 3),
    ('Orellana', 3),
    ('Pastaza', 3),
    ('Morona Santiago', 3),
    ('Zamora Chinchipe', 3),

    ('Galápagos', 4);

INSERT INTO IngestaNativa (TipoAnimal)
     VALUES
     ("Carnívoro")
    ,("Hervíboro")
    ,("Omnívoro")
    ,("Insectívoro");

INSERT INTO GenoAlimento (Gen)
     VALUES
     ("X")
    ,("XX")
    ,("XY");

INSERT INTO Sexo (TipoSexo)
     VALUES
     ("Macho")
    ,("Hembra")
    ,("Asexual")
