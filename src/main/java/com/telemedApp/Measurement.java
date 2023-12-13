package com.telemedApp;

import jakarta.persistence.*;

import java.util.Optional;

@Entity
public class Measurement {
    @Id
    @GeneratedValue
    private long id;

    private int sisPressure;
    private int dijPressure;
    private int heartbeat;
    private String desc;
    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;

    public Measurement() {
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Measurement(Optional<User> user, int sisPressure, int dijPressure, int heartbeat, String desc) {

        this.sisPressure = sisPressure;
        this.dijPressure = dijPressure;
        this.heartbeat = heartbeat;
        this.desc = desc;


    }

    public int getSisPressure() {
        return sisPressure;
    }

    public void setSisPressure(int sisPressure) {
        this.sisPressure = sisPressure;
    }

    public int getDijPressure() {
        return dijPressure;
    }

    public void setDijPressure(int dijPressure) {
        this.dijPressure = dijPressure;
    }

    public int getHeartbeat() {
        return heartbeat;
    }

    public void setHeartbeat(int heartbeat) {
        this.heartbeat = heartbeat;
    }
}
