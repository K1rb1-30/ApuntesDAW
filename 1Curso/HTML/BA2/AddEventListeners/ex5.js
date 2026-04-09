const table = document.getElementById("sostenibilitat")

table.addEventListener("click", (event) =>{
    if(event.target.tagName === "TD"){
        event.target.classList.toggle("realsar")
    }
    else if(event.target.tagName==="STRONG"){
        event.target.parentElement.classList.toggle("realsar")
    }
})