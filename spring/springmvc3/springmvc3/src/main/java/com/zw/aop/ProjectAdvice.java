package com.zw.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class ProjectAdvice {
    @Pointcut("execution(* com.zw.services.*Service.*(..))")
    private void servicePt() {
    }

    @Around("ProjectAdvice.servicePt()")
    public Object runSpeed(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Signature signature = proceedingJoinPoint.getSignature();
        String name = signature.getName();
        String className = signature.getDeclaringTypeName();
        Object obj = proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println(className + "." + name + ",time: " + (endTime - startTime));
        return obj;
    }
}
