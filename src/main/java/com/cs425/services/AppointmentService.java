package com.cs425.services;

import com.cs425.models.Appointment;
import com.cs425.repository.AppointmentRepository;
import com.cs425.util.JSONConverter;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class AppointmentService {

    private static AppointmentService instance;

    private final AppointmentRepository appointmentRepository;

    private AppointmentService() {
        appointmentRepository = AppointmentRepository.getInstance();
    }

    public static synchronized AppointmentService getInstance() {

        if (instance == null) {
            instance = new AppointmentService();
        }

        return instance;
    }

    /**
     * Requirement 4.2.1
     */
    public void printAllAppointments() {

        Appointment[] appointments =
                appointmentRepository.findAll()
                        .stream()
                        .sorted(
                                Comparator.comparing(
                                        Appointment::getAppointmentDateTime)
                                        .reversed())
                        .toArray(Appointment[]::new);

        System.out.println(
                JSONConverter.convertAppointmentArrayToJSON(
                        appointments));
    }

    /**
     * Requirement 4.2.2
     */
    public void printQuarterlyUpcomingAppointments() {

        QuarterInfo nextQuarter =
                determineNextQuarter(LocalDate.now());

        Appointment[] appointments =
                appointmentRepository.findAll()
                        .stream()
                        .filter(a -> {

                            LocalDate date =
                                    a.getAppointmentDateTime()
                                            .toLocalDate();

                            return date.getYear() == nextQuarter.year()
                                    && date.getMonthValue() >= nextQuarter.startMonth()
                                    && date.getMonthValue() <= nextQuarter.endMonth();
                        })
                        .sorted(
                                Comparator.comparing(
                                        Appointment::getAppointmentDateTime))
                        .toArray(Appointment[]::new);

        System.out.println(
                JSONConverter.convertAppointmentArrayToJSON(
                        appointments));
    }

    private QuarterInfo determineNextQuarter(LocalDate currentDate) {

        int month = currentDate.getMonthValue();
        int year = currentDate.getYear();

        if (month <= 3) {
            return new QuarterInfo(year, 4, 6);
        }

        if (month <= 6) {
            return new QuarterInfo(year, 7, 9);
        }

        if (month <= 9) {
            return new QuarterInfo(year, 10, 12);
        }

        return new QuarterInfo(year + 1, 1, 3);
    }

    private record QuarterInfo(
            int year,
            int startMonth,
            int endMonth) {
    }
}