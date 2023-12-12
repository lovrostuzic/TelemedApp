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
    User patient = new User( "Darko", "Darkić", "10.08.1978", "12345678910", "0957003637", "darkodarkic@gmail.com", "darkodarkic",0);
    User doctor = new User ("Mirela", "Grbić", "12.12.1989","12312311233","0999999999","mirelagrbic@gmail.com", "mirelagrbic",1);
    List<User> userList = new ArrayList<>();



    @GetMapping("/login")
    public String login(@RequestParam("loginMail") String email, @RequestParam("loginPassword") String password) {
      String a = "login.html";
       for(User user : userList)
        if (email.equals(user.getEmail()) && password.equals(user.getPassword())&& user.getPod()==0) {
            return "redirect:/patient";
        } else if (email.equals(user.getEmail()) && password.equals(user.getPassword())&& user.getPod()==1) {
            return "redirect:/doctorPocetna";
        } else {
            a = "login.html";
        }
        return a;
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
    public String addNewPatient(@RequestParam("newPatientName") String name, @RequestParam("newPatientLastName") String lastName,
                                @RequestParam("dateOfBirth") String dateOfBirth, @RequestParam("newOib") String oib,
                                @RequestParam("newMobilePhone") String phoneNumber, @RequestParam("email") String email, @RequestParam("password") String pass) {
        User newUser = new User( name, lastName, dateOfBirth, oib, phoneNumber, email, pass,1);
        userList.add(newUser);
        return "redirect:/doctor";
    }

    @GetMapping("/patientHistory")
    public String measurements(Model model) {
        model.addAttribute(measurementList);
        return "patientHistory.html";
    }

    @GetMapping("/doctor")
    public String patients(Model model) {
        model.addAttribute(userList);
        return "doctor.html";
    }

    @GetMapping("/doctorPocetna")
    public String doctorPocetna(Model model) {
        userList.add(patient);
        model.addAttribute(userList);
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
        for (User user : userList) {
            if (user.getId() == num) {
                userList.remove(user);
                break;
            }
        }
        return "redirect:/doctor";
    }
}
