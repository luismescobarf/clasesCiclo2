-- Requerimiento -> Generar los correos electrónicos (2 variantes)
-- > LENGTH

--> Generar los correos electrónicos de los funcionarios de la 
-- empresa administradora de proyectos. Estos correos deben quedar
-- ordenados de mayor a menor según la longitud de estos y deben
-- tener la siguiente estructura:
-- 1) Primera letra en minúscula del nombre
-- 2) Punto
-- 3) Segundo apellido en minúscula (variación 2)
-- 4) Concatenar el ID del líder
-- 5) El dominio de la empresa: @constr.com.co
-- La tabla debe tener como encabezado: Email_Funcionarios 

-- Requerimiento y observar los campos originales
SELECT  LOWER(SUBSTR(l.Nombre, 1, 1)) ||
        "." ||
        LOWER(l.Segundo_Apellido) ||
        l.ID_Lider ||
        "@constr.com.co" as Email_Funcionarios,
        l.Nombre,
        l.Segundo_Apellido,
        l.ID_Lider
FROM Lider l
ORDER BY LENGTH(Email_Funcionarios) DESC;

SELECT  LOWER(SUBSTR(l.Nombre, 1, 1)) ||
        "." ||
        LOWER(l.Segundo_Apellido) ||
        l.ID_Lider ||
        "@constr.com.co" as Email_Funcionarios
FROM Lider l
ORDER BY LENGTH(Email_Funcionarios) DESC;

SELECT  LOWER(SUBSTR(l.Nombre, 1, 1)) ||
        "." ||
        LOWER(l.Segundo_Apellido) ||
        l.ID_Lider ||
        "@constr.com.co" as Email_Funcionarios
FROM Lider l;

SELECT  LOWER(SUBSTR(l.Nombre, 1, 1)) ||
        "." ||
        LOWER(SUBSTR(l.Segundo_Apellido, LENGTH(l.Segundo_Apellido)-3, 4)) ||
        l.ID_Lider ||
        "@constr.com.co" as Email_Funcionarios,
        l.Nombre,
        l.Segundo_Apellido,
        l.ID_Lider
FROM Lider l
ORDER BY LENGTH(Email_Funcionarios) DESC;

-- Obtener la edad promedio de los Líderes (redondeada)

-- Primero las edades
SELECT  strftime('%m-%d',DATETIME('now') - l.Fecha_Nacimiento)  as Diferencia,
        DATETIME('now') - l.Fecha_Nacimiento  as Edad,
        l.Salario * 0.10 as Impuestos,
        l.Nombre,
        l.ID_Lider,
        l.Fecha_Nacimiento
FROM Lider l;

-- Propuesta Orlando Edad
SELECT  strftime('%Y', 'now') - strftime('%Y', l.Fecha_Nacimiento ) as Year,
		strftime('%m', 'now') - strftime('%m', l.Fecha_Nacimiento ) as Month,
		strftime('%d', 'now') - strftime('%d', l.Fecha_Nacimiento ) as Day,
		l.Fecha_Nacimiento		
FROM Lider l;

-- Combinar, edades y obtener el promedio de las mismas
-- Agregación -> 1 solo valor
-- SUM
-- COUNT
-- AVG
-- MAX
-- MIN

SELECT  ROUND(AVG(DATETIME('now') - l.Fecha_Nacimiento))  as Edad_Promedio
FROM Lider l;

--JOIN -> Contrario a normalizar 
-- -> Ampliar una tabla o una entidad con otra entidad

SELECT * FROM Proyecto p
JOIN Tipo t ON
p.ID_Tipo = t.ID_Tipo;

SELECT  l.ID_Lider,
        l.Nombre,
        l.Cargo,
        p.ID_Proyecto,
        p.Clasificacion,
        p.Banco_Vinculado,
        t.Area_Max,
        t.Estrato,
        t.Financiable
FROM Proyecto p
JOIN Tipo t ON
p.ID_Tipo = t.ID_Tipo
JOIN Lider l ON
l.ID_Lider = p.ID_Lider;

-- Requerimiento Freddie:
-- podemos saber cual es líder de cada proyecto y 
-- cuantos proyectos tiene cada lider

SELECT  l.ID_Lider,
        l.Nombre,
        l.Cargo,
        p.ID_Proyecto,
        p.Clasificacion,
        p.Banco_Vinculado        
FROM Proyecto p
JOIN Lider l ON
l.ID_Lider = p.ID_Lider
ORDER BY l.ID_Lider;

SELECT  l.ID_Lider,
        l.Nombre,
        l.Cargo,
        COUNT(*) as Numero_Proyectos                
FROM Proyecto p
JOIN Lider l ON
l.ID_Lider = p.ID_Lider
GROUP BY l.ID_Lider
ORDER BY    Numero_Proyectos DESC,
            l.Cargo ASC,
            l.Nombre ASC,
            l.ID_Lider ASC;

-- El requerimiento anterior pero (a) solamente para los
-- líderes que son coordinadores y gerentes, (b) y que
-- manejen entre 7 y 11 proyectos.

-- RQ (a)
SELECT  l.ID_Lider,
        l.Nombre,
        l.Cargo,
        COUNT(*) as Numero_Proyectos                
FROM Proyecto p
JOIN Lider l ON
l.ID_Lider = p.ID_Lider
WHERE l.Cargo IN ('Coordinador', 'Gerente')
GROUP BY l.ID_Lider
ORDER BY    l.Cargo DESC,
            Numero_Proyectos DESC;

-- RQ (b)
SELECT  l.ID_Lider,
        l.Nombre,
        l.Cargo,
        COUNT(*) as Numero_Proyectos                
FROM Proyecto p
JOIN Lider l ON
l.ID_Lider = p.ID_Lider
WHERE l.Cargo IN ('Coordinador', 'Gerente')
GROUP BY l.ID_Lider
HAVING Numero_Proyectos BETWEEN 7 AND 11
ORDER BY    l.Cargo DESC,
            Numero_Proyectos DESC;

-- Uso del Like

-- RQ -> Proyectos con el serial terminando en BP (Banco Principal)
SELECT  p.ID_Proyecto,
        p.Clasificacion,
        p.Serial
FROM Proyecto p
WHERE p.Serial LIKE '%BP';

SELECT  p.ID_Proyecto,
        p.Clasificacion,
        p.Serial
FROM Proyecto p
WHERE p.Serial LIKE 'c%';

SELECT  p.ID_Proyecto,
        p.Clasificacion,
        p.Serial
FROM Proyecto p
WHERE p.Serial LIKE '%_l_%';

-- RQ José Luis
-- Proyectos realizados en el año 2020 de estrato 3 
-- y que tengan menos de 350 mt2

SELECT  p.ID_Proyecto,
        p.Clasificacion,
        p.Fecha_Inicio,
        t.Estrato,
        t.Area_Max
FROM Proyecto p
JOIN Tipo t ON
p.ID_Tipo = t.ID_Tipo
WHERE   strftime('%Y',p.Fecha_Inicio) = '2020' AND
        t.Estrato <= 3 AND
        t.Area_Max <= 350;

-- Proyectos realizados en el año 2020 de estrato 3 
-- y que estén en ciudades diferentes a Bogotá y Pereira...

SELECT  p.ID_Proyecto,
        p.Clasificacion,
        p.Fecha_Inicio,
        p.Ciudad,
        t.Estrato,
        t.Area_Max
FROM Proyecto p
JOIN Tipo t ON
p.ID_Tipo = t.ID_Tipo
WHERE   strftime('%Y',p.Fecha_Inicio) = '2020' AND
        t.Estrato <= 3 AND
        p.Ciudad NOT IN ('Bogota','Pereira')
ORDER BY p.Ciudad DESC;











