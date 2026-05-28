<?php

$servername = "localhost";
$username = "root";
// cambiar si es para el de casa es root y si no es super3
$password = "super3";
$dbname = "productesExamen";

try {
    $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
    $preuMin = $_POST["preuMin"];
    $preuMax = $_POST["preuMax"];
    try {
        $query = $conn->prepare("select * from productes where preu >= :preuMin AND preu <= :preuMax");
        $query->bindParam(":preuMin", $preuMin);
        $query->bindParam(":preuMax", $preuMax);
        $query->execute();
        $result = $query->fetchAll(PDO::FETCH_ASSOC);
        print_r(json_encode($result));

    } catch (Exception $exception) {
        print_r($exception->getMessage());
    }

} catch (PDOException $e) {
    echo "Connection failed: " . $e->getMessage();
}
