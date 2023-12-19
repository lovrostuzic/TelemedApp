package com.telemedApp;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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

    private static final String usbFilePath = "G:\\password.txt";
    //  User user = null;
    //  Doctor doctor = null;
    //  SuperAdmin superAdmin = null;

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

    @PostConstruct
    public void addMeasurementsForUsers() {
        Iterable<User> users = userRepository.findAll();
        for (User user : users) {
            for (int i = 0; i < 10; i++) {
                Measurement measurement = createRandomMeasurement(user);
                measurementRepository.save(measurement);
            }
        }
    }
@PostConstruct
public void run(ApplicationArguments args) throws Exception {
    RedirectView redirectView = new RedirectView("/pocetna");}
    // LOGIN
    @GetMapping("/login")
    public String login(Model model, @RequestParam("loginMail") String email, @RequestParam("loginPassword") String password, HttpServletRequest request) {
        User userlogin = userRepository.findByEmailAndPassword(email, password);
        Doctor doctorlogin = doctorRepository.findByEmailAndPassword(email, password);
        SuperAdmin superadminlogin = superAdminRepository.findByEmailAndPassword(email, password);
      //  boolean usb = checkUsb();
        if (userlogin != null) {
            User user = userRepository.findById(userlogin.getId());
            HttpSession session = request.getSession();
            session.setAttribute("loggedInUser", user);
            return "redirect:/patient";
        } else if (doctorlogin != null) {
            Doctor doctor = doctorRepository.findById(doctorlogin.getId());
            HttpSession session = request.getSession();
            session.setAttribute("loggedInDoctor", doctor);
            return "redirect:/doctor";
        } else if (superadminlogin != null) {
            SuperAdmin superAdmin = superadminlogin;
            HttpSession session = request.getSession();
            session.setAttribute("loggedInSuperAdmin", superAdmin);
            return "redirect:/superadmin";
        } else {
            model.addAttribute("userMessage", "Neuspjela prijava! Molimo pokušajte ponovo!");
            return "index.html";
        }
    }

    @GetMapping("/pocetna")
    public String pocetna() {
        return "index.html";
    }

    //PACIJENT
    @GetMapping("/patient")
    public String patient(Model model, HttpServletRequest request) {
        Object loggedInUser = request.getSession().getAttribute("loggedInUser");
        if (loggedInUser != null) {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("loggedInUser");
            model.addAttribute("measurements", measurementRepository.findByUser(user));
            model.addAttribute("userId", user.getId());
            model.addAttribute("userName", user.getName());
            model.addAttribute("userLastName", user.getLastName());
            return "patient.html";
        } else {
            return "redirect:/pocetna";
        }
    }

    @GetMapping("/addNewMeasurement")
    public String addNewTodo(Model model, HttpServletRequest request, @RequestParam("sisPress") int sisPress, @RequestParam("dijPress") int dijPress, @RequestParam("heartRate") int heartRate, @RequestParam("desc") String desc) {
        Object loggedInUser = request.getSession().getAttribute("loggedInUser");
        if (loggedInUser != null) {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("loggedInUser");
            measurementRepository.save(new Measurement(sisPress, dijPress, heartRate, desc, user));
            model.addAttribute("measurements", measurementRepository.findByUser(user));
            model.addAttribute("userId", user.getId());
            model.addAttribute("userName", user.getName());
            model.addAttribute("userLastName", user.getLastName());
            model.addAttribute("userMessage", "Podaci zaprimljeni!");
            return "patient.html";
        } else {
            return "redirect:/pocetna";
        }

    }

    @GetMapping("/patientHistory")
    public String measurements(Model model, HttpServletRequest request) {
        Object loggedInUser = request.getSession().getAttribute("loggedInUser");
        if (loggedInUser != null) {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("loggedInUser");
            List<Measurement> measurementList = new ArrayList<>(measurementRepository.findByUser(user));
            model.addAttribute(measurementList);
            model.addAttribute("userId", user.getId());
            model.addAttribute("userName", user.getName());
            model.addAttribute("userLastName", user.getLastName());
            return "patientHistory.html";
        } else {
            return "redirect:/pocetna";
        }
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("mid") long measurementId) {
        measurementRepository.deleteById(measurementId);
        return "redirect:/patient";
    }


    //DOKTOR
    @GetMapping("/goToNewP")
    public String goToNewP(Model model, HttpServletRequest request) {
        Object loggedInDoctor = request.getSession().getAttribute("loggedInDoctor");
        if (loggedInDoctor != null) {
            HttpSession session = request.getSession();
            Doctor doctor = (Doctor) session.getAttribute("loggedInDoctor");
            model.addAttribute("doctorId", doctor.getId());
            model.addAttribute("doctorName", doctor.getName());
            model.addAttribute("doctorLastName", doctor.getLastName());
            return "newPatient.html";
        } else {
            return "redirect:/pocetna";

        }
    }

    @GetMapping("/addNewPatient")
    public String addNewPatient(@RequestParam("newPatientName") String name, @RequestParam("newPatientLastName") String lastName,
                                @RequestParam("dateOfBirth") String dateOfBirth, @RequestParam("newOib") String oib,
                                @RequestParam("newMobilePhone") String phoneNumber, @RequestParam("email") String email, @RequestParam("password") String pass, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Doctor doctor = (Doctor) session.getAttribute("loggedInDoctor");
        User newUser = new User(name, lastName, dateOfBirth, oib, phoneNumber, email, pass, doctor);
        userRepository.save(newUser);
        return "redirect:/doctor";
    }

    @GetMapping("/doctor")
    public String patients(Model model, HttpServletRequest request) {
        Doctor loggedInDoctor = (Doctor) request.getSession().getAttribute("loggedInDoctor");
        if (loggedInDoctor != null) {
            List<User> patientList = new ArrayList<>(userRepository.findByDoctor(loggedInDoctor));
            model.addAttribute("doctorName", loggedInDoctor.getName());
            model.addAttribute("doctorLastName", loggedInDoctor.getLastName());
            model.addAttribute("patientList", patientList);
            return "doctor.html";
        } else {
            return "redirect:/pocetna";

        }
    }

    @GetMapping("/doctorPocetna")
    public String doctorPocetna(Model model, HttpServletRequest request) {
        Doctor loggedInDoctor = (Doctor) request.getSession().getAttribute("loggedInDoctor");
        if (loggedInDoctor != null) {
            HttpSession session = request.getSession();
            model.addAttribute(userRepository.findByDoctor(loggedInDoctor));
            return "doctor.html";
        } else {
            return "redirect:/pocetna";

        }

    }

    @GetMapping("/lookRecords")
    public String lookRecords(Model model, @RequestParam("id") long id, HttpServletRequest request) {
        Doctor loggedInDoctor = (Doctor) request.getSession().getAttribute("loggedInDoctor");
        if (loggedInDoctor != null) {
            model.addAttribute("measurements", measurementRepository.findByUserId(id));
            User userlook = userRepository.findById(id);
            model.addAttribute("userName", userlook.getName());
            model.addAttribute("userLastName", userlook.getLastName());
            List<Measurement> measurementList = new ArrayList<>(measurementRepository.findByUser(userlook));
            model.addAttribute("measurementList", measurementList);
            return "doctorPatientHistory.html";
        } else {
            return "redirect:/pocetna";

        }


    }

    @GetMapping("/deletePatient")
    public String deletePatient(@RequestParam("id") long id, HttpServletRequest request, Model model) {
        Doctor loggedInDoctor = (Doctor) request.getSession().getAttribute("loggedInDoctor");
        if (loggedInDoctor != null) {
            measurementRepository.deleteByUser(userRepository.findById(id));
            userRepository.deleteById(id);
            model.addAttribute("userMessage", "Pacijent obrisan!");
            return "redirect:/doctor";
        } else {
            return "redirect:/pocetna";

        }

    }

    // SuperAdmin
    @GetMapping("/superadmin")
    public String doctors(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        SuperAdmin superAdmin = (SuperAdmin) session.getAttribute("loggedInSuperAdmin");
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
    public String deleteDoctor(@RequestParam("id") long id, HttpServletRequest request, Model model) {
        SuperAdmin loggedInSuperAdmin = (SuperAdmin) request.getSession().getAttribute("loggedInSuperAdmin");
        if (loggedInSuperAdmin != null) {
            Doctor doctornull = null;
            userRepository.updateDoctorByDoctor(doctornull, doctorRepository.findById(id));
            doctorRepository.deleteById(id);
            model.addAttribute("userMessage", "Doktor obrisan!");
            List<Doctor> doctorList = new ArrayList<>(doctorRepository.findBySuperadmin(loggedInSuperAdmin));
            model.addAttribute("adminName", loggedInSuperAdmin.getName());
            model.addAttribute("adminLastName", loggedInSuperAdmin.getLastName());
            model.addAttribute("doctorList", doctorList);

            return "superAdmin.html";
        } else {
            return "redirect:/pocetna";

        }

    }

    @GetMapping("/addNewDoctor")
    public String addNewDoctor(@RequestParam("doctorName") String name, @RequestParam("doctorLastName") String lastName,
                               @RequestParam("email") String email, @RequestParam("password") String pass, Model model, HttpServletRequest request) {
        SuperAdmin loggedInSuperAdmin = (SuperAdmin) request.getSession().getAttribute("loggedInSuperAdmin");
        if (loggedInSuperAdmin != null) {
            HttpSession session = request.getSession();
            model.addAttribute("adminName", loggedInSuperAdmin.getName());
            model.addAttribute("adminLastName", loggedInSuperAdmin.getLastName());
            Doctor newdoctor = new Doctor(name, lastName, email, pass, loggedInSuperAdmin);
            doctorRepository.save(newdoctor);
            model.addAttribute("userMessage", "Doktor dodan!");
            return "superAdminAddDoctor.html";
        } else {
            return "redirect:/pocetna";
        }

    }

    @GetMapping("/addDoctor")
    public String addDoctor(Model model, HttpServletRequest request) {
        SuperAdmin loggedInSuperAdmin = (SuperAdmin) request.getSession().getAttribute("loggedInSuperAdmin");
        if (loggedInSuperAdmin != null) {
            model.addAttribute("adminName", loggedInSuperAdmin.getName());
            model.addAttribute("adminLastName", loggedInSuperAdmin.getLastName());
            return "superAdminAddDoctor.html";
        } else {
            return "redirect:/pocetna";

        }
    }

    //LOGOUT
    @GetMapping("/logOut")
    public String logOut(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        // user = null;
        // doctor = null
        // superAdmin = null;
        return "redirect:/pocetna";
    }

    //SEARCH
    @GetMapping("/search")
    public String search(Model model, HttpServletRequest request, @RequestParam("searchTerm") String searchTerm) {
        Doctor loggedInDoctor = (Doctor) request.getSession().getAttribute("loggedInDoctor");
        if (loggedInDoctor != null) {
            String[] parts = searchTerm.split(" ");
            String name = parts[0];
            String lastName = (parts.length > 1) ? parts[1] : "";
            List<User> patientList;
            if (!lastName.isEmpty()) {
                patientList = new ArrayList<>(userRepository.findByDoctorAndNameAndLastNameOrderByNameAsc(loggedInDoctor, name, lastName));
            } else {
                patientList = new ArrayList<>(userRepository.findByDoctorAndNameOrLastNameOrderByNameAsc(loggedInDoctor, name, name));
            }
            model.addAttribute("doctorName", loggedInDoctor.getName());
            model.addAttribute("doctorLastName", loggedInDoctor.getLastName());
            model.addAttribute("patientList", patientList);
            return "doctor.html";
        } else {
            return "redirect:/pocetna";

        }

    }

    // NE DIRAJ ZONA
    private boolean checkUsb() {
        File usbFile = new File(usbFilePath);
        boolean usb = false;
        if (usbFile.exists()) {
            try {
                String passwordFromUSB = new String(Files.readAllBytes(Paths.get(usbFilePath)));
                String expectedPassword = "ExtraJakiPasword9000";
                if (passwordFromUSB.equals(expectedPassword)) {
                    usb = true;
                } else {
                    usb = false;
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        return usb;
    }

    private Measurement createRandomMeasurement(User user) {
        int sisPressure = (int) (Math.random() * 40) + 90;  // 90-130 mmHg
        int dijPressure = (int) (Math.random() * 20) + 60;  // 60-80 mmHg
        int heartbeat = (int) (Math.random() * 50) + 50;     // 50-100 otkucaja/min
        String desc = "Napomena o mjerenju " + (int) (Math.random() * 100);
        return new Measurement(sisPressure, dijPressure, heartbeat, desc, user);
    }


}
