package HMP;

import java.util.ArrayList;
import java.util.Scanner;

public class HospitalManagement {
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<Doctor> doctors = new ArrayList<>();
    private static ArrayList<Appointment> appointments = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n      Hospital Management System      ");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. View Patients");
            System.out.println("5. View Doctors");
            System.out.println("6. View Appointments");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }

            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addPatient(scanner);
                case 2 -> addDoctor(scanner);
                case 3 -> scheduleAppointment(scanner);
                case 4 -> viewPatients();
                case 5 -> viewDoctors();
                case 6 -> viewAppointments();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }

    private static void addPatient(Scanner scanner) {
        System.out.print("Enter Patient Name: ");
        String name = scanner.next();

        int age = -1;
        while (true) {
            System.out.print("Enter Patient Age: ");
            if (scanner.hasNextInt()) {
                age = scanner.nextInt();
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }

        System.out.print("Enter Patient Gender: ");
        String gender = scanner.next();

        Patient patient = new Patient(name, age, gender);
        patients.add(patient);

        System.out.println("Patient added successfully!");
    }

    private static void addDoctor(Scanner scanner) {
        System.out.print("Enter Doctor Name: ");
        String name = scanner.next();
        System.out.print("Enter Doctor Specialty: ");
        String specialty = scanner.next();

        Doctor doctor = new Doctor(name, specialty);
        doctors.add(doctor);

        System.out.println("Doctor added successfully!");
    }

    private static void scheduleAppointment(Scanner scanner) {
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        System.out.print("Enter Doctor ID: ");
        int doctorId = scanner.nextInt();
        System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
        String date = scanner.next();

        Patient patient = findPatientById(patientId);
        Doctor doctor = findDoctorById(doctorId);

        if (patient != null && doctor != null) {
            Appointment appointment = new Appointment(patient, doctor, date);
            appointments.add(appointment);
            System.out.println("Appointment scheduled successfully!");
        } else {
            System.out.println("Invalid Patient ID or Doctor ID.");
        }
    }

    private static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
        } else {
            System.out.println("\nList of Patients:");
            for (Patient patient : patients) {
                System.out.println(patient);
            }
        }
    }

    private static void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
        } else {
            System.out.println("\nList of Doctors:");
            for (Doctor doctor : doctors) {
                System.out.println(doctor);
            }
        }
    }

    private static void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments scheduled.");
        } else {
            System.out.println("\nList of Appointments:");
            for (Appointment appointment : appointments) {
                System.out.println(appointment);
            }
        }
    }

    private static Patient findPatientById(int id) {
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }

    private static Doctor findDoctorById(int id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }
        return null;
    }
}
