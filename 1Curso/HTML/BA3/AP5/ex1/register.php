<?php

$servername = "localhost";
$username = "root";
$password = "root"; // Cambiar a super3 si es con el portatil de clase y sino root
$dbname = "ap5php";

try {
    $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
    $email = $_POST["email"];
    $pswd = $_POST["pswd"];

    try {
        if(!str_contains($email, "@ies-sabadell.cat")) {
            $resposta = [
                "estatus" => "KO",
                "error"=> "correu incorrecte",
                "usuari_app" => $email
            ];
            print_r(json_encode($resposta));
            exit;
        }

        $query = $conn->prepare("select * from usuari where email = :email");
        $query->bindParam(":email", $email);
        $query->execute();

        // Si no devuelve la consulta es que no existe
        if ($query->rowCount() == 0) {

            $resposta = [
                "estatus" => "OK",
                "error"=> "",
                "usuari_app" => $email
            ];

            $query = $conn->prepare("insert into usuari (email, contrasenya) VALUES (:email, :pswd)");
            $query->bindParam(":email", $email);
            $query->bindParam(":pswd", $pswd);
            $query->execute();

            print_r(json_encode($resposta));
        }else{
            $resposta = [
                "estatus" => "KO",
                "error"=> "L'usuari existeix",
                "usuari_app" => $email
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
