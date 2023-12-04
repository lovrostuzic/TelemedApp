package com.telemedApp;

import java.util.Date;

public class Measurement {
    private int measurementNumber;
    private Date date;
    private int sisPressure;
    private int dijPressure;
    private int heartbeat;
    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Measurement(int measurementNumber, int sisPressure, int dijPressure, int heartbeat, String desc) {
        this.measurementNumber = measurementNumber;
        this.sisPressure = sisPressure;
        this.dijPressure = dijPressure;
        this.heartbeat = heartbeat;
        this.desc = desc;
    }

    public int getMeasurementNumber() {
        return measurementNumber;
    }

    public void setMeasurementNumber(int measurementNumber) {
        this.measurementNumber = measurementNumber;
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
