<?php

$servername = "localhost";
$username = "root";
// cambiar si es para el de casa es root y si no es super3
$password = "super3";
$dbname = "videojocExamen";

try {
    $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
    $nomvj = $_POST["vj"];
    try { //Miramos si las creeedenciales puestas en las variable existen
        $query = $conn->prepare("select * from videojocs where TitolVideojoc = :nomvj");
        $query->bindParam(":nomvj", $nomvj);
        $query->execute();

        // si devuelve la consulta es que existe
        if ($query->rowCount() > 0) {

            $result = $query->fetch(PDO::FETCH_ASSOC);

            if (intval($result["puntuació"])>= 10) {
                $resposta = [
                    "estatus" => "OK",
                    "missatge" =>"El videojoc existeix i és una passada"
                ];
            }else{
                $resposta = [
                    "estatus" => "OK",
                    "missatge" =>"El videojoc existeix i no és excel·lent."
                ];
            }


            print_r(json_encode($resposta));

        }else{
            $resposta = [
                "estatus" => "KO",
                "missatge" => "El videojoc no existeix!"
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
