
const contenidor = document.getElementById("contenidor");
let listaFitxes = [];
const temps = document.getElementById("temps");
const ods_trobar = document.getElementById("ods");
const contador = document.getElementById("comptador")
let interval_temps;
let interval_graella;
let interval_finish;

let temps_cont;

let fitxaescolida;

let contador_cont = 0;

function Fitxa(id, nom) {
    this.id = id;
    this.nom = nom;
}

for (let i = 1; i < 18; i++) {
    const fitxa = new Fitxa(i, `./imatgesODS/${i}.png`);
    listaFitxes.push(fitxa);
}


function posaCaixes(){
    contador_cont = 0;
    contador.innerText=contador_cont;
    fitxaescolida = Math.floor(Math.random() * 16) + 1;
    ods_trobar.innerText=fitxaescolida;
    CrearGraella();
    clearInterval(interval_temps)
    temps_cont = 0;
    interval_temps = setInterval(() => {
        temps_cont++;
        temps.innerText = temps_cont;
    }, 1000)

    clearInterval(interval_graella)
    interval_graella = setInterval(() => {
        CrearGraella();
    }, 2000)

    clearInterval(interval_finish)
    interval_finish = setInterval(() => {
        Finish()
    }, 30000)



}

function CrearGraella(){

    contenidor.innerHTML="";
    for (let i = 0; i < 20; i++) {
        const ODS = listaFitxes[Math.floor(Math.random() * 17)];
        const div = document.createElement("div");
        div.classList.add("items");
        const imag = document.createElement("img");
        imag.src=ODS.nom;
        imag.classList.add("imag");
        imag.classList.add("ods" + ODS.id.toString());
        div.appendChild(imag);
        div.onclick = FuncionONCLICK;
        contenidor.appendChild(div);
    }

}

function FuncionONCLICK(event){
    // console.log(event.target.classList[1]);
    // console.log("ods" + fitxaescolida.toString());
    if(event.target.classList[1] === "ods" + fitxaescolida.toString()){
        contador_cont++;
        fitxaescolida = Math.floor(Math.random() * 16) + 1;
        ods_trobar.innerText = fitxaescolida;
    }else{
        contador_cont--;

    }
    contador.innerText = contador_cont;

}

function Finish(){
    clearInterval(interval_temps);
    clearInterval(interval_graella);
    clearInterval(interval_finish);
    let fini = document.createElement("p");
    fini.innerText=`Partida Acabada, puntos totales: ${contador_cont}`
    document.body.appendChild(fini)
}
console.log(listaFitxes);




