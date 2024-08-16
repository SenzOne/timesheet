package com.example.timesheet.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RecoverAspect {
    private static final Logger log = LoggerFactory.getLogger(RecoverAspect.class);

    @Around("@annotation(com.example.timesheet.aspect.Recover) && args(id, ..)")
    public Object recover(ProceedingJoinPoint joinPoint, Long id) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Class<?> returnType = methodSignature.getReturnType();
        try {
            return joinPoint.proceed();
        } catch (RuntimeException e) {
            log.info("Recovering {}#{} after Exception[{}, \"{}\"]",
                    joinPoint.getTarget().getClass().getSimpleName(),
                    joinPoint.getSignature().getName(),
                    e.getClass().getSimpleName(),
                    e.getMessage());

            return getDefault(returnType);
        }
    }

    private Object getDefault(Class<?> returnType) {
        if (returnType.equals(void.class)) {
            return null;
        } else if (returnType.isPrimitive()) {
            if (returnType.equals(boolean.class)) {
                return false;
            } else if (returnType.equals(byte.class)) {
                return 0;
            } else if (returnType.equals(short.class)) {
                return 0;
            } else if (returnType.equals(char.class)) {
                return 0;
            } else if (returnType.equals(int.class)) {
                return 0;
            } else if (returnType.equals(float.class)) {
                return 0.0f;
            } else if (returnType.equals(long.class)) {
                return 0;
            } else if (returnType.equals(double.class)) {
                return 0.0;
            }
        }
        return null;
    }
}

