
Una transacció és una sèrie d’operacions de manipulació de dades sobre una base de dades que es tracten com una única tasca. 

Per a realitzar una transacció, el SGBD realitza cadascuna de les operacions en un espai temporal, de manera que no afecta a les dades guardades a la base de dades. 

Finalment, quan el resultat final de la transacció ha estat calculat, tots els canvis passen a la base de dades.

## Exemple

Un exemple clàssic de transacció consisteix en el traspàs d’una quantitat de diners d’un compte corrent a un altre. Un traspàs requereix dues operacions sobre la base de dades: la disminució del capital disponible del compte origen i l’augment del capital del compte destí.

Si per algun motiu només es realitzés una de les dues operacions es crearia una situació problemàtica, així que el sistema ha de garantir que es realitzen les dues operacions o no se’n realitza cap.

# AUTOCOMMIT

MySQL (motor InnoDB) té activada per defecte la variable AUTOCOMMIT. Això vol dir que automàticament s'accepten tots els canvis realitzats després de l'execució d'una sentència SQL i no és possible desfer-los.

**Podem consultar el valor actual de AUTOCOMMIT fent:**

```Mysql
SELECT @@autocommit;
```

**Per desactivar la variable AUTOCOMMIT fem:**

```MYsql
SET AUTOCOMMIT = 0;
-- Si fem això sempre tindrem una transacció oberta i els canvis només s'apliquen en la BD executant la sentència COMMIT de manera explícita.
```

**Per a activar la variable AUTOCOMMIT fem:**

```Mysql
SET AUTOCOMMIT = 0;
```

# START TRANSACTION, COMMIT i ROLLBACK

## START TRANSACTION

**Indicar que realitzarem una transacció amb la sentència**
## COMMIT

**Si les operacions s’han completat i volem que els canvis s’apliquin de manera permanent**
## ROLLBACK

**Si durant les operacions es produeix algun error i no volem aplicar els canvis realitzats, podem desfer-los**


# SAVEPOINT











