const idanime = document.getElementById("idanime")
const nomper = document.getElementById("nomper");
const ordre = document.getElementById("ordre");

const p = document.getElementById("text")
function afegir(){
    $.ajax({
        method:"POST",
        url:"afegir.php",
        data:{  "idanime":idanime.value,
                "nomper":nomper.value,
                "ordre":ordre.value},
        dataType:"json",
        success:function (data) {
            if (data.estatus === "OK"){
                p.style.color="green";
                p.innerText=data.usuari_app;
            }else{
                p.style.color="red";
                p.innerText=data.error+" "+data.usuari_app;
            }

        },
        error: function (jqXHR, textStatus, error){
            console.log(jqXHR);
        }
    });
}