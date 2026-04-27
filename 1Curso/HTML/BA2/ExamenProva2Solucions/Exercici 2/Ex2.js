const pizzes = []
const nomInput=document.getElementById("nom")
const massaInput=document.getElementById("massa")
const tamanyInput=document.getElementById("tamany")
const numInput=document.getElementById("numero")
const presultat=document.getElementById("resultat")

function afegirPizza(){
    const pizza = {
        nom: nomInput.value,
        massa:massaInput.value,
        tamany:tamanyInput.value,
        numeroIngredientes:numInput.value,
        nomMassa:function (){
            return "La pizza amb nom "+this.nom+" té la massa "+this.massa
        },
        toString:function (){
            return "La pizza amb nom "+this.nom+" té la massa "+this.massa+" té el tamany "+this.tamany+" i un nombre d'ingredients "+this.numeroIngredientes
        }
    }

    pizzes.push(pizza)

    localStorage.setItem("pizza", pizza.nomMassa())
}
function MostrarPizzes(){
    presultat.innerText="";
    let msg="Les Pizzes són: \n"
    pizzes.forEach(pizza=>{
        msg+=pizza.toString()+"\n"
    })
    presultat.textContent=msg;

}
function mostrarPizzaLocalStorage(){
    if (localStorage.getItem("pizza")===null){
        presultat.innerText="No hi ha res a la llista de pizzes"
    }
    else{
        presultat.innerText=localStorage.getItem("pizza")
    }

}