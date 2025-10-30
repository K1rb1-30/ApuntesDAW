// Obtener el botón y el div del jump scare
const button = document.querySelector('.scare-button');
const scareDiv = document.querySelector('.jump-scare');
const scareSound = document.getElementById('scare-sound');

// Función que aparece el jump scare
function triggerJumpScare() {
    // Hacer visible el susto
    scareDiv.classList.add('visible');

    // Reproducir el sonido del susto
    scareSound.play();

    // Ocultar el susto después de 3 segundos
    setTimeout(() => {
        scareDiv.classList.remove('visible');
    }, 3000);
}

// Agregar el evento de clic al botón
button.addEventListener('click', triggerJumpScare);
