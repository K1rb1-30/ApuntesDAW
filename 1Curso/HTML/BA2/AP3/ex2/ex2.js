const text = document.getElementById("comptador");

let interval;
let activo = false;
let contador = getCookie("Tiempo") ? parseInt(getCookie("Tiempo")) : 10;

actualizarTexto();

function Iniciar(){
    clearInterval(interval)
    contador = 10;
    actualizarTexto();
    guardarCookie();
    CuentaAtras();
    
}

function CuentaAtras(){
    activo = true
    interval = setInterval(() => {
        if (contador > 0){
            contador--
            text.innerText = contador;
            
        }else{
            clearInterval(interval)
            activo = false
        }
    }, 1000)
}

function Parar(){
    clearInterval(interval);
    activo = false;
    guardarCookie();
}

function Reanudar(){
    if(!activo && contador > 0){
        CuentaAtras();
    }
}

function getCookie(cname){
    let cookie = document.cookie.split(";");
    for(let c of cookie){
        let [key, value] = c.split("=");
        if(key === cname){
            return value;
        }
    }
}

function actualizarTexto(){
    text.innerText = contador;
}

function guardarCookie(){
    const data = new Date();
    data.setDate(data.getDate()+1);

    document.cookie=`Tiempo=${contador}; expires=${data}`;
}