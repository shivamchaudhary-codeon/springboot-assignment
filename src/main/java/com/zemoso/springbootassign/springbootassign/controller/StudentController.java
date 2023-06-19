package com.zemoso.springbootassign.springbootassign.controller;

import com.zemoso.springbootassign.springbootassign.dto.StudentDto;
import com.zemoso.springbootassign.springbootassign.entity.Student;
import com.zemoso.springbootassign.springbootassign.mapper.StudentMapper;
import com.zemoso.springbootassign.springbootassign.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentMapper studentMapper;

    //	localhost:8080/student/create
    //save student in database
    @PostMapping("/students")
    public StudentDto save(@RequestBody StudentDto student) {
        Student student1 = studentMapper.dtoToEntity(student);
        student1 = studentService.saveStudent(student1);

        return studentMapper.entityToDto(student1);
    }

    //	localhost:8080/student/findAll
    // find list of student
    @GetMapping("/students")
    public List<StudentDto> findAllStuent(){
        List<Student> findAll = studentService.findAllStudent();
        return studentMapper.entityToDto(findAll);
    }
    //localhost:8080/student/find/1
    //find student by id
    @GetMapping("/students/{ID}")
    public StudentDto find(@PathVariable(value = "ID")Long id) {

        Student orElseThrow = studentService.findStudent(id);

        return studentMapper.entityToDto(orElseThrow) ;

    }


    // update student
//	localhost:8080/student/update
    @PutMapping("/students")
    public StudentDto update(@RequestBody StudentDto student) {
        Student student1 = studentMapper.dtoToEntity(student);
        student1 = studentService.updateStudent(student1);

        return studentMapper.entityToDto(student1);
    }

    //delete student
    //localhost:8080/student/delete/1
    @DeleteMapping("/students/{ID}")
    public String delete(@PathVariable(value = "ID")Long id) {

        String student = studentService.deleteStudent(id);
        return "Student deleted successfully ...!";
    }
}
