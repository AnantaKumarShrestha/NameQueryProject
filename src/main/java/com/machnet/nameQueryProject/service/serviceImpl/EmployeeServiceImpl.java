package com.machnet.nameQueryProject.service.serviceImpl;

import com.machnet.nameQueryProject.Exception.EmployeeNotFoundException;
import com.machnet.nameQueryProject.db.EmployeeRepo;
import com.machnet.nameQueryProject.model.Employee;
import com.machnet.nameQueryProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepo.getAllEmployee();
    }

    @Override
    public List<Employee> getEmployeeAboveSalary(int salary) {
        return employeeRepo.getEmployeeBySalary(salary);
    }

    @Override
    public List<Employee> getEmployeeListSortedByName() {
        return employeeRepo.getEmployeeSortedByName();
    }

    @Override
    public List<String> getAllEmployeesName() {
        return employeeRepo.getEmployeeName();
    }

    @Override
    public Employee getEmployeeById(UUID id) {
        return Optional.ofNullable(employeeRepo.getEmployeeByID(id)).orElseThrow(()->new EmployeeNotFoundException(id));
    }


}
