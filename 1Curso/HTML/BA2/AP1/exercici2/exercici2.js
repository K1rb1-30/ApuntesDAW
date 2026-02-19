const btn = document.getElementById("btn");
const resultado = document.getElementById("resultado");

function saludo(){

    let hora = Math.floor(Math.random() * 24);
    let salutacio = hora <= 12 ? "Bon dia" : "Bona tarda";

    resultado.innerText = `Son les ${hora}:00 ${salutacio}`;
}