const p = document.getElementById("texto")

function Click(){

    const data = new Date()

    let contador = 0;

    let resultat = ""

    const dias = ["Dilluns", "Dimarts", "Dimecres", "Dijous", "Divendres"]
    while (contador < 10){
        if(data.getDay() !== 0 && data.getDay() !== 6){

            let dia = data.getDay();
            let mes = data.getMonth() +1;
            let any = data.getFullYear();

            let nomDia = dias[data.getDay()]

            resultat += `Dia ${contador}: ${nomDia}, ${dia}/${mes}/${any}.`
            contador++;
        }
    }

    p.innerText = resultat

}