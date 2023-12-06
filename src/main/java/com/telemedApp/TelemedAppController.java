package com.telemedApp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TelemedAppController {
    List<Measurement> measurementList = new ArrayList<>();
    Patient patient = new Patient(1, "Darko", "Darkić", "10.08.1978", "12345678910", "0957003637", "darkodarkic@gmail.com", "darkodarkic");
    Doctor doctor = new Doctor("Mirela", "Grbić", "mirelagrbic@gmail.com", "mirelagrbic");
    List<Patient> patientList = new ArrayList<>();

    @GetMapping("/login")
    public String login(@RequestParam("loginMail") String email, @RequestParam("loginPassword") String password) {
        if (email.equals(patient.getEmail()) && password.equals(patient.getPassword())) {
            return "redirect:/patient";
        } else if (email.equals(doctor.getEmail()) && password.equals(doctor.getPassword())) {
            return "redirect:/doctorPocetna";
        } else {
            return "login.html";
        }
    }

    @GetMapping("/pocetna")
    public String pocetna() {
        return "login.html";
    }
    @GetMapping("/patient")
    public String patient(Model model) {
        return "patient.html";
    }
    @GetMapping("/addNewMeasurement")
    public String addNewTodo(@RequestParam("sisPress") int sisPress, @RequestParam("dijPress") int dijPress, @RequestParam("heartRate") int heartRate, @RequestParam("desc") String desc) {
        measurementList.add(new Measurement(measurementList.size() + 1, sisPress, dijPress, heartRate, desc));
        return "redirect:/patient";
    }
    @GetMapping("/goToNewP")
    public String goToNewP() {
        return "newPatient.html";
    }
    @GetMapping("/addNewPatient")
    public String addNewPatient(@RequestParam("newPatientName" )String name,@RequestParam("newPatientLastName") String lastName,
                                @RequestParam("dateOfBirth") String dateOfBirth, @RequestParam("newOib") String oib,
    @RequestParam("newMobilePhone") String phoneNumber,@RequestParam("email") String email, @RequestParam("password") String pass){
        Patient newPatient =new Patient(patientList.size()+1,name,lastName,dateOfBirth,oib,phoneNumber,email,pass);
        patientList.add(patient);
        return "redirect:/doctor";

    }


    @GetMapping("/patientHistory")
    public String measurements(Model model) {
        model.addAttribute(measurementList);
        return "patientHistory.html";
    }

    @GetMapping("/doctor")
    public String patients(Model model) {
        patientList.add(patient);
        model.addAttribute(patientList);
        return "doctor.html";
    }

    @GetMapping("/doctorPocetna")
    public String doctorPocetna(Model model) {
        patientList.add(patient);
        model.addAttribute(patientList);
        return "doctor.html";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("measurementNumber") int mN) {
        for (Measurement measurement : measurementList) {
            if (measurement.getMeasurementNumber() == mN) {
                measurementList.remove(measurement);
                break;
            }
        }
        return "redirect:/patientHistory";

    }

    @GetMapping("/lookRecords")
    public String records(Model model) {
        model.addAttribute(measurementList);
        return "doctorPatientHistory.html";
    }

    @GetMapping("/deletePatient")
    public String deletePatient(@RequestParam("patient.number") int num) {
        for (Patient patient : patientList) {
            if (patient.getNumber() == num) {
                patientList.remove(patient);
                break;
            }
        }
        return "redirect:/doctor";

    }
}
