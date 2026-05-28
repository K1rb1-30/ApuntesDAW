<?php

$servername = "localhost";
$username = "root";
$password = "super3"; // Cambiar a super3 si es con el portatil de clase y sino root
$dbname = "productesExamen";

try {
    $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
    $nomIn = $_POST["nomIn"];
    $preuIn = $_POST["preuIn"];
    $stockIn = $_POST["stockIn"];

    try {
        $query = $conn->prepare("select * from productes where nomProducte = :nomIn");
        $query->bindParam(":nomIn", $nomIn);
        $query->execute();

        // Si no devuelve la consulta es que no existe
        if ($query->rowCount() == 0) {

            $query = $conn->prepare("insert into productes (nomProducte, preu, stock) VALUES (:nomIn, :preuIn, :stockIn)");
            $query->bindParam(":nomIn", $nomIn);
            $query->bindParam(":preuIn", $preuIn);
            $query->bindParam(":stockIn", $stockIn);
            $query->execute();

            $resposta = [
                "estatus" => "OK",
                "mensaje"=> "S'ha inserit correctament"
            ];

            print_r(json_encode($resposta));
        }else{
            $resposta = [
                "estatus" => "KO",
                "mensaje"=> "Ja existeix aquest producte a la BD"
            ];
            print_r(json_encode($resposta));
        }

        #$result = $query->fetchAll(PDO::FETCH_ASSOC);
        #print_r(json_encode($result));

    } catch (Exception $exception) {
        $resposta = [
            "estatus" => "KO",
            "mensaje"=> "Ha hagut un problema a l'hora de realitzar l'actualització"
        ];
        print_r(json_encode($resposta));
    }

} catch (PDOException $e) {
    $resposta = [
        "estatus" => "KO",
        "mensaje"=> "Ha hagut un problema a l'hora de realitzar l'actualització"
    ];
    print_r(json_encode($resposta));
}
