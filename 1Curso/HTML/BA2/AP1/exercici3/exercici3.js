const input = document.getElementById('input');
const p = document.getElementById('resultado');

function Fahrenheit() {
    const temp = input.value;
    const fahrenheit = temp * 9/5 + 32;
    p.innerText = `${temp}°C = ${fahrenheit}°F`;
}

function Celsius() {
    const temp = input.value;
    const celsius = (temp - 32) * 5/9;
    p.innerText = `${temp}°F = ${celsius}°C`;
}