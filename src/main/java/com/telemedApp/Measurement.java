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
    private long userId;

    public Measurement() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Measurement(long userId, int sisPressure, int dijPressure, int heartbeat, String desc) {
        this.userId = userId;
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
