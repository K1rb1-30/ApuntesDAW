DROP DATABASE IF EXISTS anime_db;

-- Crear la base de datos
CREATE DATABASE anime_db;
USE anime_db;

-- Crear la tabla principal
CREATE TABLE animes (
    idanimes INT(11) NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(100) DEFAULT NULL,
    edad INT(11) DEFAULT NULL,
    numpersonatges INT DEFAULT 0,
    personatges TEXT,
    CONSTRAINT pk_animes PRIMARY KEY (idanimes)
);

-- Inserts de ejemplo
INSERT INTO animes (titulo, edad, numpersonatges, personatges)
VALUES 
('Naruto', 16, 5, 'Naruto, Sasuke, Sakura, Kakashi, Gaara'),

('One Piece', 19, 6, 'Luffy, Zoro, Nami, Sanji, Usopp, Chopper'),

('Attack on Titan', 15, 4, 'Eren, Mikasa, Armin, Levi'),

('Dragon Ball Z', 18, 5, 'Goku, Vegeta, Gohan, Piccolo, Trunks'),

('Death Note', 17, 3, 'Light Yagami, L, Ryuk');