const p = document.getElementById("texto")

let lista = [];
function Crear(){

    const num = Math.floor(Math.random() * (150 - 50 + 1) + 50)

    lista.push(num);

    console.log(lista)

    let minimo = 150;
    for (const item of lista) {
        if (item < minimo){
            minimo = item;
        }
    }

    let maximo = 0;
    for (const item of lista) {
        if (item > maximo){
            maximo = item;
        }
    }

    let mediana = 0;

    for (const item of lista) {
        mediana += item;
    }

    console.log(lista.length)
    mediana = Math.round(mediana / lista.length);

    p.innerText = `La array es de ${lista}. El maxim es: ${maximo}, el minim ${minimo} i la mitjana es ${mediana}`



}
