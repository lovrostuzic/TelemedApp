function login() {
    var mail = document.getElementById("email").value;
    var password = document.getElementById("password").value;

    if (mail === "bircuser" && password === "bircuser") {
        window.location.href = "patient.html";}
        if (mail === "bircadmin" && password === "bircadmin") {
                window.location.href = "doctor.html";
    } else {
        alert("Wrong E-mail or password");
    }
}