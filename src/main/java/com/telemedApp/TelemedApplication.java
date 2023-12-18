package com.telemedApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TelemedApplication {

    public static void main(String[] args) {
        SpringApplication.run(TelemedApplication.class, args);
        System.out.println("Startup successful!");
        System.out.println("Go to :");
        System.out.println("http://localhost:8080/pocetna");
    }

}