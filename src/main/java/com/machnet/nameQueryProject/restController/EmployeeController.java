package com.machnet.nameQueryProject.restController;

import com.machnet.nameQueryProject.dto.EmployeeDto;
import com.machnet.nameQueryProject.model.Employee;
import com.machnet.nameQueryProject.playLoad.ApiResponse;
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
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto){
         EmployeeDto savedEmployee=employeeService.addEmployee(employeeDto);
         return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        List<EmployeeDto> employeeList= employeeService.getAllEmployee();
        return new ResponseEntity<>(employeeList,HttpStatus.OK);
    }

    @GetMapping("/employees/salary")
    public ResponseEntity<List<EmployeeDto>> getEmployeeBySalary(@RequestParam("salary") int salary){
        List<EmployeeDto> employeeList= employeeService.getEmployeeAboveSalary(salary);
        return new ResponseEntity<>(employeeList,HttpStatus.OK);
    }

    @GetMapping("/employees/sort-by-name")
    public ResponseEntity<List<EmployeeDto>> getEmployeeListSortedByName(){
        List<EmployeeDto> employeeList =employeeService.getEmployeeListSortedByName();
        return new ResponseEntity<>(employeeList,HttpStatus.OK);
    }

    @GetMapping("/employees/names")
    public ResponseEntity<List<String>> getAllEmployeeName(){
         List<String> employeeListName=employeeService.getAllEmployeesName();
         return new ResponseEntity<>(employeeListName,HttpStatus.OK);
    }

    @GetMapping("/employees/{empId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("empId") UUID id){
        EmployeeDto employee =employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @DeleteMapping("/employees")
    public ApiResponse deleteALlEmployee(){
        employeeService.deleteAllEmployee();
        return new ApiResponse("All Employees Deleted Successfully","Success");
    }





}
