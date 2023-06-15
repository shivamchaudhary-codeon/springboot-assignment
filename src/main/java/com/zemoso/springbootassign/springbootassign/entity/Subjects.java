package com.zemoso.springbootassign.springbootassign.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Subjects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
