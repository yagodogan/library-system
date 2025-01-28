package com.example.librarySystem.aspect;

import com.example.librarySystem.business.abstracts.ILogService;
import com.example.librarySystem.dto.request.CreateLogRequest;
import lombok.AllArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@AllArgsConstructor
public class LoggingAspect {

    private final ILogService logService;

    @Pointcut("@annotation(com.example.librarySystem.core.annotation.Log)")
    public void logPointcut() {}


    @Around("logPointcut()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long execTime = System.currentTimeMillis() - startTime;

        String methodName = joinPoint.getSignature().getName();

        CreateLogRequest createLogRequest = new CreateLogRequest();

        createLogRequest.setExecTime(execTime);

        createLogRequest.setMethodName(methodName);

        logService.createLog(createLogRequest);

        return result;
    }
}
