
function llamarFuncionJava() {
    var mensaje = document.getElementById("mensaje").value;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            console.log("Respuesta desde Java: " + this.responseText);
        }
    };
    xhttp.open("GET", "sendStr?mensaje=" + encodeURIComponent(mensaje), true);
    xhttp.send();
}