package com.telemedApp;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
    @Autowired
    SuperAdminRepository superAdminRepository;

    User user = null;
    Doctor doctor = null;
    SuperAdmin superAdmin = null;

    //DODAVANJE U BAZU
    @PostConstruct
    public void init() {
        SuperAdmin sup = new SuperAdmin(1, "Lovro", "Stužić", "lovrostuzic@gmail.com", "lovrostuzic");
        superAdminRepository.save(sup);

        doctorRepository.save(new Doctor("Mirela", "Marković", "mirelamarkovic@gmail.com", "abc123", sup));
        doctorRepository.save(new Doctor("Leon", "Lužni", "leonluzni@gmail.com", "abcd12", sup));
        doctorRepository.save(new Doctor("Ivana", "Ivković", "ivanaivkovic@gmail.com", "abcde1", sup));
        doctorRepository.save(new Doctor("Denis", "Dobrotić", "denisdobrotic@gmail.com", "abcdef", sup));
        doctorRepository.save(new Doctor("Dubravko", "Dobromir", "dubravkodobromir@gmail.com", "ab1234", sup));

        userRepository.save(new User("Ivan", "Ivić", "02/15/1985", "1234567890", "123456789", "ivan@email.com", "pass123", doctorRepository.findById(1)));
        userRepository.save(new User("Ana", "Anić", "03/20/1990", "2345678901", "234567890", "ana@email.com", "pass456", doctorRepository.findById(2)));
        userRepository.save(new User("Marko", "Markić", "04/25/1982", "3456789012", "345678901", "marko@email.com", "pass789", doctorRepository.findById(3)));
        userRepository.save(new User("Jelena", "Jelenić", "05/30/1978", "4567890123", "456789012", "jelena@email.com", "passabc", doctorRepository.findById(4)));
        userRepository.save(new User("Mateo", "Mateić", "06/05/1995", "5678901234", "567890123", "mateo@email.com", "passdef", doctorRepository.findById(5)));

        userRepository.save(new User("Lana", "Lanić", "07/10/1987", "6789012345", "678901234", "lana@email.com", "pass123", doctorRepository.findById(1)));
        userRepository.save(new User("Petar", "Petrić", "08/15/1992", "7890123456", "789012345", "petar@email.com", "pass456", doctorRepository.findById(2)));
        userRepository.save(new User("Iva", "Ivić", "09/20/1980", "8901234567", "890123456", "iva@email.com", "pass789", doctorRepository.findById(3)));
        userRepository.save(new User("Filip", "Filipi", "10/25/1975", "9012345678", "901234567", "filip@email.com", "passabc", doctorRepository.findById(4)));
        userRepository.save(new User("Ema", "Emić", "11/30/1998", "0123456789", "012345678", "ema@email.com", "passdef", doctorRepository.findById(5)));

        userRepository.save(new User("Stjepan", "Stjepanić", "01/15/1980", "1112233445", "112233445", "stjepan@email.com", "pass123", doctorRepository.findById(1)));
        userRepository.save(new User("Marina", "Marinić", "02/20/1995", "2223344556", "223344556", "marina@email.com", "pass456", doctorRepository.findById(2)));
        userRepository.save(new User("Ivan", "Ivanić", "03/25/1988", "3334455667", "334455667", "ivan@email.com", "pass789", doctorRepository.findById(3)));
        userRepository.save(new User("Petra", "Petrić", "04/30/1975", "4445566778", "445566778", "petra@email.com", "passabc", doctorRepository.findById(4)));
        userRepository.save(new User("Ante", "Antić", "05/05/1990", "5556677889", "556677889", "ante@email.com", "passdef", doctorRepository.findById(5)));

        userRepository.save(new User("Ivana", "Ivanić", "06/10/1982", "6667788990", "667788990", "ivana@email.com", "pass123", doctorRepository.findById(1)));
        userRepository.save(new User("Luka", "Lukić", "07/15/1997", "7778899001", "778899001", "luka@email.com", "pass456", doctorRepository.findById(2)));
        userRepository.save(new User("Katarina", "Katarinić", "08/20/1985", "8889900012", "889900012", "katarina@email.com", "pass789", doctorRepository.findById(3)));
        userRepository.save(new User("Filip", "Filipi", "09/25/1978", "9990001123", "900001123", "filip@email.com", "passabc", doctorRepository.findById(4)));
        userRepository.save(new User("Dora", "Dorić", "10/30/1993", "0001112234", "001112234", "dora@email.com", "passdef", doctorRepository.findById(5)));

        userRepository.save(new User("Matej", "Matejić", "11/05/1983", "1122334455", "2233445566", "matej@email.com", "pass123", doctorRepository.findById(1)));
        userRepository.save(new User("Sara", "Sarić", "12/10/1998", "2233445566", "3344556677", "sara@email.com", "pass456", doctorRepository.findById(2)));
        userRepository.save(new User("Nikola", "Nikolić", "01/15/1986", "3344556677", "4455667788", "nikola@email.com", "pass789", doctorRepository.findById(3)));
        userRepository.save(new User("Martina", "Martinić", "02/20/1976", "4455667788", "5566778899", "martina@email.com", "passabc", doctorRepository.findById(4)));
        userRepository.save(new User("Stella", "Stellić", "03/25/1991", "5566778899", "6677889900", "stella@email.com", "passdef", doctorRepository.findById(5)));

        userRepository.save(new User("Filip", "Filipi", "04/30/1984", "6677889900", "7788990011", "filip1@email.com", "pass123", doctorRepository.findById(1)));
        userRepository.save(new User("Ana", "Anić", "05/05/1999", "7788990011", "8899000122", "ana1@email.com", "pass456", doctorRepository.findById(2)));
        userRepository.save(new User("Luka", "Lukić", "06/10/1987", "8899000122", "9900011233", "luka1@email.com", "pass789", doctorRepository.findById(3)));
        userRepository.save(new User("Ema", "Emić", "07/15/1977", "9900011233", "0001122344", "ema1@email.com", "passabc", doctorRepository.findById(4)));
        userRepository.save(new User("David", "Davidović", "08/20/1992", "0001122344", "1112233455", "david@email.com", "passdef", doctorRepository.findById(5)));

    }

    // LOGIN
    @GetMapping("/login")
    public String login(Model model, @RequestParam("loginMail") String email, @RequestParam("loginPassword") String password) {
        User userlogin = userRepository.findByEmailAndPassword(email, password);
        Doctor doctorlogin = doctorRepository.findByEmailAndPassword(email, password);
        SuperAdmin superadminlogin = superAdminRepository.findByEmailAndPassword(email, password);
        if (userlogin != null) {
            user = userRepository.findById(userlogin.getId());
            return "redirect:/patient";
        } else if (doctorlogin != null) {
            doctor = doctorRepository.findById(doctorlogin.getId());
            return "redirect:/doctor";
        } else if (superadminlogin != null) {
            superAdmin = superadminlogin;
            return "redirect:/superadmin";
        } else {
            model.addAttribute("userMessage", "User not found");
            return "redirect:/pocetna";
        }
    }

    @GetMapping("/pocetna")
    public String pocetna() {
        return "login.html";
    }

    //PACIJENT
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

    @GetMapping("/patientHistory")
    public String measurements(Model model) {
        List<Measurement> measurementList = new ArrayList<>(measurementRepository.findByUser(user));
        model.addAttribute(measurementList);
        model.addAttribute("userId", user.getId());
        model.addAttribute("userName", user.getName());
        model.addAttribute("userLastName", user.getLastName());
        return "patientHistory.html";
    }

    //DOKTOR
    @GetMapping("/goToNewP")
    public String goToNewP(Model model) {
        model.addAttribute("doctorId", doctor.getId());
        model.addAttribute("doctorName", doctor.getName());
        model.addAttribute("doctorLastName", doctor.getLastName());
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
        model.addAttribute("userName", userlook.getName());
        model.addAttribute("userLastName", userlook.getLastName());
        List<Measurement> measurementList = new ArrayList<>(measurementRepository.findByUser(userlook));
        model.addAttribute("measurementList", measurementList);
        return "doctorPatientHistory.html";
    }

    @GetMapping("/deletePatient")
    public String deletePatient(@RequestParam("id") long id) {
        userRepository.deleteById(id);
        return "redirect:/doctor";
    }


    // SuperAdmin
    @GetMapping("/superadmin")
    public String doctors(Model model) {
        List<Doctor> doctorList = new ArrayList<>(doctorRepository.findBySuperadmin(superAdmin));
        model.addAttribute("adminName", superAdmin.getName());
        model.addAttribute("adminLastName", superAdmin.getLastName());
        model.addAttribute("doctorList", doctorList);
        return "superAdmin.html";
    }

    @GetMapping("/lookDoctorRecords")
    public String lookDoctorRecords(Model model, @RequestParam("id") long id) {
        model.addAttribute("patients", userRepository.findByDoctor_Id(id));
        Doctor doctorlook = doctorRepository.findById(id);
        model.addAttribute("doctorName", doctorlook.getName());
        model.addAttribute("doctorLastName", doctorlook.getLastName());
        List<User> userList = new ArrayList<>(userRepository.findByDoctor(doctorlook));
        model.addAttribute("userList", userList);
        return "superAdminlooksDoctors.html";
    }

    @GetMapping("/deleteDoctor")
    public String deleteDoctor(@RequestParam("id") long id) {
        doctorRepository.deleteById(id);
        return "redirect:/superadmin";
    }

    @GetMapping("/addNewDoctor")
    public String addNewDoctor(@RequestParam("doctorName") String name, @RequestParam("doctorLastName") String lastName,
                               @RequestParam("email") String email, @RequestParam("password") String pass, Model model) {
        model.addAttribute("adminName", superAdmin.getName());
        model.addAttribute("adminLastName", superAdmin.getLastName());
        Doctor newdoctor = new Doctor(name, lastName, email, pass, superAdmin);
        doctorRepository.save(newdoctor);
        return "redirect:/superadmin";
    }

    @GetMapping("/addDoctor")
    public String addDoctor(Model model) {
        model.addAttribute("adminName", superAdmin.getName());
        model.addAttribute("adminLastName", superAdmin.getLastName());
        return "superAdminAddDoctor.html";
    }

    //LOGOUT
    @GetMapping("/logOut")
    public String logOut(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        user = null;
        doctor = null;
        return "login.html";
    }
}
