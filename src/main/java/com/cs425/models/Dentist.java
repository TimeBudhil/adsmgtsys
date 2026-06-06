package com.cs425.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.json.JSONObject;

public class Dentist {

    private Long dentistId;

    private String firstName;
    private String lastName;
    private String specialization;
    private String phoneNumber;
    private String email;

    private List<Appointment> appointments;

    public Dentist(Long dentistId,
                String firstName,
                String lastName,
                String specialization,
                String phoneNumber,
               String email) {

        if (dentistId == null || firstName == null || lastName == null ||
            specialization == null || phoneNumber == null || email == null) {
            throw new IllegalArgumentException("Constructor arguments cannot be null");
        }

        this.dentistId = dentistId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
        this.phoneNumber = phoneNumber;
        this.email = email;

        this.appointments = new ArrayList<>();
    }

    public Long getDentistId() {
        return dentistId;
    }

    public void setDentistId(Long dentistId) {
        this.dentistId = dentistId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
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

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        return "Dentist{" +
                "dentistId=" + dentistId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", specialization='" + specialization + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();

        json.put("dentistId", dentistId);
        json.put("firstName", firstName);
        json.put("lastName", lastName);
        json.put("specialization", specialization);
        json.put("phoneNumber", phoneNumber);
        json.put("email", email);

        return json;
    }
}