<?php

$nomVideojoc=$_GET["nomVideojoc"];

session_start();
$_SESSION["NomVideojoc"]=$nomVideojoc;
$_SESSION["Puntuacio"]=random_int(0,10);

