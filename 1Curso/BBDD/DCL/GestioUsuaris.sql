-- Ex 1
CREATE USER 'joseluis'@'localhost'
IDENTIFIED BY 'contrasenya';

-- Ex 2
CREATE USER 'marta'@'localhost'
IDENTIFIED BY '123456789';

-- Ex 3
GRANT ALL PRIVILEGES 
ON *.* TO 'joseluis'@'localhost'
WITH GRANT OPTION;

-- Ex 4
/* 

CREATE ROLE comptable;

GRANT SELECT, UPDATE, DELETE, INSERT
ON sakila.payment TO comptable; 

GRANT comptable TO 'marta'@'localhost';

SET DEFAULT ROLE comptable TO 'marta'@'localhost';
**/

GRANT SELECT, UPDATE, DELETE, INSERT
ON sakila.payment TO 'marta'@'localhost';



-- Ex 5

select * from customer;

-- Ex 6

select * from customer;
-- no se puede porque no tiene permiso para ver la tabla. Solo puede ver la tabla payment.

-- Ex 7

CREATE USER 'paco'@'localhost'
IDENTIFIED BY 'rosquilla';

GRANT CREATE, UPDATE, INSERT, DELETE
ON *.* TO 'paco'@'localhost';

-- Ex 8

create database prova character set utf8;

-- Ex 9
DROP DATABASE IF EXISTS prova;
create database prova character set utf8;
-- AMB joseluis SI es pot pero amb marta no.

-- Ex 10

CREATE ROLE emmagatzematge;

GRANT SELECT
ON sakila.rental TO emmagatzematge;
GRANT SELECT
ON sakila.staff TO emmagatzematge;
GRANT SELECT
ON sakila.store TO emmagatzematge;
GRANT SELECT
ON sakila.inventory TO emmagatzematge;

GRANT UPDATE, DELETE, INSERT
ON sakila.inventory TO emmagatzematge;

-- Ex 11

CREATE USER 'lucia'@'localhost'
IDENTIFIED BY '6767#';

GRANT emmagatzematge TO 'lucia'@'localhost';

SET DEFAULT ROLE emmagatzematge TO 'lucia'@'localhost';

-- Ex 12

-- INSERT command denied to user 'lucia'@'localhost' for table 'rental'

INSERT INTO rental (rental_date, inventory_id, customer_id, return_date, staff_id, last_update) 
VALUES(CURRENT_TIMESTAMP(), 0, 0, '', 0, CURRENT_TIMESTAMP());

-- EN inventory si que es pot fer el INSERT
INSERT INTO inventory (film_id, store_id, last_update) 
VALUES(1, 1, CURRENT_TIMESTAMP());

-- Ex 13

CREATE USER 'sergio'@'localhost'
IDENTIFIED BY 'nose';

GRANT ALL PRIVILEGES
ON sakila.* TO 'sergio'@'localhost'
WITH GRANT OPTION;

-- Ex 14

grant select
on sakila.* to 'marta'@'localhost';

-- Ex 15
create user 'pepe'@'localhost'
identified by 'super3';

-- Access denied; you need (at least one of) the CREATE USER privilege(s) for this operation

-- Ex 16
CREATE ROLE relacions_publiques;

-- Ex 17

GRANT SELECT, INSERT, UPDATE, DELETE
ON sakila.address TO relacions_publiques;

GRANT SELECT, INSERT, UPDATE, DELETE
ON sakila.city TO relacions_publiques;

GRANT SELECT, INSERT, UPDATE, DELETE
ON sakila.country TO relacions_publiques;

GRANT SELECT (first_name, last_name, email)
ON sakila.customer TO relacions_publiques;

GRANT SELECT (first_name, last_name, email)
ON sakila.staff TO relacions_publiques;

-- Ex 18

REVOKE SELECT
ON sakila.* FROM 'marta'@'localhost';

SHOW GRANTS FOR 'marta'@'localhost';

-- Els demes permisos ya els te de la activitat de abans

-- Ex 19

ALTER USER 'marta'@'localhost' ACCOUNT LOCK;

-- Ex 20

ALTER USER 'joseluis'@'localhost'
WITH 
	MAX_CONNECTIONS_PER_HOUR 5
	MAX_QUERIES_PER_HOUR 30
	MAX_USER_CONNECTIONS 2;

-- Ex 21

SHOW GRANTS FOR 'marta'@'localhost';
SHOW GRANTS FOR 'joseluis'@'localhost';
SHOW GRANTS FOR 'sergio'@'localhost';
SHOW GRANTS FOR emmagatzematge;
SHOW GRANTS FOR relacions_publiques;

-- Ex 22
CREATE VIEW usuaris_pmaxim AS (
	SELECT u.User
	FROM mysql.user u
	WHERE u.Grant_priv = 'Y' AND (u.User NOT LIKE 'root' AND u.User NOT LIKE 'admin')
);


