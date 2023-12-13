package com.telemedApp;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Measurement {
    @Id
    @GeneratedValue
    private Long id;


    private Date date;
    private int sisPressure;
    private int dijPressure;
    private int heartbeat;
    private String desc;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Measurement(int measurementNumber, int sisPressure, int dijPressure, int heartbeat, String desc) {

        this.sisPressure = sisPressure;
        this.dijPressure = dijPressure;
        this.heartbeat = heartbeat;
        this.desc = desc;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
