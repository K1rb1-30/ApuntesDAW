-- ex 1

CREATE FUNCTION funcion1(r1 integer, r2 integer) RETURNS int AS $$
DECLARE
	patata int;
BEGIN
	patata := r1 + r2;
	RETURN patata;
END;
$$ LANGUAGE plpgsql;

SELECT funcion1(2, 2);

-- ex 2

CREATE FUNCTION funcion2textos(s1 TEXT, s2 TEXT) RETURNS INT AS $$
DECLARE
 	longitud1 INT := LENGTH(s1);
	longitud2 INT := LENGTH(s2);
BEGIN
	RAISE NOTICE 'La longitud de la PRIMERA cadena de text es: %', longitud1;
	RAISE NOTICE 'La longitud de la SEGONA cadena de text es: %', longitud2;
	RETURN longitud1 + longitud2;
END;
$$ LANGUAGE plpgsql;

SELECT funcion2textos('Patatatatatass', 'patata');

-- ex 3

CREATE OR REPLACE FUNCTION paisosidioma(v_idioma text) RETURNS INT AS $$
DECLARE
	v_nIdiomas int;
BEGIN
	SELECT COUNT(*) INTO v_nIdiomas
	FROM countrylanguage cl
	WHERE UPPER(cl.language) = UPPER(v_idioma);
	
	IF FOUND THEN
		RETURN v_nIdiomas;
	END IF;

	RAISE NOTICE 'El idioma % no existe en la BBDD', v_idioma;
	RETURN 0;
END;
$$ LANGUAGE plpgsql;

SELECT paisosidioma('eNglish');
SELECT paisosidioma('patata');

-- ex 4

CREATE OR REPLACE FUNCTION afegirCiutat(v_nomCiutat text, v_codiPais text, v_districte text, v_population int) RETURNS INT AS $$

BEGIN
	INSERT INTO city (name, countrycode, district, population)
	VALUES( v_nomCiutat, v_codiPais, v_districte, v_population)
	RETURNING id;

END;
$$ LANGUAGE plpgsql;

SELECT afegirCiutat('Sabadell', 'ESP', 'Barcelona', 225000);

-- ex 7

CREATE OR REPLACE FUNCTION ej7(OUT v_city NUMERIC, OUT v_countrylan NUMERIC, OUT v_country NUMERIC) AS $$ 
BEGIN
	SELECT COUNT(*) FROM city INTO v_city;
	SELECT COUNT(*) FROM countrylanguage INTO v_countrylan;
	SELECT COUNT(*) FROM country INTO v_country;
END;
$$ LANGUAGE plpgsql;

SELECT ej7();

SELECT * FROM ej7();

-- ex 8

CREATE OR REPLACE FUNCTION ej8(v_nomIdioma TEXT) RETURNS SETOF country AS $$ 
DECLARE
	v_codiIdioma TEXT;
BEGIN
	SELECT COUNT(*) INTO v_codiIdioma 
	FROM countrylanguage
	WHERE UPPER(language) LIKE UPPER(v_nomIdioma);

	RETURN QUERY SELECT c.*
	FROM country c
	JOIN countrylanguage cl ON c.code = cl.countrycode
	WHERE UPPER(cl.language) LIKE UPPER(v_nomIdioma);
raise notice '% paisos parlen el idioma %', v_codiIdioma, v_nomIdioma;

END;
$$ LANGUAGE plpgsql;

SELECT * FROM ej8('spanish');