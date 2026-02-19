const tabla = document.getElementById("tabla")

function ponerNota(){

    const conjunto = document.createElement("tr")


    const input = document.getElementById('input')
    const nota = Math.floor(Math.random()* 11)
    const nombretable = document.createElement("td")
    const notatable = document.createElement("td")

    nombretable.innerText = input.value;
    notatable.innerText = nota

    conjunto.appendChild(nombretable)
    conjunto.appendChild(notatable)

    if(nota < 5){
        conjunto.style.backgroundColor="red"
        conjunto.style.color="white"
    }

    tabla.appendChild(conjunto)


}