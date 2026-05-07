<?php
include "FuncionsVolums.php";

$radiEsfera = rand(1,100);
$radiCilindre = rand(1,100);
$alturaCilindre = rand(1,100);

volumEsfera($radiEsfera);
echo "<br>";
volumCilindre($radiCilindre, $alturaCilindre);


