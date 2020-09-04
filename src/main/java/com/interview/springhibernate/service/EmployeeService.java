package com.interview.springhibernate.service;

import com.interview.springhibernate.model.Employee;
import com.interview.springhibernate.repositiory.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {


  EmployeeRepository employeeRepository;

  @Autowired
  ConfigurableApplicationContext context;

  //it will not be called if you mark autowired.
  EmployeeService()
  {
    System.out.println("no arg constuctor called");
  }

  ////setter will be called but later after costructor.
  @Autowired
  public void setEmployeeRepository(EmployeeRepository employeeRepository)
  {
    System.out.println("in setEmployeeRepository");
    this.employeeRepository =employeeRepository;
  }

  //constructor will get precedence over setter.
  @Autowired
  EmployeeService(EmployeeRepository employeeRepository)
  {
    this.employeeRepository =employeeRepository;
  }


  public List<Employee> findEmpWithBlankEmailID(){

    return employeeRepository.findEmploeeWithNoEmailId();
  }



  public Employee findEmpWithEmailId(String email){

    return employeeRepository.findEmploeeWithEmailID(email);
  }


  public List<Employee> findAll()
  {
    System.out.println(context.containsBeanDefinition("EmployeeRepository"));
    Optional<List<Employee>> employees = Optional.ofNullable(employeeRepository.findAll());
    List<Employee> emp = new ArrayList<Employee>();
    return employees.orElse(emp);
  }

}
