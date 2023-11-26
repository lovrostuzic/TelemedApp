function login() {
    var mail = document.getElementById("email").value;
    var password = document.getElementById("password").value;

    if (mail === "bircuser" && password === "bircuser") {
        window.location.href = "patient.html";
    }if (mail === "bircadmin" && password === "bircadmin") {
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
function popuniRedove() {
  var table = document.getElementById('patient_table');

     var newRow = table.insertRow(-1);

    var cell1 = newRow.insertCell(0);
    var cell2 = newRow.insertCell(1);
    var cell3 = newRow.insertCell(2);
    var cell4 = newRow.insertCell(3);
    var cell5 = newRow.insertCell(4);

    cell1.textContent = "a";
    cell2.textContent ="a" ;
    cell3.textContent = "a";
    cell4.textContent = "a";
    cell5.textContent = "a";

      var newRow = table.insertRow(-1);

        var cell1 = newRow.insertCell(0);
        var cell2 = newRow.insertCell(1);
        var cell3 = newRow.insertCell(2);
        var cell4 = newRow.insertCell(3);
        var cell5 = newRow.insertCell(4);

        cell1.textContent = "a";
        cell2.textContent ="a" ;
        cell3.textContent = "a";
        cell4.textContent = "a";
        cell5.textContent = "a";
  var newRow = table.insertRow(-1);

    var cell1 = newRow.insertCell(0);
    var cell2 = newRow.insertCell(1);
    var cell3 = newRow.insertCell(2);
    var cell4 = newRow.insertCell(3);
    var cell5 = newRow.insertCell(4);

    cell1.textContent = "a";
    cell2.textContent ="a" ;
    cell3.textContent = "a";
    cell4.textContent = "a";
    cell5.textContent = "a";


}

window.onload = function() {
  popuniRedove();
};