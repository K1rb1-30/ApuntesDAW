<?php
session_start();

if (isset($_SESSION["NomJug"]) AND isset($_SESSION["Missatge"])) {
echo $_SESSION["NomJug"]." ".$_SESSION["Missatge"];
}else{
echo "no existeix la sessió";
}