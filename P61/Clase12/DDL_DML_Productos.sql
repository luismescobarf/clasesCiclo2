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




---------------Generación Gráfica
CREATE TABLE Empresa
(
  ID_Empresa      INTEGER     NOT NULL,
  Nombre          VARCHAR(50) NOT NULL DEFAULT "Sin nombre asignado",
  NIT             VARCHAR(20) NOT NULL UNIQUE,
  Fecha_Fundacion DATETIME    NOT NULL,
  Antiguedad INTEGER GENERATED ALWAYS AS ( datetime('2021-01-01') - Fecha_Fundacion ),
  PRIMARY KEY (ID_Empresa)
);

CREATE TABLE Proveedor(
    ID_Proveedor INTEGER NOT NULL,
    Nombre VARCHAR(50) NOT NULL,
    NIT VARCHAR(11) NOT NULL UNIQUE,
    Direccion VARCHAR(50) NOT NULL,
    PRIMARY KEY(ID_Proveedor)
);

CREATE TABLE Producto
(
  ID_Producto     INTEGER     NOT NULL,
  Nombre          TEXT        NOT NULL DEFAULT "Sin asignar",
  Codigo          VARCHAR(10) NOT NULL,
  Descripcion     TEXT        NULL    ,
  Precio_Unitario REAL        NOT NULL,
  ID_Empresa      INTEGER     NOT NULL,
  ID_Proveedor      INTEGER     NOT NULL,
  PRIMARY KEY (ID_Producto, Codigo),
  FOREIGN KEY (ID_Empresa) REFERENCES Empresa (ID_Empresa),
  FOREIGN KEY (ID_Proveedor) REFERENCES Proveedor (ID_Proveedor)
);

CREATE TABLE Cliente
(
  ID_Cliente      INTEGER     NOT NULL,
  Nombre          VARCHAR(50) NOT NULL DEFAULT "Sin nombre asignado",
  Apellidos          VARCHAR(50) NOT NULL DEFAULT "Sin nombre asignado",
  DI             VARCHAR(20) NOT NULL UNIQUE,
  Fecha_Nacimiento DATETIME    NOT NULL,
  Edad INTEGER GENERATED ALWAYS AS ( datetime('2021-01-01') - Fecha_Nacimiento ),
  Direccion VARCHAR(50) NOT NULL,
  PRIMARY KEY (ID_Cliente)
);

CREATE TABLE Compra (
    ID_Compra      INTEGER     NOT NULL,
    ID_Producto INTEGER NOT NULL,
    ID_Cliente INTEGER NOT NULL,
    Cantidad INTEGER NOT NULL DEFAULT 1,
    Fecha DATETIME NOT NULL,    
    FOREIGN KEY (ID_Producto) REFERENCES Producto (ID_Producto),
    FOREIGN KEY (ID_Cliente) REFERENCES Cliente (ID_Cliente),    
    PRIMARY KEY (ID_Compra)
);