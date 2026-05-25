<?php

$servername = "localhost";
$username = "root";
$password = "root";
$dbname = "ap5php";

try {
    $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
    $email = $_POST["email"];
    $pswd = $_POST["pswd"];

    try {
        $query = $conn->prepare("select * from usuari where  :email OR :pswd)");
        $query->bindParam(":email", $email);
        $query->bindParam(":pswd", $pswd);
        $query->execute();

        // si devuelve la consulta es que existe
        if ($query->rowCount() < 0) {
            $resposta = [
                "estatus" => "OK",
                "error"=> "",
                "usuari_app" => $email
            ];

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
