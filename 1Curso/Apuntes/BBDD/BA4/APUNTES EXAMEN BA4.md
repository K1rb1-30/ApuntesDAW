### Comandes generals

| Ordre         | Com recordar-ho | Descripció                                      | Equivalent en MySQL |
| ------------- | --------------- | ----------------------------------------------- | ------------------- |
| `\i <fitxer>` | IMPORT          | Executa un script SQL des d’un fitxer           | `SOURCE <fitxer>`   |
| `\c <DB>`     | CONNECT         | Activa una base de dades                        | `USE <DB>`          |
| `\d <taula>`  | DESCRIBE        | Mostra l’estructura d’una taula                 | `DESC <taula>`      |
| `\q`          | QUIT            | Sortir de l’entorn `psql`                       | `EXIT`              |
## Funciones

``` postgresql
CREATE OR REPLACE FUNCTION
```

#### Tipos de datos


tabla.columna%TYPE -> apunta al tipo de la columna especificada
