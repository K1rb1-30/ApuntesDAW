const div = document.getElementById("cuadrado")

function transformar(){
    if(div.classList.contains("classe1")){
        div.classList.remove("classe1")
    }else{
        div.classList.add("classe1")
    }
}