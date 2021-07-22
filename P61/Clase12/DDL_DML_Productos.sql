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


---------------Generación Gráfica (Asistida)
CREATE TABLE Empresa
(
  ID_Empresa      INTEGER     NOT NULL,
  Nombre          VARCHAR(50) NOT NULL DEFAULT "Sin nombre asignado",
  NIT             VARCHAR(20) NOT NULL UNIQUE,
  Fecha_Fundacion DATETIME    NOT NULL,
  Antiguedad INTEGER GENERATED ALWAYS AS ( datetime('2021-01-01') - Fecha_Fundacion ),
  PRIMARY KEY (ID_Empresa)
);

INSERT INTO Empresa (Nombre,NIT,Fecha_Fundacion) VALUES ('Grupo61','123513-9','1998-07-07');

CREATE TABLE Proveedor(
    ID_Proveedor INTEGER NOT NULL,
    Nombre VARCHAR(50) NOT NULL,
    NIT VARCHAR(11) NOT NULL UNIQUE,
    Direccion VARCHAR(50) NOT NULL,
    PRIMARY KEY(ID_Proveedor)
);

INSERT INTO Proveedor (Nombre,NIT,Direccion) VALUES ('SuministrosStaMarta','4567','Calle 12 No 3');

CREATE TABLE Producto
(
  ID_Producto     INTEGER     NOT NULL,
  Nombre          TEXT        NOT NULL DEFAULT "Sin asignar",
  Codigo          VARCHAR(10) NOT NULL,
  Descripcion     TEXT        NULL    ,
  Precio_Unitario REAL        NOT NULL,
  ID_Empresa      INTEGER     NOT NULL,
  ID_Proveedor      INTEGER     NOT NULL,
  PRIMARY KEY (ID_Producto),
  FOREIGN KEY (ID_Empresa) REFERENCES Empresa (ID_Empresa),
  FOREIGN KEY (ID_Proveedor) REFERENCES Proveedor (ID_Proveedor)
);

INSERT INTO Producto    (Nombre,Codigo,Precio_Unitario, ID_Empresa, ID_Proveedor ) 
        VALUES          ('Papas Rampi','pr4566',1500,1,1);

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

INSERT INTO Cliente (Nombre, DI, Fecha_Nacimiento, Direccion) 
            VALUES  ('Juan','CC12345','1999-12-12','Condominio El Sur');

INSERT INTO Cliente (Nombre, DI, Fecha_Nacimiento, Direccion) 
            VALUES  ('Ana','CC4211133','1986-12-13','Condominio El Sur');

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

INSERT INTO Compra (ID_Cliente,ID_Producto,Cantidad, Fecha) 
            VALUES  (2,1,5,'2021-06-10');


---------------Generación Gráfica (Asistida Eliminando restricción Unique)
CREATE TABLE Empresa
(
  ID_Empresa      INTEGER     NOT NULL,
  Nombre          VARCHAR(50) NOT NULL DEFAULT "Sin nombre asignado",
  NIT             VARCHAR(20) NOT NULL,
  Fecha_Fundacion DATETIME    NOT NULL,
  Antiguedad INTEGER GENERATED ALWAYS AS ( datetime('2021-01-01') - Fecha_Fundacion ),
  PRIMARY KEY (ID_Empresa)
);

INSERT INTO Empresa (Nombre,NIT,Fecha_Fundacion) VALUES ('Grupo61','123513-9','1998-07-07');

CREATE TABLE Proveedor(
    ID_Proveedor INTEGER NOT NULL,
    Nombre VARCHAR(50) NOT NULL,
    NIT VARCHAR(11) NOT NULL,
    Direccion VARCHAR(50) NOT NULL,
    PRIMARY KEY(ID_Proveedor)
);

INSERT INTO Proveedor (Nombre,NIT,Direccion) VALUES ('SuministrosStaMarta','4567','Calle 12 No 3');

CREATE TABLE Producto
(
  ID_Producto     INTEGER     NOT NULL,
  Nombre          TEXT        NOT NULL DEFAULT "Sin asignar",
  Codigo          VARCHAR(10) NOT NULL,
  Descripcion     TEXT        NULL    ,
  Precio_Unitario REAL        NOT NULL,
  ID_Empresa      INTEGER     NOT NULL,
  ID_Proveedor      INTEGER     NOT NULL,
  PRIMARY KEY (ID_Producto),
  FOREIGN KEY (ID_Empresa) REFERENCES Empresa (ID_Empresa),
  FOREIGN KEY (ID_Proveedor) REFERENCES Proveedor (ID_Proveedor)
);

INSERT INTO Producto    (Nombre,Codigo,Precio_Unitario, ID_Empresa, ID_Proveedor ) 
        VALUES          ('Papas Rampi','pr4566',1500,1,1);

CREATE TABLE Cliente
(
  ID_Cliente      INTEGER     NOT NULL,
  Nombre          VARCHAR(50) NOT NULL DEFAULT "Sin nombre asignado",
  Apellidos          VARCHAR(50) NOT NULL DEFAULT "Sin nombre asignado",
  DI             VARCHAR(20) NOT NULL,
  Fecha_Nacimiento DATETIME    NOT NULL,
  Edad INTEGER GENERATED ALWAYS AS ( datetime('2021-01-01') - Fecha_Nacimiento ),
  Direccion VARCHAR(50) NOT NULL,
  PRIMARY KEY (ID_Cliente)
);

INSERT INTO Cliente (Nombre, DI, Fecha_Nacimiento, Direccion) 
            VALUES  ('Juan','CC12345','1999-12-12','Condominio El Sur');

INSERT INTO Cliente (Nombre, DI, Fecha_Nacimiento, Direccion) 
            VALUES  ('Ana','CC4211133','1986-12-13','Condominio El Sur');

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

INSERT INTO Compra (ID_Cliente,ID_Producto,Cantidad, Fecha) 
            VALUES  (2,1,5,'2021-06-10');

--- DML -> Select

--Proyectando sobre columnas
SELECT * FROM Proveedor;
SELECT * FROM Proveedor ORDER BY Proveedor.Nombre;
SELECT Nombre,NIT FROM Proveedor;

--Proyectar sobre columnas y filtrar filas
SELECT * FROM Proveedor WHERE ID_Proveedor > 4;
SELECT * FROM Proveedor WHERE Nombre = "Colombia";
SELECT NIT FROM Proveedor WHERE Nombre = "Colombia";

--Manipulación de cadenas
--RQ -> Generar correos electrónicos de los proveedores
--Formato: nombreProveedor_(dos primerasNIT)@empresa.com
SELECT LOWER(Proveedor.Nombre) || '_' ||  SUBSTR(LOWER(Proveedor.NIT),1,2) || '@empresa.com' as email 
from Proveedor order by email asc;

--Operaciones aritméticas -> Similar a Campo calculado
SELECT Producto.Nombre, Producto.Precio_Unitario, (Producto.Precio_Unitario * 0.19) as Impuesto_IVA 
from Producto ORDER BY Producto.Precio_Unitario DESC;