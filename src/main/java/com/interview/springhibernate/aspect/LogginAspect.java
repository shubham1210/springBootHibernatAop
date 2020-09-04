package com.interview.springhibernate.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogginAspect {
  Logger logger = LoggerFactory.getLogger(LogginAspect.class);

  // this is advice
  @Before("execution(* com.interview.springhibernate.*.*.*())")
  public void startMethod(JoinPoint joinPoint)
  {
    logger.info("Entering ---"+joinPoint.getSignature());
    logger.info("args passed ---"+joinPoint.getArgs());
  }

  @AfterReturning(pointcut="execution(* com.interview.springhibernate.*.*.*())")
  public void getNameReturningAdvice(JoinPoint joinPoint){
    logger.info("Exit method"+joinPoint.getSignature());
  }
}
