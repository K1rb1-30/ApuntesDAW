
const listaimg = document.getElementById("imatges").children
const imatges = document.querySelectorAll("div#imatges img")
let localizador = 0;
function Anterior(){
    listaimg[localizador].style.display="none"
    localizador--
    if(localizador<0){
        localizador=2
    }
    listaimg[localizador].style.display="block"
}
function Siguiente(){
    listaimg[localizador].style.display="none"
    localizador++
    if(localizador>2){
        localizador=0
    }
    listaimg[localizador].style.display="block"
}