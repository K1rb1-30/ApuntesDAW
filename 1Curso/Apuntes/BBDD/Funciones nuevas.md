
## IFNULL()

Si el parametro que ponemos entre los parentesis es nulo lo mostraremos por ejemplo con un espacio ' '.
```MySQL
SELECT nomUsuari, cognom1Usuari, IFNULL(cognom2Usuari, ' ') AS cognom2Usuari
FROM usuaris;

/* exemple */
SELECT nomUsuari, CONCAT(cognom1Usuari, ' ', IFNULL(cognom2Usuari, ' ')) AS Cognoms
FROM usuaris
ORDER BY cognom1Usuari, cognom2Usuari, nomUsuari
```
##  CEIL() y FLOOR()
 Similares a ROUND() pero redondea para arriba CEIL() o para abajo FLOOR().
## LEFT()
Extrae un numero especifico de caracteres de de la izquierda de una cadena de texto.
## RIGHT()
Extrae un numero especifico de caracteres de de la derecha de una cadena de texto.

## UCASE() y LCASE()
Convierte el texto en mayusculas UCASE() i minusculas LCASE().

## REPLACE()
Reemplaza todos los caracteres de una caadena por otra.
```MySQL
UPDATE productes
SET imatge_url = REPLACE(imagen_url, 'http://', 'https://')
WHERE imatge LIKE 'http://%'
```
## LENGTH()
Muestra el numero de caracteres de una cadena.

## IF()

Si se cumple esa condicion pasa algo si no no

IF( condicion, si, no)

```MySQL
SELECT u.nomUsuari, u.cognom1Usuari, m.nom, IFNULL(am.nota, ''), IF(am.nota >= 5, 'SUPERADO', 'NO SUPERADO')
FROM usuaris u
JOIN alumnes_moduls am ON u.idUsuari = am.idalumne
JOIN moduls m ON am.idmodul = m.id
```



```MySQL
/* exemples */
SELECT MAX(TIME(r.Moment)) AS Momentmax, MIN(TIME(r.Moment))
FROM usuaris u
JOIN registre r ON u.idUsuari = r.idUsuari
WHERE u.nomUsuari = 'Ismael' AND u.cognom1Usuari = 'Leon';



SELECT UCASE(c.last_name), LCASE(c.first_name), REPLACE(c.email_address, '.edu', '.cat' )
FROM customers c
ORDER BY c.last_name, c.first_name;
```




