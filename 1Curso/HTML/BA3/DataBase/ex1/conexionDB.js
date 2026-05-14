const edatIn = document.getElementById("edat");
const p = document.getElementById("p")
function mostrar(){
    $.ajax({
        method:"POST",
        url:"mostrarTots.php",
        data:{"edat":edatIn.value},
        dataType:"json",
        success:function (data) {
            console.log(data);
            for (const anime of data) {
                console.log(anime)
                p.innerText += " " + anime.titol;
            }

        },
        error: function (jqXHR, textStatus, error){
            console.log(jqXHR);
        }
    });
}