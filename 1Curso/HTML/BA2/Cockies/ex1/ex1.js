const inputNom=document.getElementById("nom")
const inputValor=document.getElementById("valor")
const presultat=document.getElementById("resultat")


function getCookie(cname) {
    let name = cname + "=";
    let ca = document.cookie.split(';');
    for(let i = 0; i < ca.length; i++) {
        let c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

function createGaleta(){
    const data = new Date()
    data.setDate(data.getDate()+1)


    document.cookie=`${inputNom.value}=${inputValor.value}; expires=${data}`;
}
function getGaleta(){
    const cookie=getCookie(inputNom.value)
    if (cookie===""){

        presultat.innerText="La cookie no existeix";
    }
    else{
        presultat.innerText=`Cookie amb clau ${inputNom.value} té el valor: ${cookie}`
    }

}

function removeGaleta(){
    const data = new Date()
    data.setDate(data.getDate()-20)

    console.log(data)
    document.cookie=`${inputNom.value}=${inputValor.value}; expires=${data}`;
}

