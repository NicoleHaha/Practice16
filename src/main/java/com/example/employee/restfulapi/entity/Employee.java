package com.example.employee.restfulapi.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private Integer age;
    private String gender;
    private Integer salary;
    private int companyId;
//    @ManyToOne
//    @JoinColumn(name = "companyId")
//    private Company company;
    public Employee() {
    }
//    public void setCompany(Company company){
//        this.company = company;
//    }
//    public Company getCompany(){
//        return this.company;
//    }
    public Employee(int id,String name, Integer age, String gender, Integer salary, int companyId) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
        this.companyId = companyId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }


    public String getGender() {
        return gender;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
