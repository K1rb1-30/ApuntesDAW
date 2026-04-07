const pare = document.getElementById("pare")
const fill = document.getElementById("fill")
const net = document.getElementById("net")
const bubblingbtn = document.getElementById("bubbling")
const capturingbtn = document.getElementById("capturing")
const resultat = document.getElementById("resultat")


let modo=false;

pare.addEventListener("click",gestionarEsdeveniments, modo)
fill.addEventListener("click",gestionarEsdeveniments,modo)
net.addEventListener("click",gestionarEsdeveniments,modo)

function gestionarMode(newMode){
    resultat.innerText=""
    modo = newMode
    const b = document.createElement("b");
    resultat.appendChild(document.createElement("br"))
    if (newMode){
        b.innerText="Mode Bubbling activat!"
    }
    else{
        b.innerText="Mode Capturing activat!"
    }

    resultat.appendChild(b)

    pare.removeEventListener("click", gestionarEsdeveniments, !modo);
    fill.removeEventListener("click", gestionarEsdeveniments, !modo);
    net.removeEventListener("click", gestionarEsdeveniments, !modo);

    pare.addEventListener("click",gestionarEsdeveniments, modo)
    fill.addEventListener("click",gestionarEsdeveniments,modo)
    net.addEventListener("click",gestionarEsdeveniments,modo)

}


bubblingbtn.addEventListener("click",()=>{gestionarMode(false)})
capturingbtn.addEventListener("click",()=>{gestionarMode(true)})

function gestionarEsdeveniments(event){

    const id = event.currentTarget.id;

    if (id ==="pare"){
        event.currentTarget.style.backgroundColor="cyan";
    }
    else if(id ==="fill"){
        event.currentTarget.style.backgroundColor="lime";
    }
    else if (id === "net")
    {
        event.currentTarget.style.backgroundColor="hotpink";
    }
    resultat.appendChild(document.createElement("br"))
    const span = document.createElement("span");
    span.innerText=`S'ha clicat a ${id}`
    resultat.appendChild(span)
}












