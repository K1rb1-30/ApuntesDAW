
## Clave Primaria

- identificadir unico
- no puede ser NULL
- ejemplo: ID, DNI, codigo

## Clave Foranea

- Clave que relaciona una tabla con otra.
- Se relaciona con la clave primaria de otra tabla.

## Consultas multitabla

### Producto cartesiano

Combina todas las columnas con todas las columnas de la otra tabla, sean estas relaciones reales o no.

```SQL
SELECT * FROM cicles, moduls;
```

### Interseccion (JOIN)

Solo combina las relaciones reales (clave foranea -> clave primaria) de las tablas.

```SQL
SELECT * FROM cicles c, moduls m WHERE c.id = m.cicle ;
```

###  INNER JOIN

Se usa la clausula INNER JOIN equivalente a JOIN seguido de ON para filtrar las columnas a igualar.

Siempre en el ON tiene que estar la clave foranea y la primaria.

```SQL
SELECT *
FROM cicles c 
JOIN moduls m ON c.id = m.cicle;
```

Tambien le puedes añadir condiciones despues del ON gracias a la clausula WHERE.

```SQL
SELECT u.nomUsuari, u.cognom1Usuari, u.cognom2Usuari
FROM usuaris u
JOIN grups g ON u.idGrup = g.id
WHERE g.nom = 'ASIX2';
```

```SQL
SELECT DISTINCT u.nomUsuari, u.cognom1Usuari, u.cognom2Usuari
FROM usuaris u
JOIN grups_unitats_formatives guf ON u.idUsuari = guf.idprofessor
JOIN aules a ON guf.idaula = a.id
WHERE a.nomaula LIKE 'F%'
ORDER BY u.idUsuari;
```
### LEFT (OUTER) JOIN

Retorna todas las filas de la tabla de la izquierda (Tabla A) i las filas que coinciden de la tabla de la derecha (Tabla B).
Si no hay coincidencia, se muestra el valor NULL en la tabla de la derecha.


```SQL
SELECT * FROM cicles c LEFT JOIN moduls m ON c.id = m.cicle ORDER BY c.nom;
```

#### LEFT JOIN (EXCLUDING INNER JOIN)

Cuando usamos cuando el LEFT JOIN i la condicion ON no tiene coincidencia es decir la table2.id  es NULL
```SQL
SELECT * FROM tableA LEFT JOIN tableB ON tableA.id = tableB.id WHERE tableB.id IS NULL;
```

Ejemplo

```SQL
SELECT u.idUsuari, u.nomUsuari, u.cognom1Usuari, u.cognom2Usuari FROM usuaris u LEFT JOIN tasques_alumnes ta ON u.idUsuari = ta.idalumne WHERE ta.idalumne IS NULL ORDER BY u.idUsuari;
```
