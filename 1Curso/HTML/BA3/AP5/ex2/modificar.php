<?php

$servername = "localhost";
$username = "root";
$password = "root"; // Cambiar a super3 si es con el portatil de clase y sino root
$dbname = "anime_db";

try {
    $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
    $idanime = $_POST["idanime"];
    $nomper = $_POST["nomper"];
    $ordre = $_POST["ordre"];

    if($idanime == "" || $nomper == "" || $ordre == ""){
        $resposta = [
            "estatus" => "KO",
            "missatge" => "Els camps estan buits"
        ];
        print_r(json_encode($resposta));
        exit;
    }

    //esto es pq en la BBDD son int (no lo hago antes para poder comprovar si estan vacios)
    $idanime = intval($_POST["idanime"]);
    $ordre = intval($_POST["ordre"]);

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

            $flag = false; // esto es por si no encuentra el personaje
            foreach ($personatges as &$personatge) { // el & lo que hace es que personatge sea una referencia no una copia.
                if($personatge["personatge"] == $nomper){
                    $flag = true;
                    $personatge["ordre"] = $ordre;
                }
            }

            if($flag == false){
                $resposta = [
                    "estatus" => "KO",
                    "missatge" => "El personatge a modificar no existeix."
                ];
                print_r(json_encode($resposta));
                exit;
            }

            $jsonPers = json_encode($personatges, JSON_UNESCAPED_UNICODE);

            $update = $conn->prepare("update animes set personatges = :personatges where idanimes = :idanime");
            $update->bindParam(":personatges", $jsonPers);
            $update->bindParam(":idanime", $idanime);
            $update->execute();

            $resposta = [
                "estatus" => "OK",
                "missatge" => "S'ha modificat correctament el personatge"
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