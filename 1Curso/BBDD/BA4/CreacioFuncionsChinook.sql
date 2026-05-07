-- CHINOOK

-- Ex 7
CREATE OR REPLACE FUNCTION ej7(v_idAlbum INT) RETURNS VOID AS $$ 
DECLARE
	registre RECORD;
BEGIN
	FOR registre IN SELECT name, bytes FROM track t WHERE albumid = v_idAlbum LOOP
		RAISE NOTICE 'Nom canço: %, Bytes: %', registre.name, registre.bytes;
	END LOOP;
END; 
$$ LANGUAGE plpgsql;

SELECT  ej7(30);

-- Ex 10

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

SELECT ej10();

		