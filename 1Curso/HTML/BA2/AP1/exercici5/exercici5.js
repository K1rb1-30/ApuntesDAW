
const btns = document.querySelectorAll("button")
const div = document.querySelectorAll("div")

btns[0].classList.add("classe1")
btns[0].classList.add("classe2")
btns[1].classList.add("classe1")
btns[2].classList.add("classe1")


function formatear(boton){
    for (let i = 0; i < btns.length; i++) {
        btns[i].classList.remove("classe2")
    }

    boton.classList.add("classe2")

    div[1].innerText = "S'ha clicat el " + boton.textContent

}
