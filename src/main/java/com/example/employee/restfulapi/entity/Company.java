package com.example.employee.restfulapi.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Company")
public class Company {
    @Id
    @GeneratedValue
    private int id;
    private String companyName;
    private Integer employeesNumber;

    @OneToMany(cascade = CascadeType.ALL)
 //   @JoinColumn(name = "company_id")
    private List<Employee> employees;

    public void addEmployee(Employee employee){
        if (employee!=null){
            employees.add(employee);
        }
    }
    public List<Employee> getEmployees(){
        return this.employees;
    }
    public Company() {
    }

    public Company(int id,String companyName, Integer employeesNumber) {
        this.companyName = companyName;
        this.employeesNumber = employeesNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getEmployeesNumber() {
        return employeesNumber;
    }

    public void setEmployeesNumber(Integer employeesNumber) {
        this.employeesNumber = employeesNumber;
    }
}
