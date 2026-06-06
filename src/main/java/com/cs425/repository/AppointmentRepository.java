package com.cs425.repository;

import com.cs425.database.ADSmgtsysdb;
import com.cs425.models.Appointment;

import java.util.List;

public class AppointmentRepository {

    private static AppointmentRepository instance;
    private final ADSmgtsysdb db;

    private AppointmentRepository() {
        db = ADSmgtsysdb.getDBInstance();
    }

    public static synchronized AppointmentRepository getInstance() {
        if (instance == null) {
            instance = new AppointmentRepository();
        }
        return instance;
    }

    public List<Appointment> findAll() {
        return db.getAppointments();
    }

    public Appointment findById(Long id) {
        return db.getAppointments()
                .stream()
                .filter(a -> a.getAppointmentId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void save(Appointment appointment) {
        db.getAppointments().add(appointment);
    }

    public boolean delete(Long id) {
        return db.getAppointments()
                .removeIf(a -> a.getAppointmentId().equals(id));
    }
}