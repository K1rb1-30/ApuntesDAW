<?php

$servername = "localhost";
$username = "root";
$password = "super3";
$dbname = "animedb";

try {
    $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
    $edat = $_POST["edat"];
    try {
        $query = $conn->prepare("select * from animes where edatPublic <= :edat");
        $query->bindParam(":edat", $edat, PDO::PARAM_INT);
        $query->execute();
        $result = $query->fetchAll(PDO::FETCH_ASSOC);
        print_r(json_encode($result));

    } catch (Exception $exception) {
        print_r($exception->getMessage());
    }

} catch (PDOException $e) {
    echo "Connection failed: " . $e->getMessage();
}

