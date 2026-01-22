// Ejercicio 1
const numero = Math.ceil(Math.random() * 10)

let eleccion = parseInt(prompt())

console.log(numero)

if( eleccion === numero){
    console.log("trobat")
}else{
    console.log("Has fallat!")
}

//Ejercicio 2

let numero1 = parseInt(prompt())
let numero2 = parseInt(prompt())
let sumar = numero1 + numero2

if (numero1 === numero2){
    console.log(sumar * 2)
}else{
    console.log(sumar)
}

//Ejercicio 3

let numero10 = parseInt(prompt("Primer numero"))
let numero20 = parseInt(prompt("Segundo numero"))

if(numero10 < numero20){
    console.log(suma(numero10, numero20))
}else if(numero10 > numero20){
    console.log(resta(numero10, numero20))
}else if(numero10 === numero20){
    console.log(multiplicacio(numero10,numero20))
}

function suma(a,b){
    return a + b
}
function resta(a,b){
    return a - b
}
function multiplicacio(a,b){
    return suma(a,b) * 2
}