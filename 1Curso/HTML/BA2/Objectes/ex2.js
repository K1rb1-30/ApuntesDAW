const p = document.getElementById("texto")

function boto(){
    const cotxe = {
        marca:"pagani",
        model: "Zonda",
        any: 1999,
    }

    cotxe.ecologic = true;

    let msg = ""

    for (const propietat in cotxe) {
        msg+= propietat+": "+cotxe[propietat]+", "
    }

    p.innerText = msg


}