package com.zemoso.springbootassign.springbootassign.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table
@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String landmark;
    private String pinCode;
}
