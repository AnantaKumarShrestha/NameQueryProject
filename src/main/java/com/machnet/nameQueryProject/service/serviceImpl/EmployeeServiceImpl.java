package com.machnet.nameQueryProject.service.serviceImpl;

import com.machnet.nameQueryProject.Exception.EmployeeNotFoundException;
import com.machnet.nameQueryProject.db.EmployeeRepo;
import com.machnet.nameQueryProject.dto.EmployeeDto;
import com.machnet.nameQueryProject.model.Employee;
import com.machnet.nameQueryProject.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        Employee employee =employeeDtoIntoEmployee(employeeDto);
        return employeeIntoEmployeeDto(employeeRepo.save(employee));
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        return employeeRepo.getAllEmployee().stream().map(employee->employeeIntoEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDto> getEmployeeAboveSalary(int salary) {
        return employeeRepo.getEmployeeBySalary(salary).stream().map(employee->employeeIntoEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDto> getEmployeeListSortedByName() {
        return employeeRepo.getAllEmployee().stream().map(employee->employeeIntoEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public List<String> getAllEmployeesName() {
        return employeeRepo.getEmployeeName();
    }

    @Override
    public EmployeeDto getEmployeeById(UUID id) {
        Employee employee= Optional.ofNullable(employeeRepo.getEmployeeByID(id)).orElseThrow(()->new EmployeeNotFoundException(id));
        return employeeIntoEmployeeDto(employee);
    }

    @Override
    public void deleteAllEmployee() {
     employeeRepo.deleteAll();;
    }


    public Employee employeeDtoIntoEmployee(EmployeeDto employeeDto) {
        return modelMapper.map(employeeDto,Employee.class);
    }


    public EmployeeDto employeeIntoEmployeeDto(Employee employee) {
        return modelMapper.map(employee,EmployeeDto.class);
    }


}
