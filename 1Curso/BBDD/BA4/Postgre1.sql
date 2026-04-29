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
