const pe = document.getElementById("pe")

let cont = 0;
if (localStorage.getItem("Contador") !== null){
    cont=Number(localStorage.getItem("Contador"))

}
cont++
localStorage.setItem("Contador", cont)
pe.innerText=contador;

function eliminar(){
    localStorage.removeItem("Contador")
    contador=0;
    pe.innerText=contador;

}


