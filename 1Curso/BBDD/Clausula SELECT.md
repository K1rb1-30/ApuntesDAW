## SELECT

Para seleccionar columnas de la tabla que se indique.
``` SQL
SELECT * FROM usuaris;

SELECT nomaula FROM aules;

SELECT nota, observacions FROM tasques_alumnes; 
```

## CONCAT / AS"

Concatenar varias columnas en una (CONCAT) y añadirle alias con (AS)

``` SQL
SELECT CONCAT(nomUsuari, " ", cognom1Usuari) AS nom_complet FROM usuaris;

SELECT column_name AS alias1;
```

## DISTINCT

Evitar duplicación de filas i retornar solo valores unicos.

```SQL
SELECT DISTINCT nom FROM moduls;
```

## ORDER BY

Ordenar los resultados de la consulta en orden (ASC) ascendente o descendente (DESC), por defecto lo ordenara ascendentemente.

``` SQL
SELECT nom, edat FROM persones ORDER BY edat;

SELECT nom, edat FROM persones ORDER BY edat DESC;

SELECT nomUsuari FROM usuaris ORDER BY nomUsuari DESC;
```

## LIMIT

Limita el resultado de la consulta en el numero de filas que le indiques.
```SQL
LIMIT numero_filas

SELECT nomUsuari FROM usuaris LIMIT 1;
```

### EJEMPLOS EJERCICIOS

```SQL
SELECT nom FROM cicles; 

SELECT nomUsuari, cognom1Usuari, password FROM usuaris;

SELECT DISTINCT nom FROM moduls ORDER BY hores;

SELECT name, frequency, mean_age FROM female_names ORDER BY frequency DESC LIMIT 1;

SELECT name, frequency, mean_age FROM male_names ORDER BY mean_age DESC LIMIT 1;

```

## WHERE

Añadir condiciones a tus consultas.

### Comparadores
``
```SQL
>, >= , <, <=, != OR <>, =
```

### BEETWEEN

Selecciona un valor entre lo que indiques incluido X / Y

BEETWEEN 50 AND 100

### IN

Permite filtrar registros que coinciden con algunos valores dentro de una lista.

```SQL
SELECT * FROM empleados WHERE departamento IN ('ventas','marketing', 'IT')
```

### AND

### OR

### LIKE

Para buscar concidencias parciales en cadena de texto (permite el uso de comodines (%) i ( _ ) para un solo caracter)

```SQL
SELECT * FROM clientes WHERE nombre LIKE 'Juan%'
SELECT * FROM clientes WHERE nombre LIKE '%@gmail.___'
```

### EJERCICIOS QUERYTEST.es

```SQL
SELECT nomUsuari, cognom1Usuari, cognom2Usuari, rol, actiu, repetidor, sexe, dataNaixement, TIMESTAMPDIFF(YEAR, dataNaixement, CURDATE()) AS anys FROM usuaris WHERE idGrup = 4 ORDER BY anys;
```
APLICACION DBEVEAR