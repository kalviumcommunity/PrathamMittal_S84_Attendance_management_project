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

        // Register Courses with Capacity
        registrationService.createCourse("Intro to Programming", 2);
        registrationService.createCourse("Linear Algebra", 2);
        registrationService.createCourse("Data Structures", 1);

        // Enroll Students in Courses
        registrationService.enrollStudentInCourse(registrationService.findStudentById(1), registrationService.findCourseById(101));
        registrationService.enrollStudentInCourse(registrationService.findStudentById(2), registrationService.findCourseById(101));
        registrationService.enrollStudentInCourse(registrationService.findStudentById(3), registrationService.findCourseById(101)); // Should fail (capacity 2)
        registrationService.enrollStudentInCourse(registrationService.findStudentById(2), registrationService.findCourseById(102));
        registrationService.enrollStudentInCourse(registrationService.findStudentById(3), registrationService.findCourseById(103));

        // Display School Directory
        displaySchoolDirectory(registrationService);

        // Display Courses with Enrollment Details
        System.out.println("\nAvailable Courses:");
        for (Course course : registrationService.getCourses()) {
            course.displayDetails();
        }

        // Mark Attendance with Enrollment Check
        Student student1 = registrationService.findStudentById(1);
        Course course101 = registrationService.findCourseById(101);
        if (course101.getEnrolledStudents().contains(student1)) {
            attendanceService.markAttendance(1, 101, "Present");
        }
        Student student2 = registrationService.findStudentById(2);
        Course course102 = registrationService.findCourseById(102);
        if (course102.getEnrolledStudents().contains(student2)) {
            attendanceService.markAttendance(2, 102, "Absent");
        }
        Student student3 = registrationService.findStudentById(3);
        Course course103 = registrationService.findCourseById(103);
        if (course103.getEnrolledStudents().contains(student3)) {
            attendanceService.markAttendance(3, 103, "Late"); // Invalid status
        }
        attendanceService.markAttendance(999, 101, "Present"); // Invalid student ID

        // Display Attendance using overloaded methods
        attendanceService.displayAttendanceLog();
        attendanceService.displayAttendanceLog(registrationService.findStudentById(1));
        attendanceService.displayAttendanceLog(registrationService.findCourseById(102));

        // Save Data
        registrationService.saveAllRegistrations();
        attendanceService.saveAttendanceData();

        System.out.println("\nPart 10: Course Capacity Management and Project Conclusion Implemented.");
    }
}