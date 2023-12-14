package com.machnet.nameQueryProject.restController;

import com.machnet.nameQueryProject.model.Employee;
import com.machnet.nameQueryProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employee-api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
         Employee savedEmployee=employeeService.addEmployee(employee);
         return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> employeeList= employeeService.getAllEmployee();
        return new ResponseEntity<>(employeeList,HttpStatus.OK);
    }

    @GetMapping("/employees/salary")
    public ResponseEntity<List<Employee>> getEmployeeBySalary(@RequestParam("salary") int salary){
        List<Employee> employeeList= employeeService.getEmployeeAboveSalary(salary);
        return new ResponseEntity<>(employeeList,HttpStatus.OK);
    }

    @GetMapping("employees/sort-by-name")
    public ResponseEntity<List<Employee>> getEmployeeListSortedByName(){
        List<Employee> employeeList =employeeService.getEmployeeListSortedByName();
        return new ResponseEntity<>(employeeList,HttpStatus.OK);
    }

    @GetMapping("employees/names")
    public ResponseEntity<List<String>> getAllEmployeeName(){
         List<String> employeeListName=employeeService.getAllEmployeesName();
         return new ResponseEntity<>(employeeListName,HttpStatus.OK);
    }

    @GetMapping("employees/{empId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("empId") UUID id){
        Employee employee =employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }




}
