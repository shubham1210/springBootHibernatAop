package com.interview.springhibernate.repositiory;

import com.interview.springhibernate.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository("EmployeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


  @Query("select e from Employee e where e.email='' ")
  List<Employee> findEmploeeWithNoEmailId();


  @Query(value = "select * from TBL_EMPLOYEES e where e.email=?1",nativeQuery = true)
  Employee findEmploeeWithEmailID(String email);

}
