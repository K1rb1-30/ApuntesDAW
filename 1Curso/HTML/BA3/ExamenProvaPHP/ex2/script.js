
const vjInput = document.getElementById("vj")
const p = document.getElementById("p")
function Consulta(){
    $.ajax({
        method:"POST",
        url:"consulta.php",
        data:{"vj":vjInput.value},
        dataType:"json",
        success:function (data) {

            p.innerText= data.missatge

        },
        error: function (jqXHR, textStatus, error){
            console.log(jqXHR);
        }
    });
}