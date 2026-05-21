
const inputEmail = document.getElementById("email");
const inputPswd = document.getElementById("pswd")
const p = document.getElementById("text")
const divTabla = document.createElement("div");

document.body.appendChild(divTabla);

function getUsers(){
    $.ajax({
        method:"GET",
        url:"getUsers.php",
        data:{},
        dataType:"json",
        success:function (data) {
            console.log(data);

            while (divTabla.firstChild) {
                divTabla.removeChild(divTabla.firstChild);
            }

            const tabla = document.createElement("table");
            tabla.style.border="1";

            // Titulos de la tabla

            const thead = document.createElement("thead");
            const filaTitulos = document.createElement("tr");

            const thId = document.createElement("th");
            thId.innerText = "ID";

            const thEmail = document.createElement("th");
            thEmail.innerText = "EMAIL";

            const thPass = document.createElement("th");
            thPass.innerText = "CONTRASEÑA";

            filaTitulos.appendChild(thId);
            filaTitulos.appendChild(thEmail);
            filaTitulos.appendChild(thPass);

            thead.appendChild(filaTitulos);

            // Contenido de las filas

            const tbody = document.createElement("tbody");

            for (const user of data) {
                console.log(user)

                const fila = document.createElement("tr");

                const celdaid = document.createElement("td")
                celdaid.innerText = "" + user.idUsuari;

                const celdaemail = document.createElement("td")
                celdaemail.innerText = "" + user.email;

                const celdapasswd = document.createElement("td")
                celdapasswd.innerText = "" + user.contrasenya;

                fila.appendChild(celdaid);
                fila.appendChild(celdaemail);
                fila.appendChild(celdapasswd);

                tbody.appendChild(fila);
            }

            tabla.appendChild(thead);
            tabla.appendChild(tbody);

            divTabla.appendChild(tabla);

            console.log(tabla)

        },
        error: function (jqXHR, textStatus, error){
            console.log(jqXHR);
        }
    });
}

function register(){
    $.ajax({
        method:"POST",
        url:"register.php",
        data:{"email":inputEmail.value,"pswd":inputPswd.value},
        dataType:"json",
        success:function (data) {

        },
        error: function (jqXHR, textStatus, error){
            console.log(jqXHR);
        }
    });
}