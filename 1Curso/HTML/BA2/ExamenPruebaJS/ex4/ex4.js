
const mostrarlista = document.getElementById("lista")
const p = document.getElementById("resultado")
function Generar(){
    const n = Math.floor(Math.random() * 20) + 1;
    const lista = new Set();

    for (let i = 0; i < n; i++) {
        lista.add(Math.floor(Math.random() * 20) + 1)
    }

    let listaenumerada = "La lista de numeros son: "

    const rang = Math.floor(Math.random() * 20) + 1;

    let contador = 0;
    let resultat = `El rang es ${rang} y els nombres que estan per sobre son: `
    for (const item of lista) {
        listaenumerada += `${item} `
        if(item > rang){
            contador++;
            resultat += `${item} `
        }
    }

    mostrarlista.innerText = listaenumerada
    p.innerText = resultat

}