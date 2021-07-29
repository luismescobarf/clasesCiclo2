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

-- Requerimientos sobre Reto3 -> Conceptos de consultas SQL

-- Generar los correos electrónicos de los líderes de los 
-- proyectos con el siguiente formato, y arrojarlos
-- ordenados por longitud de forma descendente. Nombrar
-- la columna resultante como email_lider:
-- 1) La primera letra del nombre en minúscula.
-- 2) Un punto
-- 3) Primer apellido
-- 4) Colocar el ID_Lider
-- 5) Dominio @empresa.com.co

-- Extraer pedazos de cadena:
SELECT  SUBSTR(Lider.Nombre, 1, 3) as Pedazo_Nombre, 
        Lider.Nombre
FROM Lider;

SELECT  LOWER(SUBSTR(Lider.Nombre, 1, 1)) as Inicial, 
        Lider.Nombre
FROM Lider;

-- Respuesta al requerimiento
SELECT  LOWER(SUBSTR(Lider.Nombre, 1, 1)) || "." ||
        Lider.Primer_Apellido || Lider.ID_Lider
        || "@empresa.com.co" AS email_lider
FROM Lider
ORDER BY LENGTH(email_lider) DESC;

-- Sin ordenar por longitud de correo generado
SELECT  LOWER(SUBSTR(Lider.Nombre, 1, 1)) || "." ||
        Lider.Primer_Apellido || Lider.ID_Lider
        || "@empresa.com.co" AS email_lider
FROM Lider;


-- Revisión de la consulta
SELECT  LOWER(SUBSTR(Lider.Nombre, 1, 1)) || "." ||
        Lider.Primer_Apellido || Lider.ID_Lider
        || "@empresa.com.co" AS email_lider,
        Lider.Nombre,
        Lider.Primer_Apellido,
        Lider.ID_Lider
FROM Lider
ORDER BY LENGTH(email_lider) DESC;

-- Variante sacando proción final del apellido
SELECT  LOWER(SUBSTR(Lider.Nombre, 1, 1)) || "." ||
        SUBSTR(Lider.Primer_Apellido, LENGTH(Lider.Primer_Apellido)-2, 3)        
        || Lider.ID_Lider
        || "@empresa.com.co" AS email_lider,
        Lider.Nombre,
        Lider.Primer_Apellido,
        Lider.ID_Lider
FROM Lider
ORDER BY LENGTH(email_lider) DESC;




