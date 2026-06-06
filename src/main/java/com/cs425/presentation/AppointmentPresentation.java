package com.cs425.presentation;

import com.cs425.services.AppointmentService;

import java.util.Scanner;

public class AppointmentPresentation {

    private static AppointmentPresentation instance;
    private final AppointmentService appointmentService;
    private final Scanner scanner;

    private AppointmentPresentation() {
        appointmentService = AppointmentService.getInstance();
        scanner = new Scanner(System.in);
    }

    public static synchronized AppointmentPresentation getInstance() {
        if (instance == null) {
            instance = new AppointmentPresentation();
        }
        return instance;
    }

    public void startCLI() {
        System.out.println("=== Welcome to the Appointment CLI ===");

        boolean running = true;

        while (running) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. View all appointments (JSON)");
            System.out.println("2. View upcoming quarterly appointments (JSON)");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.println("\nAll Appointments:");
                    appointmentService.printAllAppointments();
                    break;
                case "2":
                    System.out.println("\nUpcoming Quarterly Appointments:");
                    appointmentService.printQuarterlyUpcomingAppointments();
                    break;
                case "3":
                    System.out.println("Exiting CLI. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
    }

    public static void main(String[] args) {
        AppointmentPresentation.getInstance().startCLI();
    }
}