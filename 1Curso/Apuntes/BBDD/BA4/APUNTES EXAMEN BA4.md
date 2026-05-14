### Comandes generals

| Ordre         | Com recordar-ho | Descripció                            | Equivalent en MySQL |
| ------------- | --------------- | ------------------------------------- | ------------------- |
| `\i <fitxer>` | IMPORT          | Executa un script SQL des d’un fitxer | `SOURCE <fitxer>`   |
| `\c <DB>`     | CONNECT         | Activa una base de dades              | `USE <DB>`          |
| `\d <taula>`  | DESCRIBE        | Mostra l’estructura d’una taula       | `DESC <taula>`      |
#### Tipos de datos
INT -> integer
TEXT -> String
tabla.columna%TYPE -> apunta al tipo de la columna especificada
RECORD -> guarda una fila entera
### Funciones

``` postgresql
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
	RAISE NOTICE/EXCEPTION 'El idioma % no existe en la BBDD', v_idioma;
	RETURN 0;
END;
$$ LANGUAGE plpgsql;

SELECT paisosidioma('eNglish');
```
### Procedures

```postgresql
CREATE OR REPLACE PROCEDURE ej10() AS $$ 
DECLARE
	registre RECORD;
	v_contadorLine INT;
	v_totalModificat NUMERIC;
BEGIN
	FOR registre IN SELECT * FROM invoice LOOP
		SELECT COUNT(*) INTO v_contadorLine
		FROM invoiceline
		WHERE invoiceid = registre.invoiceid;
		IF v_contadorLine > 5 THEN
			UPDATE invoice
			SET total = ROUND(total * 0.90, 2)
			WHERE invoiceid = registre.invoiceid
			RETURNING total INTO v_totalModificat;
			
			RAISE NOTICE 'La factura % ha estat modificada. Nou total: %', registre.invoiceid, v_totalModificat;
		END IF;
	END LOOP;
END;
$$ LANGUAGE plpgsql;
CALL ej10();
```
## TRIGGERS

```postgresql
CREATE OR REPLACE FUNCTION nombre(variables) RETURNS TRIGGER AS $$...

CREATE OR REPLACE TRIGGER nombre AFTER/BEFORE INSERT/DELETE/UPDATE ON tabla
[FOR EACH ROW / FOR EACH STATEMENT]
EXECUTE PROCEDURE/FUNCTION function();
```

## TRIGGERS MEJORADOS

```postgresql
-- Trigers unificados (opciones INSERT, UPDATE, DELETE)
CREATE OR REPLACE FUNCTION change_empleados_unificados() RETURNS TRIGGER AS $$ 
BEGIN
	IF TG_OP = 'INSERT' THEN
		UPDATE proyectos
		SET num_empleados = num_empleados + 1,
			costes = costes + NEW.sueldo
		WHERE codigo_proyec = NEW.num_proyec;
		RETURN NEW;
	ELSIF TG_OP = 'UPDATE' THEN
		IF(NEW.num_proyec IS NOT NULL AND NEW.sueldo IS NOT NULL) THEN
			IF NEW.num_proyec <> OLD.num_proyec THEN
				-- RESTAR COSAS DEL PROYECTO ANTIGUO
				UPDATE proyectos
				SET num_empleados = num_empleados - 1,
					costes = costes - OLD.sueldo
				WHERE codigo_proyec = OLD.num_proyec;
				-- AÑADIR LAS COSAS AL NUEVO
				UPDATE proyectos
				SET num_empleados = num_empleados + 1,
					costes = costes + NEW.sueldo
				WHERE codigo_proyec = NEW.num_proyec;
			ELSE
				-- SOLO CAMBIAR EL ACTUAL
				UPDATE proyectos
				SET costes = costes + (NEW.sueldo - OLD.sueldo)
				WHERE codigo_proyec = NEW.num_proyec;
			END IF;
		END IF;
		RETURN NEW;
	ELSE
		UPDATE proyectos
		SET num_empleados = num_empleados - 1,
			costes = costes - OLD.sueldo
		WHERE codigo_proyec = OLD.num_proyec;
		RETURN OLD;
END IF;
END;
$$ LANGUAGE plpgsql;
CREATE OR REPLACE TRIGGER unificados_trigger AFTER INSERT OR UPDATE OF sueldo, num_proyec OR DELETE ON empleados
FOR EACH ROW 
EXECUTE FUNCTION change_empleados_unificados();
```

##### RETURN OLD-NEW
En INSERT → siempre NEW
En UPDATE → OLD/NEW depende del uso
En DELETE → siempre OLD
#### Estructura CASE
CASE
	WHEN condicion THEN
		comando
	 ELSE
		comando
END CASE;

### OUT
```postgresql
CREATE OR REPLACE FUNCTION ej3(v_employeeid INT, OUT v_nomComplet TEXT) AS $$ 
BEGIN   
	SELECT CONCAT(firstname, ' ', lastname)  INTO v_nomComplet    
	FROM employee WHERE employeeid = v_employeeid; 
END; 
$$ LANGUAGE plpgsql;
```





