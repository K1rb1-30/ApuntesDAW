<?php

$nom = $_POST["nom"];
$numeroJug = $_POST["num"];
$numeroRan= rand(1,10);
session_start();

$_SESSION["NomJug"] = $nom;

if($numeroJug == $numeroRan){
    $_SESSION["Missatge"] = "L'usuari ha encertat";
}else {
    $_SESSION["Missatge"] = "L'usuari ha fallat";
}