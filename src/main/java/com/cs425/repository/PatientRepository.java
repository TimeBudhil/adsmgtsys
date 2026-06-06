package com.cs425.repository;

import com.cs425.database.ADSmgtsysdb;
import com.cs425.models.Patient;

import java.util.List;

public class PatientRepository {

    private static PatientRepository instance;
    private final ADSmgtsysdb db;

    private PatientRepository() {
        db = ADSmgtsysdb.getDBInstance();
    }

    public static synchronized PatientRepository getInstance() {
        if (instance == null) {
            instance = new PatientRepository();
        }
        return instance;
    }

    public List<Patient> findAll() {
        return db.getPatients();
    }

    public Patient findById(Long id) {
        return db.getPatients()
                .stream()
                .filter(p -> p.getPatientId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void save(Patient patient) {
        db.getPatients().add(patient);
    }

    public boolean delete(Long id) {
        return db.getPatients()
                .removeIf(p -> p.getPatientId().equals(id));
    }
}