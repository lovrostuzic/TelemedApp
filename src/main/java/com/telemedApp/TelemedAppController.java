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

    User user = null;
    Doctor doctor = null;


    @GetMapping("/login")
    public String login(Model model, @RequestParam("loginMail") String email, @RequestParam("loginPassword") String password) {
        User userlogin = userRepository.findByEmailAndPassword(email, password);
        Doctor doctorlogin = doctorRepository.findByEmailAndPassword(email, password);
        if (userlogin != null) {
            user = userRepository.findById(userlogin.getId());
            return "redirect:/patient";
        } else if (doctorlogin != null) {
            doctor = doctorRepository.findById(doctorlogin.getId());
            return "redirect:/doctor";
        } else {
            model.addAttribute("userMessage", "User not found");
            return "redirect:/pocetna";
        }
    }

    @GetMapping("/pocetna")
    public String pocetna() {
        return "login.html";
    }

    @GetMapping("/patient")
    public String patient(Model model) {
        model.addAttribute(user);
        model.addAttribute("measurements", measurementRepository.findByUser(user));
        model.addAttribute("userId", user.getId());
        model.addAttribute("userName", user.getName());
        model.addAttribute("userLastName", user.getLastName());
        return "patient.html";
    }

    @GetMapping("/addNewMeasurement")
    public String addNewTodo(@RequestParam("sisPress") int sisPress, @RequestParam("dijPress") int dijPress, @RequestParam("heartRate") int heartRate, @RequestParam("desc") String desc) {
        measurementRepository.save(new Measurement(sisPress, dijPress, heartRate, desc, user));
        return "redirect:/patientHistory";
    }

    @GetMapping("/goToNewP")
    public String goToNewP(Model model) {
        model.addAttribute("doctorId", doctor.getId());
        return "newPatient.html";
    }

    @GetMapping("/addNewPatient")
    public String addNewPatient(@RequestParam("newPatientName") String name, @RequestParam("newPatientLastName") String lastName,
                                @RequestParam("dateOfBirth") String dateOfBirth, @RequestParam("newOib") String oib,
                                @RequestParam("newMobilePhone") String phoneNumber, @RequestParam("email") String email, @RequestParam("password") String pass
    ) {
        User newUser = new User(name, lastName, dateOfBirth, oib, phoneNumber, email, pass, doctor);
        userRepository.save(newUser);
        return "redirect:/doctor";
    }

    @GetMapping("/patientHistory")
    public String measurements(Model model) {
        List<Measurement> measurementList = new ArrayList<>(measurementRepository.findByUser(user));
        model.addAttribute(measurementList);
        model.addAttribute("userId", user.getId());
        model.addAttribute("userName", user.getName());
        model.addAttribute("userLastName", user.getLastName());
        return "patientHistory.html";
    }

    @GetMapping("/doctor")
    public String patients(Model model) {
        List<User> patientList = new ArrayList<>(userRepository.findByDoctor(doctor));
        model.addAttribute("doctorName", doctor.getName());
        model.addAttribute("doctorLastName", doctor.getLastName());
        model.addAttribute("patientList", patientList);
        return "doctor.html";
    }

    @GetMapping("/doctorPocetna")
    public String doctorPocetna(Model model) {
        model.addAttribute(userRepository.findByDoctor(doctor));
        return "doctor.html";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("mid") long measurementId) {
        measurementRepository.deleteById(measurementId);
        return "redirect:/patient";
    }

    @GetMapping("/lookRecords")
    public String lookRecords(Model model, @RequestParam("id") long id) {
        model.addAttribute("measurements", measurementRepository.findByUserId(id));
        User userlook = userRepository.findById(id);
        List<Measurement> measurementList = new ArrayList<>(measurementRepository.findByUser(userlook));
        model.addAttribute(measurementList);
        return "doctorPatientHistory.html";
    }

    @GetMapping("/deletePatient")
    public String deletePatient(@RequestParam("id") long id) {
        userRepository.deleteById(id);
        return "redirect:/doctor";
    }


    @GetMapping("/logOut")
    public String logOut(){
        user = null;
        doctor = null;
        return "login.html";
    }

}
