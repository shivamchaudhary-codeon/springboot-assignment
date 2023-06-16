package com.zemoso.springbootassign.springbootassign.controller;

import com.zemoso.springbootassign.springbootassign.dao.StudentRepository;
import com.zemoso.springbootassign.springbootassign.entity.Student;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class StudentControllerTest {

        @Mock
        private StudentRepository studentRepository;

        @InjectMocks
        private StudentController studentController;

        @BeforeEach
        void setUp() {
            MockitoAnnotations.openMocks(this);
        }

        @Test
        void testSaveStudent() {
            // Mocking the StudentRepository's save method
            Student student = new Student();
            student.setId(1L);
            student.setName("John Doe");
            when(studentRepository.save(any(Student.class))).thenReturn(student);

            // Invoking the controller method
            Student response = studentController.save(student);

            // Asserting the response
            assertEquals(true, response.equals(student));
            assertEquals(student.getAdd(), response.getAdd());

            // Verifying that the save method was called on the repository
            verify(studentRepository, times(1)).save(any(Student.class));
        }

        @Test
        void testFindAllStudents() {
            // Mocking the StudentRepository's findAll method
            List<Student> students = new ArrayList<>();
            students.add(new Student());
            students.add(new Student());
            when(studentRepository.findAll()).thenReturn(students);

            // Invoking the controller method
            List<Student> response = studentController.findAllStuent();

            // Asserting the response
            assertEquals(students, response);

            // Verifying that the findAll method was called on the repository
            verify(studentRepository, times(1)).findAll();
        }

        @Test
        void testFindStudentById() {
            // Mocking the StudentRepository's findById method
            Student student = new Student();
            when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

            // Invoking the controller method
            Student response = studentController.find(1L);

            // Asserting the response
            assertEquals(student, response);

            // Verifying that the findById method was called on the repository
            verify(studentRepository, times(1)).findById(1L);
        }

        @Test
        void testFindStudentById_StudentNotFound() {
            // Mocking the StudentRepository's findById method to return empty Optional
            when(studentRepository.findById(1L)).thenReturn(Optional.empty());

            // Invoking the controller method and expecting a RuntimeException
            try {
                studentController.find(1L);
            } catch (RuntimeException e) {
                assertEquals("Student is not present database", e.getMessage());
            }

            // Verifying that the findById method was called on the repository
            verify(studentRepository, times(1)).findById(1L);
        }

        @Test
        void testUpdateStudent() {
            // Mocking the StudentRepository's save method
            Student student = new Student();
            when(studentRepository.save(any(Student.class))).thenReturn(student);

            // Invoking the controller method
            Student response = studentController.update(student);

            // Asserting the response
            assertEquals(true, response.equals(student));
            assertEquals(student.getName(), response.getName());

            // Verifying that the save method was called on the repository
            verify(studentRepository, times(1)).save(any(Student.class));
        }

    @Test
    void testDeleteStudent() {
        // Mocking the StudentRepository's findById and delete methods
        Student student = new Student();
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        // Invoking the controller method
        String response = studentController.delete(1L);

        // Asserting the response
        assertEquals("Student deleted successfully ...!", response);

        // Verifying that the findById and delete methods were called on the repository
        verify(studentRepository, times(1)).findById(1L);
        verify(studentRepository, times(1)).delete(any(Student.class));
    }

    @Test
    void testDeleteStudent_StudentNotFound() {
        // Mocking the StudentRepository's findById method to return empty Optional
        when(studentRepository.findById(1L)).thenReturn(Optional.empty());

        // Invoking the controller method and expecting a RuntimeException
        try {
            studentController.delete(1L);
        } catch (RuntimeException e) {
            assertEquals("Student is not present database", e.getMessage());
        }

        // Verifying that the findById method was called on the repository
        verify(studentRepository, times(1)).findById(1L);
    }
}


