package com.machnet.nameQueryProject.service;

import com.machnet.nameQueryProject.model.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {

    Employee addEmployee(Employee employee);

    List<Employee> getAllEmployee();

    List<Employee> getEmployeeAboveSalary(int salary);

    List<Employee> getEmployeeListSortedByName();

    List<String> getAllEmployeesName();

    Employee getEmployeeById(UUID id);

}
