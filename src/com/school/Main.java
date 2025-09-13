package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- School Management System ---");

        // Students
        Student[] students = new Student[3];
        students[0] = new Student("Alice Wonderland", "Grade 10");
        students[1] = new Student("Bob The Builder", "Grade 11");
        students[2] = new Student("Charlie Chaplin", "Grade 12");

        // Teachers
        Teacher[] teachers = new Teacher[2];
        teachers[0] = new Teacher("Dr. John Smith", "Mathematics");
        teachers[1] = new Teacher("Prof. Emily Johnson", "Computer Science");

        // Staff
        Staff[] staffMembers = new Staff[2];
        staffMembers[0] = new Staff("Michael Brown", "Librarian");
        staffMembers[1] = new Staff("Sarah Davis", "Administrator");

        // Courses
        Course[] courses = new Course[3];
        courses[0] = new Course("Intro to Programming");
        courses[1] = new Course("Linear Algebra");
        courses[2] = new Course("Data Structures");

        // Display Students
        System.out.println("\nRegistered Students:");
        for (Student student : students) {
            if (student != null) student.displayDetails();
        }

        // Display Teachers
        System.out.println("\nTeaching Staff:");
        for (Teacher teacher : teachers) {
            if (teacher != null) teacher.displayDetails();
        }

        // Display Staff
        System.out.println("\nNon-Teaching Staff:");
        for (Staff staff : staffMembers) {
            if (staff != null) staff.displayDetails();
        }

        // Display Courses
        System.out.println("\nAvailable Courses:");
        for (Course course : courses) {
            if (course != null) course.displayDetails();
        }

        // Attendance Records
        List<AttendanceRecord> attendanceLog = new ArrayList<>();
        attendanceLog.add(new AttendanceRecord(students[0].getId(), courses[0].getCourseId(), "Present"));
        attendanceLog.add(new AttendanceRecord(students[1].getId(), courses[1].getCourseId(), "Absent"));
        attendanceLog.add(new AttendanceRecord(students[2].getId(), courses[2].getCourseId(), "Late")); // invalid

        System.out.println("\nAttendance Log:");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }

        System.out.println("\nPart 5: Inheritance Hierarchy Established.");
    }
}
