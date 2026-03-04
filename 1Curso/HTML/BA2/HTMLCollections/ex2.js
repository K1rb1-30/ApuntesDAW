
const txt = document.getElementById("texto");
const lista = document.getElementById("lista")

function mostrar(){
    const set = new Set();

    for (let i = 0; i < 100; i++) {
        set.add(Math.floor(Math.random() * 101));
    }

    lista.innerHTML = ""
    for (const num of set) {
        const li = document.createElement("li");
        li.innerText = num
        lista.appendChild(li)
    }


    txt.innerText = "Finalment hi ha " + set.size + " elements";

}