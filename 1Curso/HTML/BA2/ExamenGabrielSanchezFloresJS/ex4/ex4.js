
const cont = document.getElementById("contenidor")
function Cambiar(){
    const selec = document.getElementById("select")

    selec.classList.add(selec.value)
    cont.appendChild(selec)
}