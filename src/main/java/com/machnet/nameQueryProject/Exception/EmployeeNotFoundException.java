package com.machnet.nameQueryProject.Exception;

import java.util.UUID;

public class EmployeeNotFoundException extends RuntimeException{
     public EmployeeNotFoundException(UUID id){
        super(String.format("Employee Not Found, Employee ID:%s",id));
    }
}
