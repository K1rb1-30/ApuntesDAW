const texto = document.getElementById("texto");
const lista = document.getElementById("lista");
function AfegirPrimer() {
    let value = texto.value

    if(value === ""){
        value = "Element Nou"
    }
    const li = document.createElement("li")
    li.innerText=value
    lista.prepend(li);
}

function AfegirUltim(){
    let value = texto.value

    if(value === ""){
        value = "Element Nou"
    }
    const li = document.createElement("li")
    li.innerText=value
    lista.append(li);
}

function EliminarPrimer() {
    lista.firstElementChild.remove()

}

function EliminarUltim(){
    lista.lastElementChild.remove()
}
