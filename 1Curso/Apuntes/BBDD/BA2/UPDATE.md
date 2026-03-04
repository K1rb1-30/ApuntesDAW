**Fet servir per modificar dades existents en una taula.**

Sintaxi bàsica: 

```Mysql

UPDATE nom_taula

SET columna1 = valor1, columna2 = valor2

[WHERE condició] -- ATENCIÓ! Sense WHERE, s’actualitzen TOTS els registres

[ORDER BY ...]

[LIMIT row_count]
```

***ATENCIÓ! Sense WHERE, s’actualitzen TOTS els registres***

#### Ejemplos

```MYsql

UPDATE track t

SET t.UnitPrice = ROUND( t.UnitPrice * 0.50 , 2);

-- Rebaixa el preu ud TOTS els ‘tracks’ de la BD en un 50%.


UPDATE track t

JOIN Album a ON t.AlbumId = a.AlbumId

SET t.UnitPrice = ROUND(t.UnitPrice * 0.50 ,2)

WHERE a.title= 'Let There Be Rock';

-- Rebaixa en un 50% únicament els ‘tracks’ inclosos en l’àlbum indicat.

```

## ERROR

```MySQL
UPDATE track

SET UnitPrice = ROUND(UnitPrice * 0.95, 2)

WHERE UnitPrice = (SELECT MIN(UnitPrice) FROM track);
```

![[Pasted image 20260303104156.png]]

**Aquest error ocorre quan s'intenta executar un UPDATE que inclou una subconsulta que fa referència a la mateixa taula que s'està actualitzant. EL SGBD bloqueja aquesta operació per una raó de consistència:**

**Quan s'executa una actualització, el sistema intenta llegir i modificar la taula simultàniament. La subconsulta necessita llegir dades de la taula, però aquestes dades estan sent modificades en el mateix moment per l'operació UPDATE. Això pot crear una condició de carrera (race condition) on els resultats de la subconsulta son impredictibles, ja que depenen de l'estat de les dades que estan sent alterades.**

## Soluciones al error

Solució 1:  Fer servir variables d’usuari (@)

Solució 2 :  Taula temporal

PAS 1: Executa la subconsulta MÉS INTERNA

        ↓

        Crea una taula temporal amb el resultat: (min_price) (Això és una SNAPSHOT congelat del moment)

        ↓

PAS 2: Executa la subconsulta INTERMITJA

        ↓

        Llegeix de la taula temporal (No toca la taula 'track' real)

        ↓

PAS 3: Executa l'UPDATE principal

        ↓

      Compara amb el valor ja calculat de min_price
## Ejemplos de Solución

```MySQL

-- Solució 1:  Fer servir variables (@)

SET @min_price = (SELECT MIN(UnitPrice) FROM track);

UPDATE track

SET UnitPrice = ROUND(UnitPrice * 0.95, 2)

WHERE UnitPrice = @min_price;


-- Solució 2 :  Taula temporal

UPDATE track

SET UnitPrice = ROUND(UnitPrice * 0.95, 2)

WHERE UnitPrice = (SELECT min_price

      FROM (  SELECT MIN(UnitPrice) min_price

          FROM track t)AS t);
```





