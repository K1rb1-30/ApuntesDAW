const inputNom=document.getElementById("nom")
const inputValor=document.getElementById("valor")
const presultat=document.getElementById("resultat")



function createGaleta(){
    localStorage.setItem(inputNom.value, inputValor.value)
}
function getGaleta(){
    const valor = localStorage.getItem(inputNom.value)
    if (valor===null){

        presultat.innerText="El valor no existeix";
    }
    else{
        presultat.innerText=`El valor amb clau ${inputNom.value} té el valor: ${valor}`
    }


}

function removeGaleta(){
    localStorage.removeItem(inputNom.value)
}