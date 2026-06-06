package com.cs425.database;

import com.cs425.models.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ADSmgtsysdb {

    // Singleton instance
    private static ADSmgtsysdb instance;

    // In-memory collections
    private final List<Patient> patients;
    private final List<Dentist> dentists;
    private final List<Surgery> surgeries;
    private final List<Appointment> appointments;

    // Private constructor
    private ADSmgtsysdb() {
        patients = new ArrayList<>();
        dentists = new ArrayList<>();
        surgeries = new ArrayList<>();
        appointments = new ArrayList<>();
        loadData();
    }

    /**
     * Returns singleton DB instance.
     */
    public static synchronized ADSmgtsysdb getDBInstance() {
        if (instance == null) {
            instance = new ADSmgtsysdb();
        }
        return instance;
    }

    /**
     * Load initial data into memory.
     */
    public void loadData() {
        if (!patients.isEmpty()) {
            return; // already loaded
        }

        // ==========================
        // Dentists
        // ==========================
        Dentist dentist1 = new Dentist(
                101L,
                "Michael",
                "Brown",
                "General Dentistry",
                "(641) 555-1001",
                "mbrown@ads.com");

        Dentist dentist2 = new Dentist(
                102L,
                "Sarah",
                "Wilson",
                "Orthodontics",
                "(641) 555-1002",
                "swilson@ads.com");

        dentists.add(dentist1);
        dentists.add(dentist2);

        // ==========================
        // Surgery
        // ==========================
        Surgery surgery = new Surgery(
                201L,
                "American Dental Surgery",
                "Fairfield, IA",
                "(641) 555-2000");

        surgeries.add(surgery);

        // ==========================
        // Patients
        // ==========================
        Patient p1 = new Patient(
                1L,
                "John",
                "Smith",
                "Fairfield, IA",
                "(641) 001-1234",
                "john.smith@email.com",
                LocalDate.of(1987, 1, 19));

        Patient p2 = new Patient(
                2L,
                "Anna",
                "Jones",
                "Iowa City, IA",
                "(319) 716-1987",
                "anna.jones@email.com",
                LocalDate.of(2001, 7, 26));

        Patient p3 = new Patient(
                3L,
                "Carlos",
                "Jimenez",
                "Cedar Rapids, IA",
                "(319) 098-7711",
                "carlos.jimenez@email.com",
                LocalDate.of(1969, 11, 5));

        Patient p4 = new Patient(
                4L,
                "Albert",
                "Einstein",
                "Fairfield, IA",
                "(641) 119-6142",
                "albert.einstein@email.com",
                LocalDate.of(1955, 12, 28));

        patients.add(p1);
        patients.add(p2);
        patients.add(p3);
        patients.add(p4);

        // ==========================
        // Appointments
        // ==========================

        Appointment a1 = new Appointment(
                1L,
                LocalDate.now(),
                LocalDateTime.of(2026, 2, 28, 10, 5),
                AppointmentStatus.BOOKED,
                p1,
                dentist1,
                surgery);

        Appointment a2 = new Appointment(
                2L,
                LocalDate.now(),
                LocalDateTime.of(2025, 12, 31, 13, 45),
                AppointmentStatus.BOOKED,
                p2,
                dentist2,
                surgery);

        Appointment a3 = new Appointment(
                3L,
                LocalDate.now(),
                LocalDateTime.of(2027, 5, 4, 14, 0),
                AppointmentStatus.BOOKED,
                p3,
                dentist1,
                surgery);

        Appointment a4 = new Appointment(
                4L,
                LocalDate.now(),
                LocalDateTime.of(2026, 9, 16, 11, 15),
                AppointmentStatus.BOOKED,
                p4,
                dentist2,
                surgery);

        appointments.add(a1);
        appointments.add(a2);
        appointments.add(a3);
        appointments.add(a4);

        // ==========================
        // Establish Relationships
        // ==========================

        p1.getAppointments().add(a1);
        p2.getAppointments().add(a2);
        p3.getAppointments().add(a3);
        p4.getAppointments().add(a4);

        dentist1.getAppointments().add(a1);
        dentist1.getAppointments().add(a3);

        dentist2.getAppointments().add(a2);
        dentist2.getAppointments().add(a4);

        surgery.getAppointments().add(a1);
        surgery.getAppointments().add(a2);
        surgery.getAppointments().add(a3);
        surgery.getAppointments().add(a4);
    }
    // --------------------
    // Getters
    // --------------------

    public List<Patient> getPatients() {
        return patients;
    }

    public List<Dentist> getDentists() {
        return dentists;
    }

    public List<Surgery> getSurgeries() {
        return surgeries;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }
}