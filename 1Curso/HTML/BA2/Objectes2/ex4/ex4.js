const hora = document.querySelector("h1")
hora.innerText = Date();

setInterval(() => {
    hora.innerText = Date()
}, 1000)