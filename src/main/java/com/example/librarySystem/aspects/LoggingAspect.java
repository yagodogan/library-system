package com.example.librarySystem.aspects;

import com.example.librarySystem.business.abstracts.ILogService;
import com.example.librarySystem.business.requests.CreateLogRequest;
import lombok.AllArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
@AllArgsConstructor
public class LoggingAspect {

    private ILogService logService;

    @Around("@annotation(com.example.librarySystem.core.utilities.annotation.Log)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long execTime = System.currentTimeMillis() - startTime;

        LocalDateTime now = LocalDateTime.now();
        String methodName = joinPoint.getSignature().getName();

        CreateLogRequest createLogRequest = new CreateLogRequest(now, execTime, methodName);
        logService.createLog(createLogRequest);

        return result;
    }

}
