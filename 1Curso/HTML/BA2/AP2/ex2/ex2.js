
const taula = document.getElementById("taula")

function Afegir(){

    const inCOD = document.getElementById("inCOD").value
    const inNom = document.getElementById("inNom").value
    const inAmplada = document.getElementById("inAmplada").value
    const inAlçada = document.getElementById("inAlçada").value
    const inPolzades = document.getElementById("inPolzades").value
    const inHercis = document.getElementById("inHercis").value

    const monitors = [
        {
            COD: 1234,
            nom : "patata",
            amplada: 1920,
            alzada: 1080,
            polzades: 24,
            hercis: 60

        },
        {
            COD: 3017,
            nom : "HP",
            amplada: 1920,
            alzada: 1080,
            polzades: 27,
            hercis: 120

        },
        {
            COD: 2145,
            nom : "MSI",
            amplada: 1920,
            alzada: 1080,
            polzades: 24,
            hercis: 100

        }
    ]

    //Exercici 2
    const monitor = {
        COD: inCOD,
        nom : inNom,
        amplada: inAmplada,
        alzada: inAlçada,
        polzades: inPolzades,
        hercis: inHercis
    }


    monitors.push(monitor)



    for (const item of monitors) {
        const row = document.createElement("tr")

        const cod = document.createElement("td")
        const nom = document.createElement("td")
        const amplada = document.createElement("td")
        const alzada = document.createElement("td")
        const polzades = document.createElement("td")
        const hercis = document.createElement("td")

        cod.innerText = item.COD
        nom.innerText = item.nom
        amplada.innerText = item.amplada
        alzada.innerText = item.alzada
        polzades.innerText = item.polzades
        hercis.innerText = item.hercis

        row.appendChild(cod)
        row.appendChild(nom)
        row.appendChild(amplada)
        row.appendChild(alzada)
        row.appendChild(polzades)
        row.appendChild(hercis)
        
        taula.appendChild(row)
    }


}