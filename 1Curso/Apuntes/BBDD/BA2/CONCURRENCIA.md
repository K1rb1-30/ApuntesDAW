

Ver nivel actual:
```Mysql
SELECT @@transaction_isolation;
```
Ver el de la sesión:
```Mysql
SELECT @@SESSION.transaction_isolation;
```
Ver el global:
```Mysql
SELECT @@GLOBAL.trasaction_isolation;
```

Cambiar para la sesión actual:
```Mysql
SET SESSION TRANSACTION ISOLATION LEVEL REPEATABLE READ;
```

Cambiar globalmente:
```Mysql
SET GLOBAL TRANSACTION ISOLATION LEVEL READ COMMITTED;
```
Cambiar el de la  TRANSACTION:

```Mysql
SET TRANSACTION ISOLATION LEVEL 
```