--- Requerimiento 1: ¿Cuáles son los 10 proyectos ordenados de mayor a 
--- menor donde más dinero se ha invertido en compra de materiales?

SELECT  p.ID_Proyecto,
        p.Clasificacion,
        sum( c.Cantidad * m.Precio_Unidad ) as Gasto_Compras,
        p.Serial
FROM Proyecto p
JOIN Compra c ON
p.ID_Proyecto = c.ID_Proyecto
JOIN MaterialConstruccion m ON
c.ID_MaterialConstruccion = m.ID_MaterialConstruccion
GROUP BY p.ID_Proyecto
ORDER BY Gasto_Compras DESC
LIMIT 10;

--Mónica
SELECT  c.ID_Proyecto, 
        p.Clasificacion, 
        SUM(mc.Precio_Unidad * c.Cantidad) as Gasto_Compras, 
        p.Serial 
FROM Compra c
JOIN MaterialConstruccion mc ON
c.ID_MaterialConstruccion = mc.ID_MaterialConstruccion
JOIN Proyecto p ON
c.ID_Proyecto = p.ID_Proyecto 
GROUP BY c.ID_Proyecto 
ORDER BY Gasto_Compras DESC
LIMIT 10;

--Mauricio
SELECT  c.ID_Proyecto, 
        p.Clasificacion, 
        SUM(c.Cantidad * mc.Precio_Unidad) AS Gasto_Compras ,
        p.Serial 
FROM Compra c 
JOIN MaterialConstruccion mc 
ON mc.ID_MaterialConstruccion = c.ID_MaterialConstruccion  
JOIN Proyecto p 
ON p.ID_Proyecto = c.ID_Proyecto 
GROUP BY c.ID_Proyecto 
ORDER BY Gasto_Compras DESC 
LIMIT 10;



