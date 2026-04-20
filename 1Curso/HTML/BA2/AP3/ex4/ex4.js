const form = document.getElementById("formulario");
const msg = document.getElementById("mensaje");

form.addEventListener("submit", function(e) {
    e.preventDefault();
    const usuari = document.getElementById("usuari").value.trim();
    const email = document.getElementById("email").value.trim();
    const password = document.getElementById("password").value;
    const repassword = document.getElementById("repassword").value;

    msg.classList.remove("error", "success");

    if (!usuari || !email || !password || !repassword) {
        msg.innerText = "Tots els camps han d’estar omplerts";
        msg.classList.add("error");
        return;
    }

    if (!email.endsWith("@ies-sabadell.cat")) {
        msg.innerText = "El correu ha de ser de l’institut";
        msg.classList.add("error");
        return;
    }

    if (password.length < 8) {
        msg.innerText = "La contrasenya ha de contenir almenys 8 caràcters";
        msg.classList.add("error");
        return;
    }

    localStorage.setItem("usuari", usuari);

    msg.innerText = "Formulari enviat correctament";
    msg.classList.add("success");

    setTimeout(() => {
        window.location.href = "PaginaPrincipal.html"
    }, 2000);
});
