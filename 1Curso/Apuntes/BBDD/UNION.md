Unir varias columnas en una (tienen que ser del mismo tipo)

```MySQL
(SELECT CONCAT(e.first_name, ' ', e.last_name) AS nomComplet
FROM employees e )

UNION

(SELECT CONCAT(c.first_name, ' ', c.last_name) AS nomComplet
FROM customers c )
ORDER BY nomComplet;
```

