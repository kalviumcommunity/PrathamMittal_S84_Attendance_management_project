package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void displaySchoolDirectory(List<Person> people) {
        System.out.println("\nSchool Directory:");
        for (Person person : people) {
            person.displayDetails();
        }
    }

    public static void main(String[] args) {
        System.out.println("--- School Management System ---");

        // FileStorageService and AttendanceService
        FileStorageService storageService = new FileStorageService();
        AttendanceService attendanceService = new AttendanceService(storageService);

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

        // Create schoolPeople list for polymorphism
        ArrayList<Person> schoolPeople = new ArrayList<>();
        schoolPeople.addAll(students);
        for (Teacher teacher : teachers) {
            schoolPeople.add(teacher);
        }
        for (Staff staff : staffMembers) {
            schoolPeople.add(staff);
        }

        // Display School Directory
        displaySchoolDirectory(schoolPeople);

        // Display Courses
        System.out.println("\nAvailable Courses:");
        for (Course course : courses) {
            course.displayDetails();
        }

        // Mark Attendance using overloaded methods
        attendanceService.markAttendance(students.get(0), courses.get(0), "Present");
        attendanceService.markAttendance(students.get(1), courses.get(1), "Absent");
        attendanceService.markAttendance(3, 103, "Late", students, courses); // Invalid status
        attendanceService.markAttendance(999, 101, "Present", students, courses); // Invalid student ID

        // Display Attendance using overloaded methods
        attendanceService.displayAttendanceLog();
        attendanceService.displayAttendanceLog(students.get(0));
        attendanceService.displayAttendanceLog(courses.get(1));

        // Save Attendance Data
        attendanceService.saveAttendanceData();

        // Prepare students list for saving (filtering from schoolPeople)
        ArrayList<Student> studentsToSave = new ArrayList<>();
        for (Person person : schoolPeople) {
            if (person instanceof Student) {
                studentsToSave.add((Student) person);
            }
        }

        // Save Data to Files
        storageService.saveData(studentsToSave, "students.txt");
        storageService.saveData(courses, "courses.txt");

        System.out.println("\nPart 8: Overloaded Commands for Attendance Marking and Querying Implemented.");
    }
}