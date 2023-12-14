package com.machnet.nameQueryProject.service;

import com.machnet.nameQueryProject.dto.EmployeeDto;
import com.machnet.nameQueryProject.model.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {

    EmployeeDto addEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> getAllEmployee();

    List<EmployeeDto> getEmployeeAboveSalary(int salary);

    List<EmployeeDto> getEmployeeListSortedByName();

    List<String> getAllEmployeesName();

    EmployeeDto getEmployeeById(UUID id);

    void deleteAllEmployee();

}
