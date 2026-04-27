const esp = document.getElementById("esp");
const cat = document.getElementById("cat");
const en = document.getElementById("en");
const h1 = document.getElementById("titol");
const p = document.getElementById("p");

let idiomaselec = getCookie("Idioma") ? getCookie("Idioma") : "cat";

actualizarTexto();

function actualizarTexto(){
    idiomaselec = getCookie("Idioma");
    if (idiomaselec === "cat"){
        h1.innerText="Hola, Bon Dia"
        p.innerText="Aquesta pagina no serveix de res"
    }else if(idiomaselec === "es"){
        h1.innerText="Hola, Buenos Dias";
        p.innerText="Esta pagina no sirve para na"
    }else if(idiomaselec === "en"){
        h1.innerText="Hello, good Morning"
        p.innerText="This page is useless"
    }
}
esp.addEventListener("click", () => {
    createGaleta("es");
    actualizarTexto();
    console.log("es")
})

cat.addEventListener("click", () => {
    createGaleta("cat");
    actualizarTexto();
    console.log("cat")
})

en.addEventListener("click", () => {
    createGaleta("en");
    actualizarTexto();
    console.log("en")
})

function getCookie(cname){
    let cookie = document.cookie.split(";");
    for(let c of cookie){
        let [key, value] = c.split("=");
        if(key === cname){
            return value;
        }
    }
}

function createGaleta(idioma){
    const data = new Date()
    data.setDate(data.getDate()+1)


    document.cookie=`Idioma=${idioma}; expires=${data}`;
}