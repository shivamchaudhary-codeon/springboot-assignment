package com.zemoso.springbootassign.springbootassign.controller;

import com.zemoso.springbootassign.springbootassign.dto.StudentDto;
import com.zemoso.springbootassign.springbootassign.entity.Student;
import com.zemoso.springbootassign.springbootassign.mapper.StudentMapper;
import com.zemoso.springbootassign.springbootassign.service.StudentService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import java.util.List;




//
public class StudentControllerTest {


    @Mock
    private StudentService studentService;

    @Mock
    private StudentMapper studentMapper;

    @InjectMocks
    private StudentController studentController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveStudent() {
        // Create a sample student DTO
        StudentDto studentDto = new StudentDto();
        studentDto.setId(1L);
        studentDto.setName("John Doe");

        // Create a sample student entity
        Student studentEntity = new Student();
        studentEntity.setId(1L);
        studentEntity.setName("John Doe");

        // Mock the behavior of the service and mapper methods
        when(studentMapper.dtoToEntity(studentDto)).thenReturn(studentEntity);
        when(studentService.saveStudent(studentEntity)).thenReturn(studentEntity);
        when(studentMapper.entityToDto(studentEntity)).thenReturn(studentDto);

        // Call the controller endpoint
        StudentDto response = studentController.save(studentDto);

        // Verify the response
//            assertEquals(HttpStatus.OK, response.getStatusCode());
//            assertEquals(studentDto, response.getBody());

        // Verify that the service and mapper methods were called
        verify(studentMapper, times(1)).dtoToEntity(studentDto);
        verify(studentService, times(1)).saveStudent(studentEntity);
        verify(studentMapper, times(1)).entityToDto(studentEntity);
    }

    @Test
    public void testFindAllStudents() {
        // Create a list of sample student entities
        List<Student> studentEntities = new ArrayList<>();
        studentEntities.add(new Student());
        studentEntities.add(new Student());

        // Create a list of sample student DTOs
        List<StudentDto> studentDtos = new ArrayList<>();
        studentDtos.add(new StudentDto());
        studentDtos.add(new StudentDto());

        // Mock the behavior of the service and mapper methods
        when(studentService.findAllStudent()).thenReturn(studentEntities);
        when(studentMapper.entityToDto(studentEntities)).thenReturn(studentDtos);

        // Call the controller endpoint
        List<StudentDto> response = studentController.findAllStuent();

        // Verify the response
        assertEquals(studentDtos, response);

        // Verify that the service and mapper methods were called
        verify(studentService, times(1)).findAllStudent();
        verify(studentMapper, times(1)).entityToDto(studentEntities);
    }

    @Test
    public void testFindStudentById() {
        // Create a sample student entity
        Student studentEntity = new Student();

        // Create a sample student DTO
        StudentDto studentDto = new StudentDto();

        // Mock the behavior of the service and mapper methods
        when(studentService.findStudent(1L)).thenReturn(studentEntity);
        when(studentMapper.entityToDto(studentEntity)).thenReturn(studentDto);

        // Call the controller endpoint
        StudentDto response = studentController.find(1L);

        // Verify the response
        assertEquals(studentDto, response);

        // Verify that the service and mapper methods were called
        verify(studentService, times(1)).findStudent(1L);
        verify(studentMapper, times(1)).entityToDto(studentEntity);
    }

    @Test
    public void testUpdateStudent() {
        // Create a sample student DTO
        StudentDto studentDto = new StudentDto();
        studentDto.setId(1L);
        studentDto.setName("John Doe");

        // Create a sample student entity
        Student studentEntity = new Student();
        studentEntity.setId(1L);
        studentEntity.setName("John Doe");

        // Mock the behavior of the service and mapper methods
        when(studentMapper.dtoToEntity(studentDto)).thenReturn(studentEntity);
        when(studentService.updateStudent(studentEntity)).thenReturn(studentEntity);
        when(studentMapper.entityToDto(studentEntity)).thenReturn(studentDto);

        // Call the controller endpoint
        StudentDto response = studentController.update(studentDto);

        // Verify the response
//            assertEquals(HttpStatus.OK, response.getStatusCode());
//            assertEquals(studentDto, response.getBody());

        // Verify that the service and mapper methods were called
        verify(studentMapper, times(1)).dtoToEntity(studentDto);
        verify(studentService, times(1)).updateStudent(studentEntity);
        verify(studentMapper, times(1)).entityToDto(studentEntity);
    }

    @Test
    public void testDeleteStudent() {
        // Create a sample student ID
        Long studentId = 1L;

        // Mock the behavior of the service
        when(studentService.deleteStudent(studentId)).thenReturn("Student deleted successfully ...!");

        // Call the controller endpoint
        String response = studentController.delete(studentId);

        // Verify the response
        assertEquals("Student deleted successfully ...!", response);

        // Verify that the service method was called
        verify(studentService, times(1)).deleteStudent(studentId);
    }

}

