const check_n = document.getElementById("necesarias")
const check_p = document.getElementById("preferences")
const check_e = document.getElementById("estadistics")
const resultat = document.getElementById("resultat")
function AcceptarGaleta(){
    const data = new Date()
    data.setDate(data.getDate()+30)
    document.cookie=`necesarias=${check_n.checked}; expires=${data}`;
    document.cookie=`preferences=${check_p.checked}; expires=${data}`;
    document.cookie=`estadistics=${check_e.checked}; expires=${data}`;
}

function RebutjarGaleta(){
    const data = new Date()
    data.setDate(data.getDate()+30)
    document.cookie=`necesarias=false; expires=${data}`;
    document.cookie=`preferences=false; expires=${data}`;
    document.cookie=`estadistics=false; expires=${data}`;

}

function MostrarGaleta(){
    resultat.innerText = `Necessaries: ${getCookie("necesarias")}, Preferencies:`
    resultat.innerText =
    resultat.innerText = getCookie("preferences")
    resultat.innerText = getCookie("estadistics")
}

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
    return "No trobada";
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

function EliminarGaleta(){
    const data = new Date()
    data.setDate(data.getDate()-1)
    document.cookie=`necesarias=false; expires=${data}`;
    document.cookie=`preferences=false; expires=${data}`;
    document.cookie=`estadistics=false; expires=${data}`;

}


