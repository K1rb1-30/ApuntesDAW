<?php

session_start();
if (isset($_SESSION["Puntuacio"]) and isset($_SESSION["nomVideojoc"])) {
    echo "No hi ha videojoc";
}
else{
    echo "Nom videjoc: ".$_SESSION["NomVideojoc"]."<br>";
    echo "Puntuacio: ".$_SESSION["Puntuacio"]."<br>";
}