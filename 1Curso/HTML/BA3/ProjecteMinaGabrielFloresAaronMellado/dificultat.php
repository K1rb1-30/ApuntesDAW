<?php
$servername = "localhost";
$username = "root";
// cambiar si es para el de casa es root y si no es super3
$password = "super3";
$dbname = "MinaDB";

try {
    $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
    $dificulatat = $_POST["dificultat"];
    try {// recogemos la fila de la dificultat deseada
        $query = $conn->prepare("select * from configuraciopartida where dificultat = :dificultat");
        $query->bindParam(":dificultat", $dificulatat);
        $query->execute();
        $result = $query->fetchAll(PDO::FETCH_ASSOC);
        print_r(json_encode($result)); // lo enviamos en json

        #$result = $query->fetchAll(PDO::FETCH_ASSOC);
        #print_r(json_encode($result));

    } catch (Exception $exception) {
        print_r($exception->getMessage());
    }

} catch (PDOException $e) {
    echo "Connection failed: " . $e->getMessage();
}