
function Wiki(){
    let wiki = open("https://es.wikipedia.org/")
    setTimeout(() => {
        wiki.close()
    }, 5000)
}