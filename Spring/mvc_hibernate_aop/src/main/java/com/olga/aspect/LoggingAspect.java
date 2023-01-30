
package com.olga.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    
    @Around("execution(* com.olga.dao.*.*(..))")
    public Object getAllDAOMethodAdvice(ProceedingJoinPoint proceedingJoinPoint) 
                                                     throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();
        System.out.println("Begin of " + methodName);
        Object result = proceedingJoinPoint.proceed();
        System.out.println("End of " + methodName);
        
        return result;
    }
}
