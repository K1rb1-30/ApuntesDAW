
-- EX 1
CREATE OR REPLACE FUNCTION empediment_function() RETURNS TRIGGER AS $$ 
BEGIN
	IF OLD.status_id = 2 THEN
		RAISE NOTICE 'Se ha impedido la acción porque la comanda % ja esta enviada', OLD.id;
		RETURN NULL;
	END IF;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER empediment_trigger BEFORE DELETE OR UPDATE ON orders
FOR EACH ROW EXECUTE FUNCTION empediment_function();
-- Pruebas Ex 1
DELETE FROM orders
WHERE status_id = 2;

DELETE FROM orders
WHERE id = 81;

-- Ex 2
CREATE OR REPLACE FUNCTION ej2(V_id INT) RETURNS INT AS $$
DECLARE
	r_details RECORD;
	r_product RECORD;
	v_min INT;
	v_max INT;
	v_contadorBueno INT := 0;
	
BEGIN
	FOR r_details IN SELECT * FROM order_details WHERE order_id = V_id LOOP
		SELECT * INTO r_product
		FROM products
		WHERE id = r_details.product_id;
		
		IF r_details.unit_price < (r_product.list_price * 0.80) THEN
			RAISE NOTICE 'El producto % de codigo % esta a MENOS del 20 porciento del precio de catalogo', r_product.product_name, r_product.id;
		ELSIF r_details.unit_price > (r_product.list_price * 0.80) THEN
			RAISE NOTICE 'El producto % de codigo % esta a MAS del 20 porciento del precio de catalogo', r_product.product_name, r_product.id;
		ELSE
			v_contadorBueno = v_contadorBueno + 1;
		END IF;
	END LOOP;

	IF NOT FOUND THEN
		RETURN -1;
	END IF;

	RETURN v_contadorBueno;
END;
$$ LANGUAGE plpgsql;

--Pruebas
SELECT ej2(30);

-- Ex 3

-- a
ALTER TABLE orders
	ADD COLUMN total DECIMAL(9, 2) DEFAULT 0;

-- b
CREATE OR REPLACE FUNCTION calcular_total(V_id INT) RETURNS DECIMAL(9, 2) AS $$
DECLARE
	r_details RECORD;
	v_total DECIMAL(9, 2) := 0;
	v_despeses INT;
BEGIN
	SELECT shipping_fee INTO v_despeses
	FROM orders WHERE id = V_id;
	
	FOR r_details IN SELECT * FROM order_details WHERE order_id = V_id LOOP
			v_total = v_total + ((r_details.unit_price * r_details.quantity) - r_details.discount);
	END LOOP;

	IF NOT FOUND THEN
		RAISE NOTICE 'No existe esta comanda o no tiene ningna linea de comanda';
		RETURN 0;
	END IF;
	-- RAISE NOTICE '%-%-%', v_total, v_despeses, V_id;
	v_total = v_total + v_despeses;

	UPDATE orders
	SET total = v_total
	WHERE id = V_id; 

	-- RAISE NOTICE '%-%', v_total, v_despeses;

	RETURN v_total;
END;
$$ LANGUAGE plpgsql;

-- Prueba FUNCTION

-- dropeamos el trigger DEL EJERCICIO 1

DROP TRIGGER empediment_trigger ON orders;

-- Ahora si que va
SELECT calcular_total(30);


-- c

CREATE OR REPLACE FUNCTION total_mantenir_function() RETURNS TRIGGER AS $$ 
BEGIN
	SELECT calcular_total(NEW.order_id);
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER empediment_trigger AFTER INSERT OR UPDATE OF unit_price, quantity, discount ON order_details
FOR EACH ROW EXECUTE FUNCTION total_mantenir_function();

-- Prueba de C

UPDATE order_details
SET quantity =  20
WHERE id = 27;




	

