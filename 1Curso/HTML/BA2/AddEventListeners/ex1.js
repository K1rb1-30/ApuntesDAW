
const lista = document.querySelector("ul")

lista.addEventListener("click", (event) =>{
    if(event.target.tagName==="LI"){
        for (let i = 0; i < lista.children.length; i++) {
            lista.children[i].classList.remove("classe1")
        }
        event.target.classList.add("classe1")
    }
})


