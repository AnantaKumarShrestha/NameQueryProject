package com.machnet.nameQueryProject.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.UUID;

@NamedQuery(name="above",query = "select e from Employee e where e.salary > :salary")
@NamedQuery(name="employee", query = "select e from Employee e")
@NamedQuery(name="employeeName", query = "select e.name from Employee e")
@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    private int salary;

}
