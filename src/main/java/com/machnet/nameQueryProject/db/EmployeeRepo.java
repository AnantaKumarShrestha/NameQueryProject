package com.machnet.nameQueryProject.db;

import com.machnet.nameQueryProject.model.Employee;
import com.machnet.nameQueryProject.restController.EmployeeController;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, UUID> {

    @Query(name="employee")
    public List<Employee> getAllEmployee();

    @Query(name = "above")
    List<Employee> getEmployeeBySalary(@Param("salary") int salary);

    @Query("SELECT e FROM Employee e ORDER BY e.name")
    public List<Employee> getEmployeeSortedByName();

     @Query(name="employeeName")
    List<String> getEmployeeName();

     @Query(name = "getEmployeeById")
    Employee getEmployeeByID(@Param("id") UUID id);

}
