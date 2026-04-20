const resultat = document.getElementById("resultat");
const btn = document.getElementsByTagName("button");
const conta = document.getElementById("container");

//btn.addEventListener("click", AddItem );

function AddItem(){
    let item = document.createElement("div");
    item.classList.add("caixa");
    item.style.backgroundColor="lime";
    conta.appendChild(item);

    let contador = 0;
    item.addEventListener("click", () => {
        contador++;
        resultat.innerText = contador;
    })
}

