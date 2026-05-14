<?php

$servername = "localhost";
$username = "root";
$password = "super3";
$dbname = "animedb";

try {
    $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
    $nom = $_POST["nom"];
    $edat = $_POST["edat"];
    try {
        $query = $conn->prepare("insert into animes values(:nom, :edat)");
        $query->bindParam(":nom", $nom);
        $query->bindParam(":edat", $edat);
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

