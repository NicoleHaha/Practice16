package com.example.employee.restfulapi.repository;

import com.example.employee.restfulapi.entity.Company;
import com.example.employee.restfulapi.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CompanyRepository extends JpaRepository<Company, Long> {
    List<Company> findAll();
    Company findById(int id);
    @Query(value = "select * from employee where companyId = ?1",nativeQuery = true)
    List<Employee> findEmployeesById(int id);
    @Override
    Page<Company> findAll(Pageable pageable);
    @Modifying
    @Query(value = "insert into Company values(?1,?2,?3)",nativeQuery = true)
    int insertCompany(int id,String name,int employeeNumber);
    @Modifying
    @Query(value = "update Company set employeesNumber = ?1 where id = ?2",nativeQuery = true)
    int updateCompany(int employeesNumber,int id);
    @Modifying
    @Query(value = "delete from Company where id = ?1",nativeQuery = true)
    int deleteCompany(int id);
}
