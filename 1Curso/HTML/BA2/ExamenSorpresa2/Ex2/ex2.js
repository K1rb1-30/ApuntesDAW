
const container = document.getElementById("contenidor")
const p = document.getElementById("resultat")

let comptador = 0;

posaCaixes()


function posaCaixes(){
    const r = Math.floor(Math.random() * (4 - 1 + 1) + 1)
    console.log(r)
    for (let i = 0; i < r; i++) {
        const caixa = document.createElement("div")
        caixa.classList.add("items");
        caixa.style.backgroundColor=`rgb(${Math.floor(Math.random() * 255)}, ${Math.floor(Math.random() * 255)}, ${Math.floor(Math.random() * 255)})`
        container.appendChild(caixa);
        comptador+= 1;
    }

    p.innerText = `En total hi ha ${comptador} elements`
}

container.children.addEventListener()