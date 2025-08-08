package com.school;

public class Student {
    private static int nextStudentIdCounter = 1;

    private int studentId;
    private String name;

    public Student(String studentName) {
        this.studentId = nextStudentIdCounter++;
        this.name = studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public void displayDetails() {
        System.out.println("Student ID: " + this.studentId + ", Name: " + this.name);
    }
}
