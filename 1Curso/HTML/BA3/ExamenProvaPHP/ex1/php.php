<?php

$nom = $_GET["vj"];
$nota = rand(1,10);
session_start();

$_SESSION["vjNom"] = $nom;
$_SESSION["vjNota"] = $nota;

print_r($nom .' '. $nota);



