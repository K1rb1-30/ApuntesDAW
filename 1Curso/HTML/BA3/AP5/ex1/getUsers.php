<?php

$servername = "localhost";
$username = "root";
// cambiar si es para el de casa es root y si no es super3
$password = "root";
$dbname = "ap5php";

try {
    $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
    try {
        $query = $conn->prepare("select * from usuari");
        $query->execute();
        $result = $query->fetchAll(PDO::FETCH_ASSOC);
        print_r(json_encode($result));

    } catch (Exception $exception) {
        print_r($exception->getMessage());
    }

} catch (PDOException $e) {
    echo "Connection failed: " . $e->getMessage();
}
