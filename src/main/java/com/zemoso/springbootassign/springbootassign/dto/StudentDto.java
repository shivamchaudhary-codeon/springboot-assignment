package com.zemoso.springbootassign.springbootassign.dto;

import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class StudentDto {

    private Long id;
    private String name;
    private String className;

    private AddressDto add;
    private List<SubjectsDto> subjects;
    private Set<HobbyDto> hobbies = new HashSet<>();

}
