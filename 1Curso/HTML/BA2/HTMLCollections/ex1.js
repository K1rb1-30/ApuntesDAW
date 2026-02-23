
const txt = document.getElementById("texto");


function mostrar(){
    const array = []
    for (let i = 0; i < 4; i++) {
        array.push(Math.floor(Math.random() * 21));
    }

    let ascendent = true;

    for (let i = 0; i < array.length; i++) {
        if(i !== 0){
            if(array[i] < array[i - 1]){
                ascendent = false;
            }
        }
    }

    txt.innerText = array + " " + ascendent

}