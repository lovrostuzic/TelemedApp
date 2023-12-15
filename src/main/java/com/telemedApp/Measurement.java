package com.telemedApp;

import jakarta.persistence.*;

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
    @JoinColumn
    private User user;


    public Measurement() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Measurement(int sisPressure, int dijPressure, int heartbeat, String desc, User user) {
        this.sisPressure = sisPressure;
        this.dijPressure = dijPressure;
        this.heartbeat = heartbeat;
        this.desc = desc;
        this.user = user;


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
