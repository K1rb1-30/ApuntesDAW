const btn1= document.getElementById("primer")

let visible = true;
let color =true;

btn1.onclick = ()=>{
    const llistaCosesACanviar=document.querySelectorAll(".main>div.B");

    if (visible){
        llistaCosesACanviar.forEach(item =>{
            item.style.visibility="hidden"
        })

    }
    else{
        llistaCosesACanviar.forEach(item =>{
            item.style.visibility="visible"
        })

    }
    visible=!visible;
}
const btn2= document.getElementById("segon")

btn2.onclick = ()=>{
    const llistaCosesACanviar=document.querySelectorAll(".main>p.B");

    if (color){
        llistaCosesACanviar.forEach(item =>{
            item.style.color="hotpink"
        })

    }
    else{
        llistaCosesACanviar.forEach(item =>{
            item.style.color="black"
        })

    }
    color=!color;
}
const btn3= document.getElementById("tercer")

btn3.onclick = ()=>{
    const canviText=document.querySelector(".other>div.B");

    if (canviText.innerText==="Javascript"){
        canviText.innerText="TypeScript"

    }
    else{
        canviText.innerText="Javascript"

    }
}