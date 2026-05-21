<?php

$servername = "localhost";
$username = "root";
// cambiar si es para el de casa es root y si no es super3
$password = "super3";
$dbname = "MinaDB";

try {
    $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
    $nomusu = $_POST["nomUsuari"];
    $pass = $_POST["contrasenya"];
    try { //Miramos si las creeedenciales puestas en las variable existen
        $query = $conn->prepare("select * from usuaris where nomUsuari = :nomusu AND contrasenya = :pass");
        $query->bindParam(":nomusu", $nomusu);
        $query->bindParam(":pass", $pass);
        $query->execute();

        // si devuelve la consulta es que existe
        if ($query->rowCount() > 0) {
            $resposta = [
                "estatus" => "OK",
                "missatge" =>"Usuari login correctament."
            ];
            //seteamos cookie
            setcookie("usuari", $nomusu, time() + (86400 * 30));
            print_r(json_encode($resposta));

        }else{
            $resposta = [
                "estatus" => "KO",
                "missatge" => "usuari o contrasenya incorrecte"
            ];
            print_r(json_encode($resposta));
        }



        #$result = $query->fetchAll(PDO::FETCH_ASSOC);
        #print_r(json_encode($result));

    } catch (Exception $exception) {
        print_r($exception->getMessage());
    }

} catch (PDOException $e) {
    echo "Connection failed: " . $e->getMessage();
}

