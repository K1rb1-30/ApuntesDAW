<?php
$usuari = "";

for ($i = 0; $i < 10; $i++) {
    $usuari .= chr(rand(65,133));
}

setcookie("usuari", $usuari, time() + 3600);
