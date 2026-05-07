<?php

function volumEsfera($radi){

    $volum = (4/3) * M_PI * ($radi**3);

    echo "Una esfera de ".$radi."cm te un volum de ".$volum."cm";
}

function volumCilindre($radi, $altura){
    $volumcil = M_PI * ($radi**2) * $altura;
    echo "Un cilindre de ".$radi."cm te un volum de ".$volumcil."cm";
}
