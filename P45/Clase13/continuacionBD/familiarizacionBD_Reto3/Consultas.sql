-- Consultas básicas
SELECT * FROM Lider LIMIT 10; -- Todas las filas y columnas


SELECT  Nombre,
        Ciudad_Residencia,
        Cargo
FROM Lider LIMIT 10; -- Algunas columnas y todas las filas

-- Ciertas columnas, ciertas filas 
-- Requerimiento: Nombre y Ciudad_Residencia de los gerentes
SELECT  Nombre,
        Ciudad_Residencia,
        Cargo
FROM Lider
WHERE Cargo = "Gerente" AND 
      ( Ciudad_Residencia = "Barranquilla" 
        OR 
        Ciudad_Residencia = "Bucaramanga"
      )
LIMIT 10;

SELECT Nombre, Cargo, Salario * 0.10 as Impuesto
FROM Lider
WHERE Cargo = "Asesor"
ORDER BY Nombre asc
LIMIT 10;

SELECT  Nombre || ' ' || 
        Primer_Apellido || ' ' || 
        Segundo_Apellido as Nombre_Completo,
        Salario
FROM Lider
LIMIT 10;

-- DDL -> ALTER TABLE ADD COLUM 

-- ALTER TABLE Proyecto
-- ADD COLUMN nuevaColumna TEXT;

-- ALTER TABLE Proyecto DROP COLUMN nuevaColumna;



