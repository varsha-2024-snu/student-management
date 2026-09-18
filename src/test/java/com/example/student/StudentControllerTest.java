package com.example.student;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentControllerTest {

    @Test
    void testAddStudent() {

        StudentController controller = new StudentController();

        Student student = new Student(1, "Varsha", "CSE");

        String result = controller.addStudent(student);

        assertEquals("Student added successfully", result);

        assertEquals(1, controller.getStudents().size());

        assertEquals("Varsha", controller.getStudents().get(0).getName());
    }
}