package com.zemoso.springbootassign.springbootassign.service;

import com.zemoso.springbootassign.springbootassign.dao.StudentRepository;
import com.zemoso.springbootassign.springbootassign.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public Student saveStudent(Student student) {
        Student save = studentRepository.save(student);
        return save;
    }

    //	localhost:8080/student/findAll
    // find list of student

    public List<Student> findAllStudent(){
        List<Student> findAll = studentRepository.findAll();
        return findAll;
    }

    public Student findStudent(Long id) {
        ;

        return  studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student is not present database"));


    }



    public Student updateStudent(Student student) {
        Student save = studentRepository.save(student);
        return save;
    }


    @DeleteMapping("/delete/{ID}")
    public String deleteStudent(Long id) {

        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student is not present database"));
        studentRepository.delete(student);
        return "Student deleted successfully ...!";
    }
}
