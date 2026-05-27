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

    (
        'Naruto',
        16,
        5,
        '[
            {"personatge":"Naruto","ordre":1},
            {"personatge":"Sasuke","ordre":2},
            {"personatge":"Sakura","ordre":3},
            {"personatge":"Kakashi","ordre":4},
            {"personatge":"Gaara","ordre":5}
        ]'
    ),

    (
        'One Piece',
        19,
        6,
        '[
            {"personatge":"Luffy","ordre":1},
            {"personatge":"Zoro","ordre":2},
            {"personatge":"Nami","ordre":3},
            {"personatge":"Sanji","ordre":4},
            {"personatge":"Usopp","ordre":5},
            {"personatge":"Chopper","ordre":6}
        ]'
    ),

    (
        'Attack on Titan',
        15,
        4,
        '[
            {"personatge":"Eren","ordre":1},
            {"personatge":"Mikasa","ordre":2},
            {"personatge":"Armin","ordre":3},
            {"personatge":"Levi","ordre":4}
        ]'
    ),

    (
        'Dragon Ball Z',
        18,
        5,
        '[
            {"personatge":"Goku","ordre":1},
            {"personatge":"Vegeta","ordre":2},
            {"personatge":"Gohan","ordre":3},
            {"personatge":"Piccolo","ordre":4},
            {"personatge":"Trunks","ordre":5}
        ]'
    ),

    (
        'Death Note',
        17,
        3,
        '[
            {"personatge":"Light Yagami","ordre":1},
            {"personatge":"L","ordre":2},
            {"personatge":"Ryuk","ordre":3}
        ]'
    );