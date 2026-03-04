**Serveix per insertar dades en la taula que li indiquis**

```Mysql
 INSERT [INTO] nom_taula [llista_columnes]

 VALUES llista_valors | sentència SELECT
```

Ejemplo

```Mysql

INSERT INTO customers ( first_name, last_name, company, email_address)

VALUES ( 'LL', 'G', 'IES_S', 'LLG@gmail.com');
```

**IMPORTANTE** 

**les columnes amb restricció ‘NOT NULL’ que no tinguin un valor per defecte o que no siguien autoincrements necessitaran sempre un valor al realitzar la inserció.**

### Amb SELECT

```Mysql

INSERT INTO customers ( first_name, last_name, company, email_address, job_title, mobile_phone, address, city)

SELECT 'OR', 'LOB', company, email_address, job_title, mobile_phone, address, city

FROM customers

WHERE job_title = 'Informatico';
```

**En MySQL, quan inserim un registre en una taula amb PK autoincremental, podem recuperar el seu valor creat mitjançant la función LAST_INSERT_ID().**



