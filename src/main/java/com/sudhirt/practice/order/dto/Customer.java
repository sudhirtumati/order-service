package com.sudhirt.practice.order.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Customer {

    private String id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private boolean active;
}
