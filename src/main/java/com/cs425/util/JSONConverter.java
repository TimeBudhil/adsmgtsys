package com.cs425.util;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONObject;

import com.cs425.models.Appointment;
import com.cs425.models.Patient;

public class JSONConverter {

    public static String convertPatientArrayToJSON(Patient[] patients) {
        JSONArray jsonArray = new JSONArray();

        Arrays.stream(patients)
                .forEach(patient -> jsonArray.put(patient.toJSON()));

        return jsonArray.toString(2);
    }

    public static String convertAppointmentArrayToJSON(Appointment[] appointments) {

        JSONArray jsonArray = new JSONArray();

        Arrays.stream(appointments)
                .forEach(appointment -> {

                    JSONObject appointmentJson = new JSONObject();

                    appointmentJson.put(
                            "appointmentId",
                            appointment.getAppointmentId());

                    appointmentJson.put(
                            "bookingDate",
                            appointment.getBookingDate());

                    appointmentJson.put(
                            "appointmentDateTime",
                            appointment.getAppointmentDateTime());

                    appointmentJson.put(
                            "status",
                            appointment.getStatus().name());

                    // Patient + Age
                    JSONObject patientJson =
                            appointment.getPatient().toJSON();

                    int age = Period.between(
                            appointment.getPatient().getDateOfBirth(),
                            LocalDate.now())
                            .getYears();

                    patientJson.put("age", age);

                    appointmentJson.put(
                            "patient",
                            patientJson);

                    // Dentist
                    appointmentJson.put(
                            "dentist",
                            appointment.getDentist().toJSON());

                    // Surgery
                    appointmentJson.put(
                            "surgery",
                            appointment.getSurgery().toJSON());

                    jsonArray.put(appointmentJson);
                });

        return jsonArray.toString(2);
    }

}
