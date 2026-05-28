<?php
$servername = "localhost";
$username = "root";
$password = "super3";
$dbname = "videojocExamen";

try {
    $videojoc = $_POST["nomVideojoc"];
    $nouNomvideojoc = $_POST["nouNomVideojoc"];
    $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
    try{
        $query =$conn->prepare ("Select * from videojocs where TitolVideojoc = :nomVideojoc");
        $query->bindParam(":nomVideojoc",$videojoc);
        $query->execute();
        $resultat= $query->fetch(PDO::FETCH_ASSOC);

        $estat="";
        if($query->rowCount() > 0){


                $query =$conn->prepare ("Update videojocs set TitolVideojoc=:nouNomVideojoc where TitolVideojoc = :nomVideojoc");
                $query->bindParam(":nouNomVideojoc",$nouNomvideojoc);
                $query->bindParam(":nomVideojoc",$videojoc);
                $query->execute();

                $estat="OK";



        }
        else{
            $estat="KO";
        }
        $resposta = [

            "estat"=>$estat
        ];
        echo json_encode($resposta);

    } catch (Exception $exception){
        $estat="Error";
        $resposta = [
            "estat"=>$estat,
        ];
        echo json_encode($resposta);
    }
} catch (PDOException $e) {
    $estat="Error";
    $resposta = [
        "estat"=>$estat,
    ];
    echo json_encode($resposta);
}


