drop database if exists MinaDB;
create database MinaDB;

use MinaDB;
create table configuracioPartida(
	dificultat varchar(20) primary key,
    QuantitatCaselles int,
    QuantitatMines int,
    DanyMines int,
    bonusDiamant int,
    bonusFerro int,
    bonusCoure int
);

insert into configuracioPartida values("facil", 20, 5, 10, 3, 2, 1), ("normal", 50, 20, 20, 8, 4, 2), ("dificil", 60, 40, 40, 20, 15, 10);


create table usuaris(
	nomUsuari varchar(20) primary key,
    contrasenya varchar(30),
    score int default 0
);

insert into usuaris (nomusuari, contrasenya) values("Jugador1", "123456789"), ("Jugador2", "987654321");