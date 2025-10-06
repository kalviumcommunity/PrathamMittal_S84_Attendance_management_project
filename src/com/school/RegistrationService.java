package com.school;

import java.util.ArrayList;
import java.util.List;

public class RegistrationService {
    private List<Student> students;
    private List<Teacher> teachers;
    private List<Staff> staffMembers;
    private List<Course> courses;
    private FileStorageService storageService;

    public RegistrationService(FileStorageService storageService) {
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.staffMembers = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.storageService = storageService;
    }

    public void registerStudent(String name, String gradeLevel) {
        students.add(new Student(name, gradeLevel));
    }

    public void registerTeacher(String name, String subjectTaught) {
        teachers.add(new Teacher(name, subjectTaught));
    }

    public void registerStaff(String name, String role) {
        staffMembers.add(new Staff(name, role));
    }

    public void createCourse(String courseName, int capacity) {
        courses.add(new Course(courseName, capacity));
    }

    public boolean enrollStudentInCourse(Student student, Course course) {
        if (course.addStudent(student)) {
            System.out.println("Student " + student.getName() + " enrolled in " + course.getCourseName());
            return true;
        } else {
            System.out.println("Enrollment failed: " + course.getCourseName() + " is at full capacity.");
            return false;
        }
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Staff> getStaffMembers() {
        return staffMembers;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Student findStudentById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Course findCourseById(int id) {
        return courses.stream()
                .filter(c -> c.getCourseId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Person> getAllPeople() {
        List<Person> allPeople = new ArrayList<>();
        allPeople.addAll(students);
        allPeople.addAll(teachers);
        allPeople.addAll(staffMembers);
        return allPeople;
    }

    public void saveAllRegistrations() {
        storageService.saveData(students, "students.txt");
        storageService.saveData(teachers, "teachers.txt");
        storageService.saveData(staffMembers, "staff.txt");
        storageService.saveData(courses, "courses.txt");
    }
}