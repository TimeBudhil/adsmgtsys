package com.cs425.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import org.json.JSONObject;

public class Appointment {

    private Long appointmentId;

    // Date when appointment was booked
    private LocalDate bookingDate;

    // Date and time patient will see dentist
    private LocalDateTime appointmentDateTime;

    // Appointment status
    private AppointmentStatus status;

    // Relationships
    private Patient patient;
    private Dentist dentist;
    private Surgery surgery;

    public Appointment(Long appointmentId,
                    LocalDate bookingDate,
                    LocalDateTime appointmentDateTime,
                    AppointmentStatus status,
                    Patient patient,
                    Dentist dentist,
                    Surgery surgery) {

        if (appointmentId == null || bookingDate == null ||
            appointmentDateTime == null || status == null ||
            patient == null || dentist == null || surgery == null) {
            throw new IllegalArgumentException("Constructor arguments cannot be null");
        }

        this.appointmentId = appointmentId;
        this.bookingDate = bookingDate;
        this.appointmentDateTime = appointmentDateTime;
        this.status = status;
        this.patient = patient;
        this.dentist = dentist;
        this.surgery = surgery;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    public Surgery getSurgery() {
        return surgery;
    }

    public void setSurgery(Surgery surgery) {
        this.surgery = surgery;
    }
    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", bookingDate=" + bookingDate +
                ", appointmentDateTime=" + appointmentDateTime +
                ", status=" + status +
                ", patient=" + patient +
                ", dentist=" + dentist +
                ", surgery=" + surgery +
                '}';
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();

        json.put("appointmentId", appointmentId);
        json.put("bookingDate",
                bookingDate != null ? bookingDate.toString() : JSONObject.NULL);

        json.put("appointmentDateTime",
                appointmentDateTime != null
                        ? appointmentDateTime.toString()
                        : JSONObject.NULL);

        json.put("status",
                status != null ? status.name() : JSONObject.NULL);

        json.put("patient",
                patient != null ? patient.toJSON() : JSONObject.NULL);

        json.put("dentist",
                dentist != null ? dentist.toJSON() : JSONObject.NULL);

        json.put("surgery",
                surgery != null ? surgery.toJSON() : JSONObject.NULL);

        return json;
    }
}