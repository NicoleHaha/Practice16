package com.example.employee.restfulapi.controller;

import com.example.employee.restfulapi.entity.Company;
import com.example.employee.restfulapi.entity.Employee;
import com.example.employee.restfulapi.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    //在此处完成Company API
    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping()
    public List<Company> getAllCompanys(){
        return companyRepository.findAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Company findById(@PathVariable("id") int id){
        return companyRepository.findById(id);
    }

    @RequestMapping(value = "/{id}/employees",method = RequestMethod.GET)
    public List<Employee> findEmployeesById(@PathVariable("id") int id){
        return companyRepository.findEmployeesById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addCompany(){
        Company company = new Company(6,"meituan",50);
        companyRepository.insertCompany(company.getId(),company.getCompanyName(),company.getEmployeesNumber());
        return "成功添加公司："+company.getCompanyName();
    }

    @RequestMapping(value = "/page/{page}/pageSize/{size}",method = RequestMethod.GET)
    public Page<Company> getCompanyByPage(@PathVariable("page") int page, @PathVariable("size") int size){
        return companyRepository.findAll(new PageRequest(page,size));
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String updateCompany(@PathVariable("id") int id){
        companyRepository.updateCompany(80,id);
        return "成功更新,公司id:"+id;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String deleteCompany(@PathVariable("id") int id){
     companyRepository.deleteCompany(id);
        return "成功删除id:"+id+"的公司";
    }
}
