const dia = document.getElementById("dia")
const mes = document.getElementById("mes")
const anys = document.getElementById("any")

const p = document.getElementById("texto")

function boto(){
    const data1 = new Date(anys.value, mes.value, dia.value)

    const data2 = Date.now();

    const diferencia = (data1.getTime() - data2.getTime()) / (1000 * 3600 * 24);

    p.innerText = "La diferencia es de " + diferencia;
}