

const croats = []
const samurais = []
const div1 = document.createElement("div")
const div2 = document.createElement("div")
function Crear(){
    const nom = document.getElementById("Nom").value
    const fe = document.getElementById("fe").value
    const resistencia = document.getElementById("resistencia").value
    const clase = document.getElementById("clase").value

    const personaje = {
        nom: nom,
        fe: fe,
        resistencia: resistencia,
        clase: clase,

        retorna: function (){
            return `Nom: ${this.nom} i fe ${this.fe}`
        }
    }

    if(personaje.clase === "Croat"){
        croats.push(personaje)
    }else if (personaje.clase == "Samurai"){
        samurais.push(personaje)
    }
}

function Croats(){
    let mensaje = ""
    div1.replaceChildren()
    for (const item in croats) {
        const p = document.createElement("p")
        mensaje += `El Croat ${croats[item].nom} té ${croats[item].fe} punts de fe i ${croats[item].resistencia}. `
        p.innerText = mensaje
        div1.appendChild(p)
    }
    document.body.appendChild(div1)

}

function Samurais(){
    let mensaje = ""

    div2.replaceChildren()
    for (const item in samurais) {
        const p = document.createElement("p")
        mensaje += `El Samurai ${samurais[item].nom} té ${samurais[item].fe} punts de fe i ${samurais[item].resistencia} de resistencia.`
        p.innerText = mensaje
        div2.appendChild(p)
    }

    document.body.appendChild(div2)

}