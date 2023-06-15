package com.zemoso.springbootassign.springbootassign.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table
@Entity
@Data
public class Hobby {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
