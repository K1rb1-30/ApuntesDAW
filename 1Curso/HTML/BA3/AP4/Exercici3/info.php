<?php

session_start();

if(isset($_SESSION["visites"])){
    echo "Nombre de Visites: " . $_SESSION["visites"];
}else{
    echo "La pagina encara no s'ha visitat";
}
