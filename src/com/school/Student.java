package com.school;

public class Student {
    private static int nextStudentIdCounter = 1;

    int studentId;
    String name;

    public Student(String studentName) {
        this.studentId = nextStudentIdCounter++;
        this.name = studentName;
    }

    public void displayDetails() {
        System.out.println("Student ID: " + this.studentId + ", Name: " + this.name);
    }
}
