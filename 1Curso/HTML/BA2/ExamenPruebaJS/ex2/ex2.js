const pare = document.getElementById("container");

function Random(){
    const divfill = document.createElement("div")
    divfill.classList.add("caixa")
    const c1 = Math.floor(Math.random() * 255)
    const c2 = Math.floor(Math.random() * 255)
    const c3 = Math.floor(Math.random() * 255)
    divfill.style.backgroundColor=`rgba(${c1},${c2},${c3})`

    pare.appendChild(divfill)
}