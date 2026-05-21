DROP DATABASE IF EXISTS ap5php;

CREATE DATABASE ap5php CHARACTER SET utf8;

USE ap5php;

CREATE TABLE usuari(
    idUsuari int AUTO_INCREMENT,
	email	VARCHAR(40),
	contrasenya VARCHAR(50),
	CONSTRAINT pk_usuari PRIMARY KEY (idUsuari)
);