const inputName = document.getElementById("usuari")
const inputPass = document.getElementById("contrasenya")

const form = document.querySelector("form")

const missatge = document.getElementById("Missatge")
const boton = document.querySelectorAll("button")
let jugador = getCookie("usuari");

const titulo = document.getElementById("nickname")
let tiempo = 30;

let contenidor = document.getElementById("contenidor")


// variables de juego
let Caselles
let Mines
let DanyMines
let Diamant
let Ferro
let Coure

//Formulario de inicio de sesion

form.onsubmit = (ev) =>{
    ev.preventDefault();
    $.ajax({
        method:"POST",
        url:"Login.php",
        data:{"nomUsuari":inputName.value,"contrasenya":inputPass.value},
        dataType:"json",
        success:function (data) {
            console.log(data)
            missatge.innerText=data.missatge;

            //si devuelve okey va a la funcion yalogeao
            if (data.estatus === "OK"){
                // jugador = inputName.value
                yalogueao()
                console.log(getCookie("usuari"))

            }

        },
        error: function (jqXHR, textStatus, error){
            console.log(jqXHR);
        }
    });
}

// para mirar a cookie
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
//comprovamos si existe la cookie
function comprovarCookie(){
    if(getCookie("usuari") !== ""){
        yalogueao()
        titulo.innerText=getCookie("usuari")
    }else{

    }
}


// limpiamos la cookie y reiniciamos la pagina
function Netejar(){
    let fecha = Date() - 1;
    document.cookie = `usuari=;expires=${fecha}`
    window.location.reload()
}


function yalogueao(){
    console.log(jugador)
    form.style.display="none"; // desactivamos el form
    console.log(boton)
    for (const boto of boton) { //activamos los botones
        boto.disabled=false;
    }
    titulo.innerText=getCookie("usuari") // añadimos al titulo el nombre de la cookie que es el usuario

}

function juego(dificultat){
        tiempo = 30; // tiempo 30 s
        setInterval(() =>{ //intervalo para el contador
            if (tiempo >= 0){
                reloj()
            }else{
                for (const boto of boton) {
                    boto.disabled=false;
                }
                clearInterval()
            }
        }, 1000)

    for (const boto of boton) { // deshabilitamos los botones
        boto.disabled=true;
    }

    recogerDificultat(dificultat) // recogemos la dificulatat

}


function reloj(){  // control tiempo

    const temps = document.getElementById("temps")
    temps.innerText=tiempo
    tiempo--
}

function recogerDificultat(dificultat){ // recogemos la difiulatat
    $.ajax({
        method:"POST",
        url:"dificultat.php",
        data:{"dificultat":dificultat},
        dataType:"json",
        success:function (data) {
            console.log(data)
            // recogemos de la BBDD los parametros de cada variable de juego
            for (const dificultat of data) {
                console.log(dificultat);
                Caselles = dificultat.QuantitatCaselles;
                Mines = dificultat.Quantitatmines;
                DanyMines = dificultat.DanyMines;
                Diamant = dificultat.bonusDiamant;
                Ferro = dificultat.bonusFerro;
                Coure = dificultat.bonusCoure;
            }

            while (contenidor.firstChild) {// borramos el tablero si existe
                contenidor.removeChild(contenidor.firstChild);
            }

            //rellenamos tablero
            for (let i = 0; i < Caselles; i++) {
                console.log("dadwda")
                let div = document.createElement("div")
                div.classList.add("roca")
                contenidor.appendChild(div)
            }

        },
        error: function (jqXHR, textStatus, error){
            console.log(jqXHR);
        }
    });
}

