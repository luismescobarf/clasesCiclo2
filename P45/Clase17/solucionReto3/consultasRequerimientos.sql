-- Requerimiento1: tres meses en los que se realizan más compras
SELECT  strftime("%m",Compra.Fecha) as Mes,
        COUNT(*) Numero_Compras
FROM Compra
GROUP BY Mes
ORDER BY Numero_Compras DESC
LIMIT 3;

SELECT  strftime("%m",Compra.Fecha) as Mes,
        COUNT(*) Numero_Compras
FROM Compra
GROUP BY Mes
ORDER BY Numero_Compras DESC
LIMIT 3;

-- SELECT SUBSTR(Compra.Fecha, 6, 2) as Mes
-- FROM Compra
-- LIMIT 15;

SELECT  SUBSTR(Compra.Fecha, 6, 2) as Mes,
        COUNT(*) Numero_Compras
FROM Compra
GROUP BY Mes
ORDER BY Numero_Compras DESC
LIMIT 3;

-- Requerimiento 2: Ciudad diferente a Bogotá
-- donde residen más líderes para abrir sucursal
SELECT  Lider.Ciudad_Residencia,
        COUNT(*) Numero_Lideres
FROM Lider
WHERE Lider.Ciudad_Residencia NOT IN ('Bogota')
GROUP BY Lider.Ciudad_Residencia
ORDER BY Numero_Lideres DESC;
-- LIMIT 1;

SELECT  Ciudad_Residencia, 
        COUNT(ID_Lider) as Numero_Lideres 
FROM Lider 
WHERE Ciudad_Residencia != "Bogota" 
GROUP BY Ciudad_Residencia 
ORDER BY Numero_Lideres DESC;

SELECT  Ciudad_Residencia, 
        COUNT(ID_Lider) as Numero_Lideres 
FROM Lider 
WHERE Lider.Ciudad_Residencia NOT LIKE "Bogota"
GROUP BY Ciudad_Residencia 
ORDER BY Numero_Lideres DESC;

--Ejemplo uso del having:
-- Solamente presentar las ciudades diferentes a Bogotá donde el 
-- número de líderes oscila entre 2 y 5.
SELECT  Ciudad_Residencia, 
        COUNT(ID_Lider) as Numero_Lideres 
FROM Lider 
WHERE Lider.Ciudad_Residencia NOT LIKE "Bogota"
GROUP BY Ciudad_Residencia
HAVING Numero_Lideres BETWEEN 2 AND 5
ORDER BY Numero_Lideres DESC;

SELECT  Ciudad_Residencia, 
        COUNT(ID_Lider) as Numero_Lideres 
FROM Lider 
WHERE  Lider.Ciudad_Residencia NOT LIKE "Bogota"        
GROUP BY Ciudad_Residencia
HAVING Numero_Lideres >=2 and Numero_Lideres <=5
ORDER BY Numero_Lideres DESC;

-- Requerimiento3: Los materiales de producción 
-- nacional más comprados en los proyectos, 
-- mostrando cuántas compras se han hecho de cada uno. 
-- Desempatar alfabéticamente.

SELECT  m.Nombre_Material,
        m.Importado,
        COUNT(*) as No_Compras
FROM MaterialConstruccion as m
INNER JOIN Compra c 
ON m.ID_MaterialConstruccion = c.ID_MaterialConstruccion
WHERE m.Importado = "No"
GROUP BY m.ID_MaterialConstruccion
ORDER BY No_Compras DESC,
        m.Nombre_Material ASC;



