const text = document.getElementById("comptador");

let contador = 10;
function Iniciar(){
    contador = 10;
    interval = setInterval(() => {
        if (contador >= 0){
            text.innerText = contador;
            contador--
        }
    }, 1000)
}