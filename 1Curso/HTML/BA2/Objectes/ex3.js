const dia = document.getElementById("dia")
const mes = document.getElementById("mes")
const anys = document.getElementById("any")

const p = document.getElementById("texto")

function boto(){
    const data1 = new Date(anys.value, mes.value-1, dia.value)

    const data2 = new Date()

    const diferenciaMilisegons = data2.getTime() - data1.getTime();

    const diferenciaDies = Math.abs(Math.floor(diferenciaMilisegons/ (1000 * 60 * 60 * 24)))

    p.innerText = "La diferencia es de " + diferenciaDies;
}