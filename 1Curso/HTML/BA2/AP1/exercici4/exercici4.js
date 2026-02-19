
const div = document.createElement("div")
document.body.appendChild(div)

function Mostrar(){

    const input = document.getElementById('input')
    const nombre = document.createElement("p")
    nombre.innerText = input.value

    let total = 0
    const lista = document.createElement("ul")

    for (let index = 0; index < 10; index++) {
        const elemento = document.createElement("li")
        const valor = Math.floor(Math.random() * 11)
        elemento.innerText = valor
        total += valor
        console.log(total)
        lista.appendChild(elemento)
    }

    const notaSpan = calcularnota(total)
    nombre.appendChild(notaSpan)
    nombre.appendChild(document.createTextNode(` Total: ${total}`))

    div.innerHTML = ""
    div.appendChild(nombre)
    div.appendChild(lista)
}

function calcularnota(total) {
    const tipo = document.createElement("span")
    if(total < 50){
        tipo.innerText = " Suspens"
        tipo.style.color = "red"
    }else if (total < 70) {
        tipo.innerText = " Aprovat"
        tipo.style.color = "yellow"
    }else if (total < 90) {
        tipo.innerText = " Notable"
        tipo.style.color = "blue"
    }else if (total >= 90) {
        tipo.innerText = " Excel·lent"
        tipo.style.color = "green"
    }

    console.log(tipo)
    return tipo
}
