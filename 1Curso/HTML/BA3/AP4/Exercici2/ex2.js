const h1 = document.getElementById("patatito");

function getCookie(cname) {
    let name = cname + "=";
    let decodedCookie = document.cookie;
    let ca = decodedCookie.split(';');
    for(let i = 0; i <ca.length; i++) {
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

comprovarCookie();
function comprovarCookie(){
    if(getCookie("usuari") !== ""){
        h1.innerText=getCookie("usuari")
    }else{
        h1.innerText="Usuari no registrat"
    }
}



function Netejar(){
    let fecha = Date() - 1;
    document.cookie = `usuari=;${fecha}`
    comprovarCookie();
}