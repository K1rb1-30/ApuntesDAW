<?php

$nlineas = rand(1, 20);

function triangle(){
    global $nlineas;
    for($i = 0; $i < $nlineas; $i++){
        for($j = 0; $j < $nlineas - $i ; $j++){
            echo "x";
        }
        echo "<br>";
    }
}
triangle();
echo "<br>".$nlineas;
