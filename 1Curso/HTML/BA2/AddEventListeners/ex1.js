
let lista = document.querySelector("ul")


lista.addEventListener("click", () =>{
    if(event.target.tagName==="li"){
        for (let i = 0; i < lista.children.length; i++) {
            lista.children[i].classList.remove("classe1")
        }
        event.target.classList.add("classe1")
    }
})
