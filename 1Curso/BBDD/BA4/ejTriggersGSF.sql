-- EX 1

-- a

ALTER TABLE proyectos
	ADD COLUMN costes INT DEFAULT 0;
-- b

UPDATE proyectos
SET costes = (SELECT SUM(sueldo)
				FROM empleados e 
WHERE num_proyec = codigo_proyec);

-- c

INSERT INTO empleados (codigo_empl, nombre_empl, apellido_empl, sueldo, nombre_dep, ciudad_dep, num_proyec) 
VALUES(9, 'Isaac', 'Sánche', 20000.0, 'DIS', 'Barcelona', 4);

-- d

DELETE FROM empleados
WHERE codigo_empl = 9;

-- e

CREATE OR REPLACE FUNCTION add_empleado_function() RETURNS TRIGGER AS $$ 
BEGIN
	IF(NEW.sueldo IS NOT NULL AND NEW.num_proyec IS NOT NULL) THEN
		UPDATE proyectos
		SET costes = costes + NEW.sueldo
		WHERE codigo_proyec = new.num_proyec;
	END IF;
	RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- e.2 Crear el trigger que ejecuta la función
CREATE OR REPLACE TRIGGER add_empleado_trigger AFTER INSERT ON empleados FOR EACH ROW
EXECUTE PROCEDURE add_empleado_function();

-- f
INSERT INTO empleados (codigo_empl, nombre_empl, apellido_empl, sueldo, nombre_dep, ciudad_dep, num_proyec) 
VALUES(9, 'Isaac', 'Sánche', 20000.0, 'DIS', 'Barcelona', 4);

-- g

CREATE OR REPLACE FUNCTION del_empleado_function() RETURNS TRIGGER AS $$ 
BEGIN
	IF(OLD.sueldo IS NOT NULL AND OLD.num_proyec IS NOT NULL) THEN
		UPDATE proyectos
		SET costes = costes - OLD.sueldo
		WHERE codigo_proyec = OLD.num_proyec;
	END IF;
	RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER del_empleado AFTER DELETE ON empleados FOR EACH ROW
EXECUTE PROCEDURE del_empleado_function();

-- h

DELETE FROM empleados
WHERE codigo_empl = 9;

-- i

CREATE OR REPLACE FUNCTION update_empleado_function() RETURNS TRIGGER AS $$ 
BEGIN
	IF(NEW.sueldo IS NOT NULL AND NEW.num_proyec IS NOT NULL) THEN
		UPDATE proyectos
		SET costes = costes + NEW.sueldo - OLD.sueldo
		WHERE codigo_proyec = new.num_proyec;
	END IF;
	RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER update_empleado AFTER UPDATE ON empleados FOR EACH ROW
EXECUTE PROCEDURE update_empleado_function();

-- j

UPDATE empleados
SET sueldo = 120000
WHERE nombre_empl = 'Maria' AND apellido_empl = 'Puig';

-- EX 2

-- a
ALTER TABLE proyectos
	ADD COLUMN num_empleados INT DEFAULT 0;

-- b
UPDATE proyectos
SET num_empleados = (SELECT COUNT(*)
						FROM empleados
						WHERE num_proyec = codigo_proyec);
-- c

SELECT * FROM proyectos p;

-- d

DROP TRIGGER add_empleado_trigger ON empleados;
DROP TRIGGER del_empleado ON empleados;
DROP TRIGGER update_empleado ON empleados;

-- e

CREATE OR REPLACE FUNCTION add_empleado_function2() RETURNS TRIGGER AS $$ 
BEGIN
	UPDATE proyectos
	SET num_empleados = num_empleados + 1,
		costes = costes + NEW.sueldo
		WHERE codigo_proyec = NEW.num_proyec;
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER add_empleado AFTER INSERT ON empleados FOR EACH ROW
EXECUTE PROCEDURE add_empleado_function2();

-- f
INSERT INTO empleados (codigo_empl, nombre_empl, apellido_empl, sueldo, nombre_dep, ciudad_dep, num_proyec) 
VALUES(9, 'Isaac', 'Sánche', 20000.0, 'DIS', 'Barcelona', 4);

-- g

CREATE OR REPLACE FUNCTION del_empleado_function2() RETURNS TRIGGER AS $$ 
BEGIN
	UPDATE proyectos
	SET num_empleados = num_empleados - 1,
		costes = costes - OLD.sueldo
		WHERE codigo_proyec = OLD.num_proyec;
RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER del_empleado AFTER DELETE ON empleados FOR EACH ROW
EXECUTE PROCEDURE del_empleado_function2();

-- h
DELETE FROM empleados
WHERE codigo_empl = 9;

-- eliminar

DROP TRIGGER add_empleado ON empleados;
DROP TRIGGER del_empleado ON empleados;
