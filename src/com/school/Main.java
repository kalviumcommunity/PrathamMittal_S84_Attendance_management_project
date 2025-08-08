package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- School Management System ---");

        Student[] students = new Student[3];
        students[0] = new Student("Alice Wonderland");
        students[1] = new Student("Bob The Builder");
        students[2] = new Student("Charlie Chaplin");

        Course[] courses = new Course[3];
        courses[0] = new Course("Intro to Programming");
        courses[1] = new Course("Linear Algebra");
        courses[2] = new Course("Data Structures");

        System.out.println("\nRegistered Students:");
        for (Student student : students) {
            if (student != null) student.displayDetails();
        }

        System.out.println("\nAvailable Courses:");
        for (Course course : courses) {
            if (course != null) course.displayDetails();
        }

        // Part 4: Attendance Recording
        List<AttendanceRecord> attendanceLog = new ArrayList<>();
        attendanceLog.add(new AttendanceRecord(students[0].getStudentId(), courses[0].getCourseId(), "Present"));
        attendanceLog.add(new AttendanceRecord(students[1].getStudentId(), courses[1].getCourseId(), "Absent"));
        attendanceLog.add(new AttendanceRecord(students[2].getStudentId(), courses[2].getCourseId(), "Late")); // invalid

        System.out.println("\nAttendance Log:");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }

        System.out.println("\nPart 4: Encapsulation & Attendance Recording Complete.");
    }
}
