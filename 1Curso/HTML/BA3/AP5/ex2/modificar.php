<?php

$servername = "localhost";
$username = "root";
$password = "root"; // Cambiar a super3 si es con el portatil de clase y sino root
$dbname = "anime_db";

try {
    $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
    $idanime = intval($_POST["idanime"]);
    $nomper = $_POST["nomper"];
    $ordre = $_POST["ordre"];

    try {

        $query = $conn->prepare("select * from animes where idanimes = :idanime");
        $query->bindParam(":idanime", $idanime);
        $query->execute();

        // si devuelve la consulta es que existe
        if ($query->rowCount() > 0) {

            $result = $query->fetch(PDO::FETCH_ASSOC);

            $personatges = [];

            if($result["personatges"] != null && $result["personatges"] != ""){
                $decoded = json_decode($result["personatges"], true);

                if(is_array($decoded)){
                    $personatges = $decoded;
                }
            }

            $nuevoPer = [
                "personatge" => $nomper,
                "ordre" => $ordre
            ];

            $personatges[] = $nuevoPer;

            $jsonPers = json_encode($personatges, JSON_UNESCAPED_UNICODE);

            $update = $conn->prepare("update animes set personatges = :personatges, numpersonatges = numpersonatges + 1 where idanimes = :idanime");
            $update->bindParam(":personatges", $jsonPers);
            $update->bindParam(":idanime", $idanime);
            $update->execute();

            $resposta = [
                "estatus" => "OK",
                "missatge" => "S'ha guardat correctament el registre"
            ];

            print_r(json_encode($resposta));

        }else{
            $resposta = [
                "estatus" => "KO",
                "missatge" => "El anime no existeix!"
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