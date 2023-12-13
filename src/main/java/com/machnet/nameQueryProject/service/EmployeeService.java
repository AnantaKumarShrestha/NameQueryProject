package com.machnet.nameQueryProject.service;

import com.machnet.nameQueryProject.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(Employee employee);

    List<Employee> getAllEmployee();

    List<Employee> getEmployeeAboveSalary();

    List<Employee> getEmployeeListSortedByName();

    List<String> getEmployeeName();

}
