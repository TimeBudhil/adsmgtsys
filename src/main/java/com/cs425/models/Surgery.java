package com.cs425.models;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class Surgery {

    private Long surgeryId;

    private String name;
    private String location;
    private String phoneNumber;

    private List<Appointment> appointments;

    public Surgery(Long surgeryId,
                String name,
                String location,
                String phoneNumber) {

        if (surgeryId == null || name == null || location == null || phoneNumber == null) {
            throw new IllegalArgumentException("Constructor arguments cannot be null");
        }

        this.surgeryId = surgeryId;
        this.name = name;
        this.location = location;
        this.phoneNumber = phoneNumber;

        this.appointments = new ArrayList<>();
    }

    public Long getSurgeryId() {
        return surgeryId;
    }

    public void setSurgeryId(Long surgeryId) {
        this.surgeryId = surgeryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        return "Surgery{" +
                "surgeryId=" + surgeryId +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();

        json.put("surgeryId", surgeryId);
        json.put("name", name);
        json.put("location", location);
        json.put("phoneNumber", phoneNumber);

        return json;
    }
}