const nomInput = document.getElementById("nom")
const p = document.getElementById("p")
const btn = document.getElementById("btn")
const contenidor = document.getElementById("contenidor")

let person = []
function CrearPer(){
    const personatge = {
        nom: nomInput.value,
        score: 0,
        toString:function (){
            return "Personatge= "+this.nom+" score="+this.score;
        }
    }

    console.log("dadwa")
    person.push(personatge)

    const btnper = document.createElement("button")
    btnper.innerText=personatge.nom
    contenidor.appendChild(btnper);

    btnper.onclick=()=>{
        personatge.score++;
        p.innerText= personatge.toString();
        let interval_finish;
        clearInterval(interval_finish)
        interval_finish = setInterval(() => {
            p.innerText="";
        }, 2000)
    }


}

