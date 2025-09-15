package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- School Management System ---");

        // Students
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Alice Wonderland", "Grade 10"));
        students.add(new Student("Bob The Builder", "Grade 11"));
        students.add(new Student("Charlie Chaplin", "Grade 12"));

        // Teachers
        Teacher[] teachers = new Teacher[2];
        teachers[0] = new Teacher("Dr. John Smith", "Mathematics");
        teachers[1] = new Teacher("Prof. Emily Johnson", "Computer Science");

        // Staff
        Staff[] staffMembers = new Staff[2];
        staffMembers[0] = new Staff("Michael Brown", "Librarian");
        staffMembers[1] = new Staff("Sarah Davis", "Administrator");

        // Courses
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course("Intro to Programming"));
        courses.add(new Course("Linear Algebra"));
        courses.add(new Course("Data Structures"));

        // Display Students
        System.out.println("\nRegistered Students:");
        for (Student student : students) {
            student.displayDetails();
        }

        // Display Teachers
        System.out.println("\nTeaching Staff:");
        for (Teacher teacher : teachers) {
            teacher.displayDetails();
        }

        // Display Staff
        System.out.println("\nNon-Teaching Staff:");
        for (Staff staff : staffMembers) {
            staff.displayDetails();
        }

        // Display Courses
        System.out.println("\nAvailable Courses:");
        for (Course course : courses) {
            course.displayDetails();
        }

        // Attendance Records
        ArrayList<AttendanceRecord> attendanceLog = new ArrayList<>();
        attendanceLog.add(new AttendanceRecord(students.get(0).getId(), courses.get(0).getCourseId(), "Present"));
        attendanceLog.add(new AttendanceRecord(students.get(1).getId(), courses.get(1).getCourseId(), "Absent"));
        attendanceLog.add(new AttendanceRecord(students.get(2).getId(), courses.get(2).getCourseId(), "Late")); // invalid

        System.out.println("\nAttendance Log:");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }

        // Save Data to Files
        FileStorageService storageService = new FileStorageService();
        storageService.saveData(students, "students.txt");
        storageService.saveData(courses, "courses.txt");
        storageService.saveData(attendanceLog, "attendance_log.txt");

        System.out.println("\nPart 6: Interface-Driven Persistence Implemented.");
    }
}
