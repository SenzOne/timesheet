package com.example.timesheetRest.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Before(value = "execution(* com.example.timesheet.service.TimeSheetService.getById(Long))")
    public void beforeTimeSheetServiceGetById(JoinPoint jp) {
        Object[] args = jp.getArgs();
        String argTypes = Arrays.stream(args)
                .map(Object::getClass)
                .map(Class::getSimpleName)
                .collect(Collectors.joining(", "));
        String argValues = Arrays.stream(args)
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        log.info("{}({} = {})", jp.getSignature().getName(), argTypes, argValues);
    }
}
