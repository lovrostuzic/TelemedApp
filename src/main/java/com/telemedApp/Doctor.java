package com.telemedApp;

import jakarta.persistence.*;

import java.util.Optional;

@Entity(name = "Doctor")
public class Doctor {
    @Id
    @GeneratedValue()
    long id;

    private String name;
    private String lastName;
    private String email;
    private String password;

    @ManyToOne
    @JoinColumn(name = "superadminId")
    private SuperAdmin superadmin;

    public SuperAdmin getSuperadmin() {
        return superadmin;
    }

    public void setSuperadmin(SuperAdmin superadmin) {
        this.superadmin = superadmin;
    }

    public Doctor() {
    }

    public Doctor(String name, String lastName, String email, String password, SuperAdmin superAdmin) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.superadmin = superAdmin;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
