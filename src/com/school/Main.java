package com.school;

import java.util.List;

public class Main {
    public static void displaySchoolDirectory(RegistrationService regService) {
        System.out.println("\nSchool Directory:");
        for (Person person : regService.getAllPeople()) {
            person.displayDetails();
        }
    }

    public static void main(String[] args) {
        System.out.println("--- School Management System ---");

        // Instantiate Services
        FileStorageService storageService = new FileStorageService();
        RegistrationService registrationService = new RegistrationService(storageService);
        AttendanceService attendanceService = new AttendanceService(storageService, registrationService);

        // Register Students
        registrationService.registerStudent("Alice Wonderland", "Grade 10");
        registrationService.registerStudent("Bob The Builder", "Grade 11");
        registrationService.registerStudent("Charlie Chaplin", "Grade 12");

        // Register Teachers
        registrationService.registerTeacher("Dr. John Smith", "Mathematics");
        registrationService.registerTeacher("Prof. Emily Johnson", "Computer Science");

        // Register Staff
        registrationService.registerStaff("Michael Brown", "Librarian");
        registrationService.registerStaff("Sarah Davis", "Administrator");

        // Register Courses
        registrationService.createCourse("Intro to Programming");
        registrationService.createCourse("Linear Algebra");
        registrationService.createCourse("Data Structures");

        // Display School Directory
        displaySchoolDirectory(registrationService);

        // Display Courses
        System.out.println("\nAvailable Courses:");
        for (Course course : registrationService.getCourses()) {
            course.displayDetails();
        }

        // Mark Attendance using overloaded methods
        attendanceService.markAttendance(1, 101, "Present");
        attendanceService.markAttendance(2, 102, "Absent");
        attendanceService.markAttendance(3, 103, "Late"); // Invalid status
        attendanceService.markAttendance(999, 101, "Present"); // Invalid student ID

        // Display Attendance using overloaded methods
        attendanceService.displayAttendanceLog();
        attendanceService.displayAttendanceLog(registrationService.findStudentById(1));
        attendanceService.displayAttendanceLog(registrationService.findCourseById(102));

        // Save Data
        registrationService.saveAllRegistrations();
        attendanceService.saveAttendanceData();

        System.out.println("\nPart 9: SOLID Service Layer with RegistrationService and AttendanceService Separation Implemented.");
    }
}