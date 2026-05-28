const preuMin = document.getElementById("preuMin");
const preuMax = document.getElementById("preuMax");

const p = document.getElementById("resultat")
const lista = document.getElementById("listat")
function comparar(){
    $.ajax({
        method:"POST",
        url:"comparar.php",
        data:{  "preuMin":preuMin.value,
            "preuMax":preuMax.value},
        dataType:"json",
        success:function (data) {
           console.log(data)
            p.innerText=""

            while (lista.firstChild) {
                lista.removeChild(lista.firstChild);
            }

            if (data.length > 0){
                for (const article of data) {
                    const li = document.createElement("li")
                    li.innerText=article.nomProducte
                    lista.appendChild(li)
                }
            }else{
                p.innerText="No existeixen productes"
            }


        },
        error: function (jqXHR, textStatus, error){
            console.log(jqXHR);
        }
    });
}