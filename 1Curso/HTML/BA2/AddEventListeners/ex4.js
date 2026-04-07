const submit = document.getElementById("submit")
const form = document.querySelector("form")
const nom = document.getElementById("name").value
const email = document.getElementById("email").value
const resultat = document.querySelector("p")

form.addEventListener("submit", (incorrecte(event)))

function incorrecte(event){
    event.preventDefault()
    if(nom !== null && email !== null){
        if (validarEmail(email)){
            resultat.style.color="green"
            resultat.innerText = "Formulari enviat correctament"
        }else{
            ponerRojoBorde(email)
            error("Correu Incorrecte!")
        }
    }else{
        ponerRojoBorde(nom)
        ponerRojoBorde(email)
        error("Omple tots els camps abans d'enviar")
    }
}


function ponerRojoBorde(patata){
    patata.style.border="solid 2px red"
}

function validarEmail(email){
    const compemail = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/
    return compemail.test(email)
}

function error(message){
    resultat.style.color="red"
    resultat.innerText = message
}