-- Ex 1

-- a

ALTER TABLE proyectos
	ADD COLUMN costes INT DEFAULT 0;
-- b

UPDATE proyectos
SET costes = (SELECT SUM(sueldo)
				FROM empleados e WHERE num_proyec = codigo_proyec);

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

