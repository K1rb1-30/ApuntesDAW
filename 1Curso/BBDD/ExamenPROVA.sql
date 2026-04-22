DROP DATABASE IF EXISTS examen_prova;

CREATE DATABASE examen_prova CHARACTER SET utf8;

USE examen_prova;

CREATE TABLE INSTRUCTOR(
	id_instructor int AUTO_INCREMENT,
	nom VARCHAR(30) NOT NULL,
	cognom1 VARCHAR(30) NOT NULL,
	cognom2 VARCHAR(30),
	especialitat varchar(100) UNIQUE,
	email varchar(40) UNIQUE,
	CONSTRAINT pk_instructor PRIMARY KEY (id_instructor)
);

CREATE TABLE CURS(
	id_curs int AUTO_INCREMENT,
	titol VARCHAR(30) UNIQUE,
	description VARCHAR(30) NOT NULL,
	nivell ENUM('Basc', 'Intermedi', 'Avancat') NOT NULL,
	preu DECIMAL(5, 2) NOT NULL,
	data_publicacio DATE,
	id_instructor int,
	id_curs_prerequisit int,
	CONSTRAINT pk_curs PRIMARY KEY (id_curs),
	CONSTRAINT fk_curs_reflexiva FOREIGN KEY (id_curs_prerequisit) REFERENCES CURS(id_curs),
	CONSTRAINT fk_instructor FOREIGN KEY (id_instructor) REFERENCES INSTRUCTOR(id_instructor) ON DELETE RESTRICT
);

CREATE TABLE ESTUDIANT(
	id_estudiant int AUTO_INCREMENT,
	nom	VARCHAR(50) NOT NULL,
	email VARCHAR(30) UNIQUE,
	data_registre DATETIME DEFAULT CURRENT_TIMESTAMP(),
	CONSTRAINT pk_estudiant PRIMARY KEY (id_estudiant)
);

CREATE TABLE inscripcio(
	id_curs int,
	id_estudiant int,
	data DATETIME DEFAULT CURRENT_TIMESTAMP(),
	percentatge int DEFAULT 0,
	CONSTRAINT pk_inscripcio PRIMARY KEY (id_curs, id_estudiant),
	CONSTRAINT fk_curs FOREIGN KEY (id_curs) REFERENCES CURS(id_curs) ON DELETE CASCADE,
	CONSTRAINT fk_estudiant FOREIGN KEY (id_estudiant) REFERENCES ESTUDIANT(id_estudiant) ON DELETE CASCADE
);

