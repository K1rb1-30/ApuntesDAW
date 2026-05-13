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

-- PRUEBAS

-- INSERT

INSERT INTO empleados (codigo_empl, nombre_empl, apellido_empl, sueldo, nombre_dep, ciudad_dep, num_proyec) 
VALUES(10, 'Gabri', 'Sánchez', 20000.0, 'DIS', 'Barcelona', 4);

-- UPDATE

-- sin cambio de proyecto
UPDATE empleados
SET sueldo = 10
WHERE codigo_empl = 10;

SELECT * FROM proyectos;

-- con cambio de proyecto
UPDATE empleados
SET num_proyec = 1
WHERE codigo_empl = 10;

-- DELETE

DELETE FROM empleados
WHERE codigo_empl = 10;











