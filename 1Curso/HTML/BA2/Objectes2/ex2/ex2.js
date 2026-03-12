
const cont = document.getElementById("cont")
function Contador(){
    let contador = 10;
    setInterval(() => {
            if (contador >= 0){
                cont.innerText = contador;
                contador--
            }
        }, 1000)
}