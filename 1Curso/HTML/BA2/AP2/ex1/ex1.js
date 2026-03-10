
const taula = document.getElementById("tbody")

const monitors = new Map([
    [1234, {
        nom : "patata",
        amplada: 1920,
        alzada: 1080,
        polzades: 24,
        hercis: 60
    }],
    [3017,{
        nom : "HP",
        amplada: 1920,
        alzada: 1080,
        polzades: 27,
        hercis: 120
    }],
    [2145,{
        nom : "MSI",
        amplada: 1920,
        alzada: 1080,
        polzades: 24,
        hercis: 100
    }]
]);

function Afegir(){


    for (const [clave, valor] of monitors) {
        const row = document.createElement("tr")

        const cod = document.createElement("td")
        const nom = document.createElement("td")
        const amplada = document.createElement("td")
        const alzada = document.createElement("td")
        const polzades = document.createElement("td")
        const hercis = document.createElement("td")

        cod.innerText = clave
        nom.innerText = monitors.get(clave).nom
        amplada.innerText = monitors.get(clave).amplada
        alzada.innerText = monitors.get(clave).alzada
        polzades.innerText = monitors.get(clave).polzades
        hercis.innerText = monitors.get(clave).hercis

        row.appendChild(cod)
        row.appendChild(nom)
        row.appendChild(amplada)
        row.appendChild(alzada)
        row.appendChild(polzades)
        row.appendChild(hercis)
        
        taula.appendChild(row)
    }
}