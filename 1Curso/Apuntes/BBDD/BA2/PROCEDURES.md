```Mysql
DELIMITER //

CREATE PROCEDURE ex1_1_aplicar_descompte()

	BEGIN

		start transaction;
		
		update producto
		
		set precio_venta = precio_venta * 0.85
		
		where cantidad_en_stock > 200;
		
		  
		
		set @contador = (select count(*) from producto where precio_venta < 5);
		
		  
		
		IF @contador > 0 THEN
		
		rollback ;
		
		SELECT 'No se ha actualizado el precio de los productos' AS missatge;
		
		ELSE
		
		commit;
		
		SELECT 'Se ha actualizado el precio de los productos'AS missatge;
		
		END IF;
  

		END //

  

DELIMITER ;
```

## Llamar al procedure

```Mysql
call ex2_aplicar_descompte();
```

## Mirar el estado de los procedures

```Mysql
show procedure status;
```

## Eliminar un procedure

```Mysql
drop procedure if exists nombre_procedure
```


# EJEMPLO CON SAVEPOINTS

```MYsql
DELIMITER //

CREATE PROCEDURE ex2_aplicar_descompte()

BEGIN

  

start transaction;

update producto

set precio_venta = precio_venta * 0.90

where cantidad_en_stock > 100;

set @contador = (select count(*) from producto where precio_venta < 5);

  

  

IF @contador > 0 then

SELECT 'No se confirma la primera operacion' AS missatge;

ROLLBACK;

  

  

ELSE

SAVEPOINT sp1;

update producto

set precio_venta = precio_venta * 0.95

where gama = 'Herramientas';

set @contador = (select count(*) from producto where precio_venta < 5);

IF @contador > 0 THEN

  

SELECT 'No se confirma la ultima operacion' AS missatge;

rollback to sp1;

ELSE

SELECT 'Es confirmen totes les operacions.' AS missatge;

END IF;

END IF;

COMMIT;

END//

  

  

DELIMITER ;
```