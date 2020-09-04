package com.interview.springhibernate.controller;

import com.interview.springhibernate.aspect.LogginAspect;
import com.interview.springhibernate.model.Employee;
import com.interview.springhibernate.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@RestController
@RequestMapping("emp")
public class EmployeeController implements InitializingBean, DisposableBean {
  Logger logger = LoggerFactory.getLogger(EmployeeController.class);

  @Autowired
  EmployeeService service;

  @GetMapping(value = "/all")
  public ResponseEntity<List<Employee>> getEmp()
  {
    return new ResponseEntity<List<Employee>>(service.findAll(), HttpStatus.OK);
  }

  @GetMapping(value = "/noEmail")
  public ResponseEntity<List<Employee>> getEmpWithNoEmail()
  {
    return new ResponseEntity<List<Employee>>(service.findEmpWithBlankEmailID(), HttpStatus.OK);
  }

  @GetMapping(value = "/get/email")
  public ResponseEntity<Employee> getEmpWithNoEmail(@RequestParam String e)
  {
    return new ResponseEntity<Employee>(service.findEmpWithEmailId(e), HttpStatus.OK);
  }

  // this will called first. befor implements method
  @PostConstruct
  public void init()
  {
    logger.info("Controller constructed");

  }
  //this will call first before destory/
  @PreDestroy
  public void destroy2()
  {
    logger.info("Controller destroyed");

  }



  @Override
  public void afterPropertiesSet() throws Exception {
    logger.info("Controller has set with properties");
  }

  @Override
  public void destroy() throws Exception {
    logger.info("Controller has destroyed.");

  }
}
