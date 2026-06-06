package com.cs425.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONObject;

public class Patient {

    private Long patientId;

    private String firstName;
    private String lastName;
    private String mailingAddress;
    private String phoneNumber;
    private String email;
    private LocalDate dateOfBirth;

    // Patient's appointments
    private List<Appointment> appointments;

    public Patient(Long patientId,
                String firstName,
                String lastName,
                String mailingAddress,
                String phoneNumber,
                String email,
                LocalDate dateOfBirth) {

        if (patientId == null || firstName == null || lastName == null ||
            mailingAddress == null || phoneNumber == null ||
            email == null || dateOfBirth == null) {
            throw new IllegalArgumentException("Constructor arguments cannot be null");
        }

        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mailingAddress = mailingAddress;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dateOfBirth = dateOfBirth;

        this.appointments = new ArrayList<>();
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
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

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public JSONObject toJSON() {
    JSONObject json = new JSONObject();

    json.put("patientId", patientId);
    json.put("firstName", firstName);
    json.put("lastName", lastName);
    json.put("mailingAddress", mailingAddress);
    json.put("phoneNumber", phoneNumber);
    json.put("email", email);
    json.put("dateOfBirth", dateOfBirth != null ? dateOfBirth.toString() : JSONObject.NULL);


    return json;
    }


}