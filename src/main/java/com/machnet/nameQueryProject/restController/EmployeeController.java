package com.machnet.nameQueryProject.restController;

import com.machnet.nameQueryProject.db.EmployeeRepo;
import com.machnet.nameQueryProject.model.Employee;
import com.machnet.nameQueryProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee-api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepo employeeRepo;

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/employees/salary")
    public List<Employee> getEmployeeSalary(@RequestParam("salary") int salary){
        return employeeRepo.getEmployeeBySalary(salary);
    }

    @GetMapping("employees/sort-by-name")
    public List<Employee> getEmployeeListSortedByName(){
        return employeeService.getEmployeeListSortedByName();
    }

    @GetMapping("employees/names")
    public List<String> getAllEmployeeName(){
        return employeeService.getEmployeeName();
    }




}
