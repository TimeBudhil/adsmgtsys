package com.cs425.repository;

import com.cs425.database.ADSmgtsysdb;
import com.cs425.models.Dentist;

import java.util.List;

public class DentistRepository {

    private static DentistRepository instance;
    private final ADSmgtsysdb db;

    private DentistRepository() {
        db = ADSmgtsysdb.getDBInstance();
    }

    public static synchronized DentistRepository getInstance() {
        if (instance == null) {
            instance = new DentistRepository();
        }
        return instance;
    }

    public List<Dentist> findAll() {
        return db.getDentists();
    }

    public Dentist findById(Long id) {
        return db.getDentists()
                .stream()
                .filter(d -> d.getDentistId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void save(Dentist dentist) {
        db.getDentists().add(dentist);
    }

    public boolean delete(Long id) {
        return db.getDentists()
                .removeIf(d -> d.getDentistId().equals(id));
    }
}