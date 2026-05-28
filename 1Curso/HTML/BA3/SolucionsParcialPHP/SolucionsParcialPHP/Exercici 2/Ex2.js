document.querySelector("button").onclick= ()=>{

    $.ajax({
        method: "POST",
        url: "Ex2.php",
        data: {"nomVideojoc": document.querySelector("input").value},
        dataType: "json",
        success: function (data) {
            console.log(data)


                document.getElementById("resultat").innerText=data.missatge;



        },
        error: function (jqXHR, textStatus, error) {
            console.log(jqXHR)
        }
    })

};