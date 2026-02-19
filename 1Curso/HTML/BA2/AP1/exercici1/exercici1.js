
const p = document.getElementById("texto")

function Crear(){
    const puntsinicials = 50
    const bonificacio = 10
    const penalitzacio = 5
    const missatge = "El teu perfil és: "

    const suma = puntsinicials + bonificacio
    const resta = suma - penalitzacio
    const multiplica = resta * 2
    const divi = multiplica / 5

    p.innerText = missatge + divi;
}