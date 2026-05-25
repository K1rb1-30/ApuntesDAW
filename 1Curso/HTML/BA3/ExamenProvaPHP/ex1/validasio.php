<?php

session_start();

if (isset($_SESSION["vjNom"]) AND isset($_SESSION["vjNota"])) {
    echo $_SESSION["vjNom"]." ".$_SESSION["vjNota"];
}else{
    echo "no existeix";
}
