
```MySQL
SELECT * FROM information_schema.TABLES;

SELECT * FROM information_schema.VIEWS;

  

SHOW TABLES;

SHOW FULL TABLES;

  

-- Vista que incluya unicamente las peliculas creadas en los 2000

  

CREATE VIEW peliculas_2000 AS (

SELECT * FROM film

WHERE release_year BETWEEN 2000 AND 2009

) WITH CHECK OPTION;

  

SELECT * FROM information_schema.VIEWS WHERE TABLE_SCHEMA = 'sakila';

  

SELECT * FROM film;

  

INSERT INTO peliculas_2000 (title, release_year, language_id)

VALUES ('Avatar', 2008, 1);

  

SELECT * FROM film ORDER BY film_id DESC;

  

INSERT INTO peliculas_2000 (title, release_year, language_id)

VALUES ('Super Mario Galaxy', 2026, 1);
```

