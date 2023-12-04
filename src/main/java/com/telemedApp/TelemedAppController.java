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


    @GetMapping("/login")
    public void login() {
    }

    @GetMapping("/patient")
    public String measurements(Model model) {
        model.addAttribute(measurementList);
        return "patient.html";
    }

    @GetMapping("/addNewMeasurement")
    public String addNewTodo(@RequestParam("sisPress") int sisPress, @RequestParam("dijPress") int dijPress, @RequestParam("heartRate") int heartRate, @RequestParam("desc") String desc) {
        measurementList.add(new Measurement(measurementList.size() + 1, sisPress, dijPress, heartRate, desc));
        return "redirect:/patient";
    }

    @GetMapping("/delete")
    public String deleteTodo(@RequestParam("measurementNumber") int mN) {
        for (Measurement measurement : measurementList) {
            if (measurement.getMeasurementNumber() == mN) {
                measurementList.remove(measurement);
                break;
            }
        }
        return "redirect:/patientHistory";

    }
}
