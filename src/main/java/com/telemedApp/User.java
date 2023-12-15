package com.telemedApp;

import jakarta.persistence.*;

@Entity(name = "App_User")
public class User {

    @Id
    @GeneratedValue()
    long id;
    private String name;
    private String lastName;
    private String birthDate;
    private String oib;
    private String phoneNumber;
    private String email;
    private String password;
    @ManyToOne
    @JoinColumn(name = "doctorId")
    private Doctor doctor;

    public long getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public User() {

    }

    public User(String name, String lastName, String birthDate, String oib, String phoneNumber, String email, String password, Doctor doctor) {

        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.oib = oib;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.doctor = doctor;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
