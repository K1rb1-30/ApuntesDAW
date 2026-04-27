const boto = document.getElementById("btnCrear");
const container = document.getElementById("contenidor");

boto.onclick=()=>{
    const caixa = document.createElement("div")
    caixa.classList.add("caixa")
    caixa.onmouseover=()=>{
        caixa.style.alignSelf="end";
    }
    caixa.onmouseleave=()=>{
        caixa.style.alignSelf="start";
        caixa.style.backgroundColor=`rgb(${Math.floor(Math.random() * 255)}, ${Math.floor(Math.random() * 255)}, ${Math.floor(Math.random() * 255)})`
    }
    container.appendChild(caixa)
}