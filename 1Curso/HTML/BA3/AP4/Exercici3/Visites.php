<?php

session_start();

if(isset($_SESSION["visites"])){
    $_SESSION["visites"]++;
}else{
    $_SESSION["visites"] = 1;
}


