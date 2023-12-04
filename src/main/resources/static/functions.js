function login() {
    var mail = document.getElementById("email").value;
    var password = document.getElementById("password").value;

    if (mail === "user" && password === "user") {
        window.location.href = "patient.html";
    }else if(mail === "admin" && password === "admin") {
        window.location.href = "doctor.html";
    } else {
        alert("Wrong E-mail or password");
    }
}
function dodajPacijenta(){
window.location.href = "newPatient.html";
}

function showHistory(){
window.location.href = "patientHistory.html";
}
function pregledZapisa(){
window.location.href = "doctorPatientHistory.html";
}
