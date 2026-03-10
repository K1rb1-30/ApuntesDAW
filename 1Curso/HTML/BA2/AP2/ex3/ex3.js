
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

    const inCOD = document.getElementById("inCOD").value
    const inNom = document.getElementById("inNom").value
    const inAmplada = document.getElementById("inAmplada").value
    const inAlçada = document.getElementById("inAlçada").value
    const inPolzades = document.getElementById("inPolzades").value
    const inHercis = document.getElementById("inHercis").value

    //Exercici 2
    if(monitors.has(parseInt(inCOD))){
        alert("El codi de monitor no esta disponible perque ja esta en ús")
    }else{
        monitors.set(parseInt(inCOD), {
            nom : inNom,
            amplada: inAmplada,
            alzada: inAlçada,
            polzades: inPolzades,
            hercis: inHercis
        })
    }

    mostrarTaula()
}

// Exercici 3
function Eliminar(){

   const inCOD = document.getElementById("inCOD").value

    // ESTE ES EL METODO SIN MAPS para una array normal

    /*
   const indice = monitors.findIndex(m => m.COD == inCOD)

   // console.log(indice)

   if(indice != -1){
        monitors.splice(indice, 1)
   }else{
    alert("No s'ha trobat cap monitor amb aquest codi")
   }
    */

   if(monitors.has(parseInt(inCOD))){
        monitors.delete(parseInt(inCOD))
    }else{
       alert("No s'ha trobat el codi a eliminar")
    }
   
   mostrarTaula()
}

// Funcion para recargar la tablaaa 

function mostrarTaula(){

    taula.replaceChildren()
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