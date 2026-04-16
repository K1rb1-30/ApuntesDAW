const input = document.getElementById("input");
const p = document.getElementById("p");

input.addEventListener("change", () => {
    texto = input.value;

    let lista = texto.split(" ");

    console.log(lista)

    let textoCompleto = "";

    for (let i = 0; i < lista.length; i++) {
        let par = ""
        if (lista[i].length % 2 === 0){
            par = lista[i].toLowerCase();
        }else{
            par = lista[i].toUpperCase();
        }

        textoCompleto += par + " ";
    }

    p.innerText = textoCompleto;
})

