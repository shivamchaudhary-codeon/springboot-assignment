package com.zemoso.springbootassign.springbootassign.mapper;

import com.zemoso.springbootassign.springbootassign.dto.StudentDto;
import com.zemoso.springbootassign.springbootassign.entity.Student;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentMapper {
    public StudentDto entityToDto(Student student){


        ModelMapper mapper = new ModelMapper();
        StudentDto map = mapper.map(student,StudentDto.class);
        return map;
    }

    public List<StudentDto> entityToDto(List<Student> student) {

        return	student.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

    }

    public Student dtoToEntity(StudentDto dto){

        ModelMapper mapper = new ModelMapper();
        Student map = mapper.map(dto,Student.class);
        return map;
    }

    public List<Student> dtoToEntity(List<StudentDto> dto)
    {

        return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }

}
