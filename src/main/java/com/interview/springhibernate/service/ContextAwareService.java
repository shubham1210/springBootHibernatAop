package com.interview.springhibernate.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ContextAwareService implements ApplicationContextAware {


  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    System.out.println("setApplicationContext called");
    System.out.println("setApplicationContext:: Bean Definition Names=" + Arrays.toString(applicationContext.getBeanDefinitionNames()));

  }
}
