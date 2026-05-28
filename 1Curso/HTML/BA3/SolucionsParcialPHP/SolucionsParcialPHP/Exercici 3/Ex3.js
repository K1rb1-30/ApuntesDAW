const p=document.getElementById("resultat");
document.querySelector("button").onclick= ()=>{

    $.ajax({
        method: "POST",
        url: "Ex3.php",
        data: {"nomVideojoc": document.getElementById("NomVideojoc").value, "nouNomVideojoc": document.getElementById("nouNomVideojoc").value},
        dataType: "json",
        success: function (data) {
            console.log(data)
            if (data.estat==="OK"){
                p.innerText="L'actualització ha anatde manera correcta"
            }
            else if (data.estat==="KO"){
                p.innerText="El videjoc no existeix"
            }
            else{
                p.innerText="Hi ha algun error a l'actualització"
            }
        },
        error: function (jqXHR, textStatus, error) {
            console.log(jqXHR)
        }
    })

};