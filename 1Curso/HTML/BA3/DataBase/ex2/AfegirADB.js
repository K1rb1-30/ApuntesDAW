
const titolIn = document.getElementById("Titol");
const edatIn = document.getElementById("edat")

function afegir(){
    $.ajax({
        method:"POST",
        url:"mostrarTots.php",
        data:{"nom":titolIn.value,"edat":edatIn.value},
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