package com.example.employee.restfulapi.repository;

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
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAll();
    Employee findById(int id);

    @Override
    Page<Employee> findAll(Pageable pageable);

    @Query(value = "select * from Employee where gender = 'male'",nativeQuery = true)
    List<Employee> filter();
    @Modifying
    @Query(value = "INSERT INTO Employee (id,name,age,gender,companyId,salary) VALUES ( ?1,?2,?3,?4,?5,?6 )",nativeQuery = true)
    int insertEmployee(int id,String name,int age,String gender,int companyId,int salary);
    @Modifying
    @Query(value = "update Employee set salary = ?1 where id = ?2",nativeQuery = true)
    int updateEmployee(int salary,int id);
    @Modifying
    @Query(value = "delete from Employee where id = ?1",nativeQuery = true)
    int deleteaEmployee(int id);

}
