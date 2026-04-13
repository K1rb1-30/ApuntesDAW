function Cambiar(){
    const selec = document.getElementById("colores")
    localStorage.setItem("Color", selec.value)
    document.body.style.backgroundColor=`${localStorage.getItem("Color")}`
}
document.body.style.backgroundColor=`${localStorage.getItem("Color")}`
