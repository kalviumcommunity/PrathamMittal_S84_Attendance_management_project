# Attendance Management System

A simple **Java-based School Management System** demonstrating **Object-Oriented Programming (OOP)** concepts such as **Encapsulation, Inheritance, and Polymorphism**.  
The project evolves in parts, each introducing new concepts.

---

## Part 3: Constructor Initialization & Auto-ID Generation

In this part of the project, we:

- Removed `setDetails()` methods.
- Introduced constructors for both `Student` and `Course` classes.
- Implemented automatic ID generation using static counters.
- Verified output by creating multiple student and course instances.

---

## Part 4: Data Encapsulation & Attendance Recording Validation

In this part of the project, we:

- Implemented the `AttendanceRecord` class to link Students and Courses with attendance status.
- Added validation to ensure attendance can only be `"Present"` or `"Absent"`.  
  Any other value defaults to `"Invalid"` with a warning message.
- Demonstrated encapsulation by keeping fields private and using getters.

---

## Part 5: Establishing Students, Teaching & Non-Teaching Staff Hierarchy

In this part of the project, we:

- Created a base class `Person.java` with common attributes (`id`, `name`) and a universal auto-ID generator.
- Modified `Student.java` to inherit from `Person`, using `super()` to call the parent constructor and overriding `displayDetails()` to add student-specific info (e.g., grade level).
- Created `Teacher.java` extending `Person`, adding a `subjectTaught` attribute and its own `displayDetails()`.
- Created `Staff.java` extending `Person`, adding a `role` attribute and its own `displayDetails()`.
- Demonstrated creation and display of `Student`, `Teacher`, and `Staff` objects in `Main.java`.
- Updated `AttendanceRecord` creation to use the inherited `getId()` method.

---

## Folder Structure

```
src/
 └── com/
      └── school/
           ├── AttendanceRecord.java
           ├── Course.java
           ├── Main.java
           ├── Person.java
           ├── Staff.java
           ├── Student.java
           └── Teacher.java
```

---

## Sample Output

```
--- School Management System ---

Registered Students:
ID: 1, Name: Alice Wonderland
Role: Student, Grade Level: Grade 10
ID: 2, Name: Bob The Builder
Role: Student, Grade Level: Grade 11
ID: 3, Name: Charlie Chaplin
Role: Student, Grade Level: Grade 12

Teaching Staff:
ID: 4, Name: Dr. John Smith
Role: Teacher, Subject: Mathematics
ID: 5, Name: Prof. Emily Johnson
Role: Teacher, Subject: Computer Science

Non-Teaching Staff:
ID: 6, Name: Michael Brown
Role: Staff, Job Role: Librarian
ID: 7, Name: Sarah Davis
Role: Staff, Job Role: Administrator

Available Courses:
Course ID: C101, Name: Intro to Programming
Course ID: C102, Name: Linear Algebra
Course ID: C103, Name: Data Structures
Warning: Invalid attendance status entered. Setting status to 'Invalid'.

Attendance Log:
Attendance Record -> Student ID: 1, Course ID: C101, Status: Present
Attendance Record -> Student ID: 2, Course ID: C102, Status: Absent
Attendance Record -> Student ID: 3, Course ID: C103, Status: Invalid

Part 5: Inheritance Hierarchy Established.
```

---

