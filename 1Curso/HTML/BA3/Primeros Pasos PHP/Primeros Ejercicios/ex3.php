<?php

$cadena = '';

function cadena(){
    global $cadena;
    for ($i = 0; $i < 5; $i++) {
        $cadena .= chr(rand(97, 122));
    }
    echo "<br>".$cadena;
    if ($cadena == strrev($cadena)) {

        echo "<br>"."SI es un palindrom";
    }
}

cadena();



