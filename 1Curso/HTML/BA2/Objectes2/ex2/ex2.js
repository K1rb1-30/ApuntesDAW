
const cont = document.getElementById("cont")
function Contador(){
    // clearInterval(interval)
    let contador = 10;
    interval = setInterval(() => {
            if (contador >= 0){
                cont.innerText = contador;
                contador--
            }
        }, 1000)
}