

const p =document.getElementById("texto")

function Alumnes (nom, cognom, nota) {
    this.nom=nom
    this.cognoms=cognom
    this.nota= nota
}

function hola(){

    let gabriel = new Alumnes("Gabriel", "Sanchez", 23)
    let pepe = new Alumnes("Pepe", "Hola", 12)
    let rodio = new Alumnes("Rodio", "Pepe", 2)

    let classe = [gabriel, pepe, rodio]

    for (let i = 0; i < classe.length; i++) {
        
    }
}
