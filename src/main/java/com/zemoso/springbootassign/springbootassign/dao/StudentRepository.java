package com.zemoso.springbootassign.springbootassign.dao;

import com.zemoso.springbootassign.springbootassign.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
