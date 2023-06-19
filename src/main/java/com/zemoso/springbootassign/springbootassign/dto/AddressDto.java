package com.zemoso.springbootassign.springbootassign.dto;

import lombok.Data;

@Data
public class AddressDto {
    private Long id;
    private String city;
    private String landmark;
    private String pinCode;
}
