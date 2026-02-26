
const producte = document.getElementById("Pro")
const preu = document.getElementById("Preu")
const tabla = document.getElementById("tabla")

const stock = new Map();

function Afegir(){

    const grupo = document.createElement("tr")
    const tdpro = document.createElement("td")
    const tdpreu = document.createElement("td")
    tdpro.innerText = producte.value
    tdpreu.innerText = preu.value
    grupo.append(tdpro, tdpreu)
    tabla.append(grupo)

    stock.set(producte.value, preu.value)
}




