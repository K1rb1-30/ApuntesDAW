const input = document.getElementById("input");
const btn = document.getElementById("btn")
const p = document.getElementById("p");

function Pepe(){
    texto = input.value;

    let lista = texto.split(" ");

    console.log(lista);

    let palabrasE = "";

    for (let i = 0; i < lista.length; i++) {
        let letraseparada = lista[i].split("")
        let par = ""
        if (letraseparada.includes("e") || letraseparada.includes("E")){
            par = lista[i];
            palabrasE += par + ", ";
        }
    }

    p.innerText = palabrasE;
}