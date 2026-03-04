**Permet eliminar files d'una taula, la seva sintaxi és similar al update:**

```Mysql

DELETE FROM tbl_name 

[WHERE where_condition]

[ORDER BY ...]

[LIMIT row_count]
```

**Si s'omet la condició, s’eliminen TOTES les files de la taula seleccionada. Igual que l'UPDATE, el DELETE admet JOINs i subconsultes.  Quant a subconsultes, cal destacar que no es pot fer referència a la mateixa taula que s'està modificant dins d'una subconsulta directa.**

## ON DELETE / ON UPDATE

Les clàusules **ON DELETE i ON UPDATE** es defineixen a la taula filla (la que té la clau forana). Ens permeten indicar l'efecte que provoca l'esborrat o l'actualització de les dades que estan referenciades.

 **Les opcions que es podem especificar són les següents:**

- **RESTRICT**: Impedeix que es puguin actualitzar o eliminar les files que tenen valors referenciats per claus alienes. És l'opció per defecte a MySQL.

- **CASCADE**: Permet actualitzar o eliminar automàticament les files que tenen valors referenciats per claus alienes

- **SET NULL:** Assigna el valor NULL a les FK de les files que tenen valors referenciats per claus alienes.

- **NO ACTION**: És una paraula clau de l'estàndard SQL. A MySQL és equivalent a RESTRICT.
# TRUNCATE

TRUNCATE TABLE buida una taula completament. Requereix el privilegi DROP. Lògicament, TRUNCATE TABLE és similar a una instrucció DELETE que elimina totes les files o una seqüència d'instruccions DROP TABLE i CREATE TABLE.

## Diferencies entre TRUNCATE TABLE  i DELETE FROM

| TRUNCATE                                                    | DELETE                                                         |
| ----------------------------------------------------------- | -------------------------------------------------------------- |
| Esborra fila per fila.                                      | Esborra totes les files de cop.                                |
| Es pot usar amb WHERE.                                      | No permet WHERE.                                               |
| Respecta les transaccions → es pot fer ROLLBACK.            | Normalment no es pot desfer (sense ROLLBACK, depèn del motor). |
| Dispara triggers/disparadors.                               | No dispara triggers/disparadors.                               |
| No reinicia els comptadors autoincrements (AUTO_INCREMENT). | Reinicia els comptadors autoincrementals.                      |
| És més lent en taules grans.                                | És molt més ràpid.                                             |
## Utilitats

```Mysql

SHOW DATABASES; 

SHOW TABLES;

SHOW CREATE TABLE nom_taula;

SELECT user(); 

SELECT user, host FROM mysql.user;

SELECT * FROM performance_schema.user_variables_by_thread;

DESCRIBE nom_taula;  = DESC nom_taula;
```


