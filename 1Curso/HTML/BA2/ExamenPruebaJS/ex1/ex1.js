const nom = document.getElementById("nom").value
const cancion = document.getElementById("cancion").value
const tematica = document.getElementById("tematica").value
const ncarrosa = document.getElementById("ncarrosa").value
const enseLista = document.getElementById("enseLista")

let lista = [];

function Crear(){
    const carrosa = {
        nom: nom,
        cancion: cancion,
        tematica: tematica,
        ncarrosa: ncarrosa,

        retorna: function (){
            return `Nom: ${this.nom} i canço ${this.cancion}`
        }
    }

    lista.push(carrosa);
}

function Ense(){
    let resultat = ""
    for (const item of lista) {
        resultat += `${item} `
    }

    enseLista.innerText = resultat;
}