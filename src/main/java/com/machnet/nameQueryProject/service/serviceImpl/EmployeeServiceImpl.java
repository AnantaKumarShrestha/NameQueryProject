package com.machnet.nameQueryProject.service.serviceImpl;

import com.machnet.nameQueryProject.db.EmployeeRepo;
import com.machnet.nameQueryProject.model.Employee;
import com.machnet.nameQueryProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Employee> getEmployeeAboveSalary() {
        return null;
    }

    @Override
    public List<Employee> getEmployeeListSortedByName() {
        return employeeRepo.getEmployeeSortedByName();
    }

    @Override
    public List<String> getEmployeeName() {
        return employeeRepo.getEmployeeName();
    }


}
