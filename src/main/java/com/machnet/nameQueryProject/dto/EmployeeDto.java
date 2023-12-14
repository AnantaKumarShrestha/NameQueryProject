package com.machnet.nameQueryProject.dto;


import com.machnet.nameQueryProject.model.Address;
import lombok.Data;

import java.util.UUID;

@Data
public class EmployeeDto {

    private UUID id;
    private String name;
    private Address address;
    private int salary;
}
