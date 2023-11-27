function login() {
    var mail = document.getElementById("email").value;
    var password = document.getElementById("password").value;

    if (mail === "user" && password === "user") {
        window.location.href = "patient.html";
    }if (mail === "admin" && password === "admin") {
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

    cell1.textContent = "1";
    cell2.textContent ="25.11.2023." ;
    cell3.textContent = "126";
    cell4.textContent = "86";
    cell5.textContent = "77";

      var newRow = table.insertRow(-1);

        var cell1 = newRow.insertCell(0);
        var cell2 = newRow.insertCell(1);
        var cell3 = newRow.insertCell(2);
        var cell4 = newRow.insertCell(3);
        var cell5 = newRow.insertCell(4);

        cell1.textContent = "2";
        cell2.textContent = "26.11.2023." ;
        cell3.textContent = "128";
        cell4.textContent = "92";
        cell5.textContent = "83";

  var newRow = table.insertRow(-1);

    var cell1 = newRow.insertCell(0);
    var cell2 = newRow.insertCell(1);
    var cell3 = newRow.insertCell(2);
    var cell4 = newRow.insertCell(3);
    var cell5 = newRow.insertCell(4);

    cell1.textContent = "3";
    cell2.textContent = "27.11.2023." ;
    cell3.textContent = "136";
    cell4.textContent = "94";
    cell5.textContent = "81";

  var newRow = table.insertRow(-1);

    var cell1 = newRow.insertCell(0);
    var cell2 = newRow.insertCell(1);
    var cell3 = newRow.insertCell(2);
    var cell4 = newRow.insertCell(3);
    var cell5 = newRow.insertCell(4);

    cell1.textContent = "4";
    cell2.textContent = "28.11.2023." ;
    cell3.textContent = "131";
    cell4.textContent = "89";
    cell5.textContent = "76";

  var newRow = table.insertRow(-1);

    var cell1 = newRow.insertCell(0);
    var cell2 = newRow.insertCell(1);
    var cell3 = newRow.insertCell(2);
    var cell4 = newRow.insertCell(3);
    var cell5 = newRow.insertCell(4);

    cell1.textContent = "5";
    cell2.textContent = "29.11.2023." ;
    cell3.textContent = "144";
    cell4.textContent = "98";
    cell5.textContent = "86";

}

window.onload = function() {
  popuniRedove();
}
function patientNewHistory() {
 window.location.href = "patientHistory.html";

  var sistolickiTlak = document.getElementById("sistlak").value;
  var dijastolickiTlak = document.getElementById("dijtlak").value;
  var brojOtkucajaSrca = document.getElementById("heartrate").value;
  var description = document.getElementById("description")
  var table = document.getElementById("patient_table");
  var newRow = table.insertRow(-1);

  var cell1 = newRow.insertCell(0);
  var cell2 = newRow.insertCell(1);
  var cell3 = newRow.insertCell(2);
  var cell4 = newRow.insertCell(3);
  var cell5 = newRow.insertCell(4);

  cell1.textContent = "1";
  cell2.textContent = sistolickiTlak;
  cell3.textContent = dijastolickiTlak;
  cell4.textContent = brojOtkucajaSrca;
  cell5.textContent = description;

  }