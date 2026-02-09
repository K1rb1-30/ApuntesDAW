const texto = document.getElementById("texto");
const lista = document.getElementById("llistaTasques");
function Afegir(){
    let value = texto.value
    const li = document.createElement("li")
    li.innerText = texto.value+" ";

    const btnInput = document.createElement("button")
    btnInput.innerText = "Input"
    li.appendChild(btnInput)

    const btnDelete = document.createElement("button")
    btnDelete.innerText = "Delete"
    li.appendChild(btnDelete)

    lista.appendChild(li)
}