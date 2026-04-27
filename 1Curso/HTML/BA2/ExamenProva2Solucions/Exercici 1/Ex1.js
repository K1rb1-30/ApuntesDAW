const btn = document.querySelector("button")
const container = document.getElementById("container")
btn.onclick=()=>{
    const caixa = document.createElement("div")
    caixa.classList.add("caixa")
    caixa.style.backgroundColor="lime";
    caixa.innerText="0";
    caixa.onclick=()=>{
        caixa.innerText= String(Number(caixa.innerText)+1)
    }
    container.appendChild(caixa)
}