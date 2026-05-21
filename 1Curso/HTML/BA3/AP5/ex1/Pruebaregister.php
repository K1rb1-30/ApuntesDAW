<?php
header("Content-Type: application/json; charset=utf-8");

$servername = "localhost";
$dbname = "basedatos";
$username = "root";
$password = "";

$response = [];

try {
    // CONEXIÓN PDO
    $conn = new PDO(
        "mysql:host=$servername;dbname=$dbname;charset=utf8",
        $username,
        $password,
        [
            PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
            PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC
        ]
    );

    // RECIBIR DATOS (para jQuery AJAX)
    $email = $_POST["email"] ?? null;
    $pswd  = $_POST["pswd"] ?? null;

    // VALIDACIONES BÁSICAS
    if (!$email || !$pswd) {
        echo json_encode([
            "estat" => "KO",
            "error" => "Falten dades",
            "usuari_app" => $email
        ]);
        exit;
    }

    if (!str_contains($email, "@instituto.com")) {
        echo json_encode([
            "estat" => "KO",
            "error" => "correu incorrecte",
            "usuari_app" => $email
        ]);
        exit;
    }

    // COMPROBAR SI EXISTE USUARIO
    $check = $conn->prepare("SELECT email FROM usuarios WHERE email = :email");
    $check->bindParam(":email", $email);
    $check->execute();

    if ($check->rowCount() > 0) {
        echo json_encode([
            "estat" => "KO",
            "error" => "L'usuari existeix",
            "usuari_app" => $email
        ]);
        exit;
    }

    // INSERTAR USUARIO
    $insert = $conn->prepare("INSERT INTO usuarios (email, password) VALUES (:email, :pswd)");
    $insert->bindParam(":email", $email);
    $insert->bindParam(":pswd", $pswd);

    $insert->execute();

    echo json_encode([
        "estat" => "OK",
        "error" => "",
        "usuari_app" => $email
    ]);

} catch (PDOException $e) {
    echo json_encode([
        "estat" => "KO",
        "error" => "Error connexió o BD: " . $e->getMessage()
    ]);
}