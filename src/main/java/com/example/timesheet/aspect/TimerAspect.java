package com.example.timesheet.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class TimerAspect {

    @Pointcut("@annotation(com.example.timesheet.aspect.Timer)")
    public void timePointcut() {}


    @Around(value = "timePointcut()")
    public Object timeAround(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            return pjp.proceed();
        } finally {
            long end = System.currentTimeMillis();
            log.info("TimeSheetService#{}: {}", pjp.getSignature().getName(), end - start);
        }
    }
}
