package com.cs425.repository;

import com.cs425.database.ADSmgtsysdb;
import com.cs425.models.Surgery;

import java.util.List;

public class SurgeryRepository {

    private static SurgeryRepository instance;
    private final ADSmgtsysdb db;

    private SurgeryRepository() {
        db = ADSmgtsysdb.getDBInstance();
    }

    public static synchronized SurgeryRepository getInstance() {
        if (instance == null) {
            instance = new SurgeryRepository();
        }
        return instance;
    }

    public List<Surgery> findAll() {
        return db.getSurgeries();
    }

    public Surgery findById(Long id) {
        return db.getSurgeries()
                .stream()
                .filter(s -> s.getSurgeryId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void save(Surgery surgery) {
        db.getSurgeries().add(surgery);
    }

    public boolean delete(Long id) {
        return db.getSurgeries()
                .removeIf(s -> s.getSurgeryId().equals(id));
    }
}