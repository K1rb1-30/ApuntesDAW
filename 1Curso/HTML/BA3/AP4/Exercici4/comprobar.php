<?php

$n1 = $_POST["n1"];
$n2 = $_POST["n2"];
$n3 = $_POST["n3"];
$n4 = $_POST["n4"];

$arrayRandom = [rand(1, 10), rand(1, 10), rand(1, 10), rand(1, 10)];

echo "L'array es: Array (";

foreach ($arrayRandom as $i => $num){
    echo "[$i] => $num ";
}
echo ")<br>";
function isInArray($num){
    global $arrayRandom;
    if(in_array($num, $arrayRandom)){
        echo "El nombre $num es troba a dintre de l'array.";
    }else{
        echo "El nombre $num NO es troba a dintre de l'array.";
    }
    echo "<br>";
}

isInArray($n1);
isInArray($n2);
isInArray($n3);
isInArray($n4);


