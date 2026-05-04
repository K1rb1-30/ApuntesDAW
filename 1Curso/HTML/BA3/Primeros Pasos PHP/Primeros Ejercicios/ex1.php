<?php

$aleatorio = rand(1, 10);

function tablamultiplicar(){
    global $aleatorio;
    echo "Tabla del ".$aleatorio."<br>";

    for($i = 0; $i < 11; $i++){
        echo $aleatorio."*".$i." = ".$aleatorio * $i."<br>";
    }
}

tablamultiplicar();
