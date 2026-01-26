
const p = document.getElementById("resultat")
function aleatori(){
   let aleatori1 = Math.floor(Math.random() * 11)
   let aleatori2 = Math.floor(Math.random() * 11)
    let contador = 0
    while(aleatori1 !== aleatori2){
       aleatori2 = Math.floor(Math.random() * 11)
        contador++
    }
    p.innerText = aleatori1 +" " + contador
}