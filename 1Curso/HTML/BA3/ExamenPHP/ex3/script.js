const nomIn = document.getElementById("nom")
const preuIn = document.getElementById("preu")
const stockIn = document.getElementById("stock")

const p = document.getElementById("resultat")

function afegir(){
    $.ajax({
        method:"POST",
        url:"afegir.php",
        data:{"nomIn":nomIn.value,"preuIn":preuIn.value,"stockIn":stockIn.value },
        dataType:"json",
        success:function (data) {
            if (data.estatus === "OK"){
                p.style.color="green";
                p.innerText=data.mensaje;
            }else{
                p.style.color="red";
                p.innerText=data.mensaje;
            }

        },
        error: function (jqXHR, textStatus, error){
            console.log(jqXHR);
        }
    });
}