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


