package com.school;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AttendanceService {
    private List<AttendanceRecord> attendanceLog;
    private FileStorageService storageService;
    private RegistrationService registrationService;

    public AttendanceService(FileStorageService storageService, RegistrationService registrationService) {
        this.attendanceLog = new ArrayList<>();
        this.storageService = storageService;
        this.registrationService = registrationService;
    }

    public void markAttendance(Student student, Course course, String status) {
        AttendanceRecord record = new AttendanceRecord(student, course, status);
        attendanceLog.add(record);
    }

    public void markAttendance(int studentId, int courseId, String status) {
        Student student = registrationService.findStudentById(studentId);
        Course course = registrationService.findCourseById(courseId);
        if (student != null && course != null) {
            markAttendance(student, course, status);
        } else {
            System.out.println("Error: Student ID " + studentId + " or Course ID " + courseId + " not found.");
        }
    }

    public void displayAttendanceLog() {
        System.out.println("\nFull Attendance Log:");
        attendanceLog.forEach(AttendanceRecord::displayRecord);
    }

    public void displayAttendanceLog(Student student) {
        System.out.println("\nAttendance Log for Student: " + student.getName() + " (ID: " + student.getId() + ")");
        attendanceLog.stream()
                .filter(record -> record.getStudent().equals(student))
                .forEach(AttendanceRecord::displayRecord);
    }

    public void displayAttendanceLog(Course course) {
        System.out.println("\nAttendance Log for Course: " + course.getCourseName() + " (ID: C" + course.getCourseId() + ")");
        attendanceLog.stream()
                .filter(record -> record.getCourse().equals(course))
                .forEach(AttendanceRecord::displayRecord);
    }

    public void saveAttendanceData() {
        storageService.saveData(attendanceLog, "attendance_log.txt");
    }
}