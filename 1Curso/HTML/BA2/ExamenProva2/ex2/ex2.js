const nom = document.getElementById("nom");
const massa = document.getElementById("massa");
const nom = document.getElementById("nom");
const nom = document.getElementById("nom");
let lista_pizzas = [];
function Crear(){
    const pizza = {
        nom: nom,
        massa: massa,
        tamany: tamany,
        ningredients: ningredients,

        retorna: function (){
            return `Nom: ${this.nom} i mass ${this.massa}`
        }
    }

    lista_pizzas.push(pizza);
}