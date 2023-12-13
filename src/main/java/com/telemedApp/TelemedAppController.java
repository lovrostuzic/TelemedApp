package com.telemedApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TelemedAppController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    MeasurementRepository measurementRepository;
    @Autowired
    DoctorRepository doctorRepository;


    @GetMapping("/login")
    public String login(@RequestParam("loginMail") String email, @RequestParam("loginPassword") String password) {
        return "login.html";


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
        measurementRepository.save(new Measurement(sisPress, dijPress, heartRate, desc));
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
        User newUser = new User(name, lastName, dateOfBirth, oib, phoneNumber, email, pass, 1);
        userRepository.save(newUser);
        return "redirect:/doctor";
    }

    @GetMapping("/patientHistory")
    public String measurements(Model model, @RequestParam("UserId") long id) {
        model.addAttribute(measurementRepository.findByUser_Id(id));
        return "patientHistory.html";
    }

    @GetMapping("/doctor")
    public String patients(Model model, @RequestParam("DoctorId") long id ) {
        model.addAttribute(userRepository.findById(id));
        return "doctor.html";
    }

    @GetMapping("/doctorPocetna")
    public String doctorPocetna(Model model, @RequestParam("DoctorId") long id) {
                model.addAttribute(userRepository.findByDoctor_Id(id));
        return "doctor.html";
    }}

/*    public String delete(@RequestParam("measurementNumber") int mN) {
        for (Measurement measurement : measurementRepository) {
            if (measurement.get() == mN) {
                measurementList.remove(measurement);
                break;
            }
            return "redirect:/patientHistory";
        }

        @GetMapping("/lookRecords")
        public String records (Model model){
            model.addAttribute(measurementList);
            return "doctorPatientHistory.html";
        }

        @GetMapping("/deletePatient")
        public String deletePatient ( @RequestParam("patient.number") int num){
            for (User user : userList) {
                if (user.getId() == num) {
                    userList.remove(user);
                    break;
                }
            }
            return "redirect:/doctor";
        }
    }*/
