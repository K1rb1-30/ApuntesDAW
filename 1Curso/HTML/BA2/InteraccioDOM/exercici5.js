function comprobar(){
    let multi = document.getElementById("texto").value
    const p = document.getElementById("palabra")
    let contador = 0

    for(let i = 0; i < multi.length; i++){
        let lletra = multi.charAt(i).toLowerCase()
        if(lletra === "a"){
            contador++;
        }
    }

    p.innerText = `Tiene ${contador} a`
}