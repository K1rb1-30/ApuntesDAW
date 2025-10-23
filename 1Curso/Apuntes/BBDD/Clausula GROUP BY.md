## Funciones
Conjunto de instrucciones que se invocan y dan un resultado.

### SUM()

Sumar todas las filas d euna columna
```SQL
SELECT SUM(saldo) FROM usuaris;
```

### Count()

Contar las filas o valors(important COUNT DISTINCT)
```SQL
SELECT COUNT(cognom1Usuari) FROM usuaris;
```
### AVG()

Calcula la media de valors
```SQL
SELECT AVG(nota1c) FROM qualificacions;
```

### MAX()

Calcula el maximo valor de todas las filas de una columna.
```MySQL
SELECT MAX(nota1c) FROM qualificacions;
```

### MIN()
```MYSQL
SELECT MIN(hores) FROM moduls
```

## GROUP BY

Agrupa filas que tienen los mimso valores en determinadas columnas.

```MySQL
SELECT departamentos, COUNT(*, SUM(sueldo)
FROM Empleados
GROUP BY departamentos;
```

