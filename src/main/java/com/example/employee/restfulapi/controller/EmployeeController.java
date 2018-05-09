package com.example.employee.restfulapi.controller;

import com.example.employee.restfulapi.entity.Employee;
import com.example.employee.restfulapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
   @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable("id") int id){
        return employeeRepository.findById(id);
    }
    @RequestMapping(value = "/page/{page}/pageSize/{size}",method = RequestMethod.GET)
    public Page<Employee> getEmployeePage(@PathVariable("page") int page,@PathVariable("size") int size){
        return employeeRepository.findAll(new PageRequest(page,size));
    }

    @RequestMapping(value = "/male",method = RequestMethod.GET)
    public List<Employee> getMaleEmployee(){
        return employeeRepository.filter();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addEmployee(){
        Employee employee = new Employee(16,"fafa",15,"male",4000,1);
        employeeRepository.insertEmployee(employee.getId(),employee.getName(),employee.getAge(),employee.getGender(),employee.getCompanyId(),employee.getSalary());
        return "success";
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String updateEmployee(@PathVariable("id") int id){
        employeeRepository.updateEmployee(5000,id);
        return "成功更新id："+id+"的雇员信息";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") int id){
        employeeRepository.deleteaEmployee(id);
        return "成功删除id："+id+"的雇员信息";
    }

}
