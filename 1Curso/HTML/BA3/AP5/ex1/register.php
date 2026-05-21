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
        $query = $conn->prepare("insert into usuari values(:email, :pswd)");
        $query->bindParam(":email", $email);
        $query->bindParam(":pswd", $pswd);
        $query->execute();
        $result = $query->fetchAll(PDO::FETCH_ASSOC);
        print_r(json_encode($result));

    } catch (Exception $exception) {
        print_r($exception->getMessage());
    }

} catch (PDOException $e) {
    echo "Connection failed: " . $e->getMessage();
}
