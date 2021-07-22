-- Descripción de Datos de la BD -> Productos.db

-- Crear la tabla Empresa (Entidad del contexto general - no hace parte del REQ)
CREATE TABLE Empresa(
    ID_Empresa INTEGER NOT NULL,
    Nombre VARCHAR(50) NOT NULL,
    NIT VARCHAR(11) NOT NULL,
    Fecha_Fundacion DATETIME NOT NULL,
    Antiguedad INTEGER GENERATED ALWAYS AS ( datetime('2021-01-01') - Fecha_Fundacion ),
    PRIMARY KEY(ID_Empresa)
);

CREATE TABLE Producto(
    ID_Producto INTEGER NOT NULL,
    Nombre VARCHAR(50) NOT NULL,
    ID_Empresa INTEGER NOT NULL,
    PRIMARY KEY(ID_Producto),
    FOREIGN KEY (ID_Empresa) REFERENCES Empresa(ID_Empresa)
);

INSERT INTO Empresa (Nombre,NIT,Fecha_Fundacion) VALUES ('Grupo61','123513-9','1998-07-07');
SELECT * FROM Empresa;
SELECT Antiguedad FROM Empresa;
