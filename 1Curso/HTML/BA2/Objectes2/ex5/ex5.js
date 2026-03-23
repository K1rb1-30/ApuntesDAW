const cuadrado = document.getElementById("cuadrado");
let posx = 0
let posy = 0
function Mover(direction){

    if(direction === 't'){
        posy -=100;
    }else if (direction === 'b'){
        posy += 100;
    }else if (direction === 'r'){
        posx += 100;
    }else if (direction === 'l'){
        posx -= 100;
    }

    cuadrado.style.transform = `translate(${posx}px , ${posy}px)`
}