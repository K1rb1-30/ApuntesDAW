
const p = document.getElementById("resultat")

function missatge(){
    let contador = 10
    while(contador > 0){
        p.innerText+= " "+ contador
        contador--
    }

}