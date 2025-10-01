
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

### JOIN

Se usa la clausua INNER JOIN equivalente a JOIN seguido de ON para filtrar las columnas a igualar.

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


