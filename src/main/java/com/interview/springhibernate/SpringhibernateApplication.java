package com.interview.springhibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//configuartion class can be diffrent
@Configuration
@SpringBootApplication
public class SpringhibernateApplication {

  static ApplicationContext context;

  public static void main(String[] args) {
	  context = SpringApplication.run(SpringhibernateApplication.class, args);
  }

  @Bean
  public ApplicationContext getContext()
  {
    return context;
  }

}
