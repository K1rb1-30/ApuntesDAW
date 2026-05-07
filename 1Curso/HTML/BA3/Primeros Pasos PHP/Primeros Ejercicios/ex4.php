<?php

function productes(...$rest){

    $array = [];

    foreach ($rest as $key) {
        $value = rand(1, 10);
        $array[$key] = $value;
    }

    return $array;
}

$patatas = productes("patatas", "esparragos", "acelgas", "haburguesa", "helado", "KFC", "pizza", "bocataLomo", "sandia", "croissant");
$preuTotal = 0;
foreach ($patatas as $key => $value) {
    $preuTotal += $value;
    echo "<br>".$key." ".$value."€";
}
echo "<br>"."Preu Total ".$preuTotal."€";
