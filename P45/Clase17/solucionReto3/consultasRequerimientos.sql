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



