-- Descripción de la estructura de la tabla Empresa

CREATE TABLE Empresa (    
    ID_Empresa INTEGER NOT NULL,
    Nombre VARCHAR(30) NOT NULL,
    NIT VARCHAR(15) NOT NULL UNIQUE,
    Fecha_Inicio DATETIME NOT NULL,    
    Antiguedad INTEGER GENERATED ALWAYS AS( DATETIME('2021-01-01') - Fecha_Inicio ),
    PRIMARY KEY (ID_Empresa)
);

INSERT INTO Empresa (Nombre, NIT, Fecha_Inicio) VALUES ('Variedades12','12345-6','2010-05-12');
INSERT INTO Empresa (ID_Empresa, Nombre, NIT, Fecha_Inicio) VALUES (400,'OtraEpresa','77777-6','1985-05-12');
INSERT INTO Empresa (Nombre, NIT, Fecha_Inicio) VALUES ('OtraEpresa','555-6','1999-12-12');
INSERT INTO Empresa (Nombre, NIT, Fecha_Inicio) VALUES ('Probando Unique','555-6','1980-12-12');

CREATE TABLE Proveedor (
    ID_Proveedor INTEGER NOT NULL,
    Nombre VARCHAR(30) NOT NULL,
    Direccion VARCHAR(30) NOT NULL,
    NIT VARCHAR(15) NOT NULL UNIQUE,
    PRIMARY KEY (ID_Proveedor)    
);

INSERT INTO Proveedor (Nombre,Direccion,NIT) VALUES ('SuministrosColombia','Call 12 Bogota','875635-0');
INSERT INTO Proveedor (Nombre,Direccion,NIT) VALUES ('CigarreriaGlobo','Calle 55 Medellin','1212635-0');

CREATE TABLE Producto (
    ID_Producto INTEGER NOT NULL,
    Nombre VARCHAR(30) NOT NULL,
    Codigo VARCHAR(20) NOT NULL,
    Precio_Unitario INT NOT NULL,
    NIT VARCHAR(15) NOT NULL UNIQUE,
    Impuesto REAL GENERATED ALWAYS AS( Precio_Unitario * 0.19 ),
    ID_Empresa INTEGER NOT NULL,
    ID_Proveedor INTEGER NOT NULL,
    PRIMARY KEY (ID_Producto),
    FOREIGN KEY (ID_Empresa) REFERENCES Empresa(ID_Empresa),   
    FOREIGN KEY (ID_Proveedor) REFERENCES Proveedor(ID_Proveedor) 
);