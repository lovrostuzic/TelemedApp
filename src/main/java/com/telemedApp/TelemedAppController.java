package com.telemedApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class TelemedAppController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    MeasurementRepository measurementRepository;
    @Autowired
    DoctorRepository doctorRepository;


    @GetMapping("/login")
    public String login(Model model, @RequestParam("loginMail") String email, @RequestParam("loginPassword") String password) {
        User user = userRepository.findByEmailAndPassword(email, password);
        Doctor doctor = doctorRepository.findByEmailAndPassword(email, password);
        if (user != null) {
            return "redirect:/patient?userId=" + user.getId();
        } else if (doctor != null) {
            return "redirect:/doctor?doctorId=" + doctor.getId();
        } else {
            model.addAttribute("userMessage", "User not found");
            return "login.html";
        }
    }

    @GetMapping("/pocetna")
    public String pocetna() {
        return "login.html";
    }

    @GetMapping("/patient")
    public String patient(Model model, long id) {
        Optional<User> user = userRepository.findById(id);
        model.addAttribute(user);
        model.addAttribute(measurementRepository.findByUser(user));
        return "patient.html";
    }

    @GetMapping("/addNewMeasurement")
    public String addNewTodo(long id, @RequestParam("sisPress") int sisPress, @RequestParam("dijPress") int dijPress, @RequestParam("heartRate") int heartRate, @RequestParam("desc") String desc) {
       Optional<User> user = userRepository.findById(id);
        measurementRepository.save(new Measurement(user,sisPress, dijPress, heartRate, desc));
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
        model.addAttribute("measurements", measurementRepository.findByUser_Id(id));
        return "patientHistory.html";
    }

    @GetMapping("/doctor")
    public String patients(Model model, @RequestParam("DoctorId") long id) {
        model.addAttribute("user", userRepository.findById(id));
        return "doctor.html";
    }

    @GetMapping("/doctorPocetna")
    public String doctorPocetna(Model model, @RequestParam("DoctorId") long id) {
        model.addAttribute(userRepository.findByDoctor_Id(id));
        return "doctor.html";
    }

    public String delete(@RequestParam("MeasurementId") long measurementId) {
        measurementRepository.deleteById(measurementId);
        return "redirect:/patientHistory";
    }

    @GetMapping("/lookRecords")
    public String records(Model model, @RequestParam("userId") long id) {
        model.addAttribute("measurements", measurementRepository.findByUser_Id(id));
        return "doctorPatientHistory.html";
    }

    @GetMapping("/deletePatient")
    public String deletePatient(@RequestParam("patientId") long id) {
        userRepository.deleteById(id);
        return "redirect:/doctor";
    }
}
