package com.saju.api.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LogAspect {
    // 모든 서비스 패키지의 메서드를 타겟으로 설정
    @Pointcut("execution(* com.saju.api..*.*(..))")
    public void allServices() {}

    // 예외 발생 시 실행
    @AfterThrowing(pointcut = "allServices()", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        // 1. 에러가 발생한 위치 (클래스명.메서드명)
        String signature = joinPoint.getSignature().toShortString();

        // 2. 전달된 파라미터 값 (MyBatis로 넘기려던 값들)
        Object[] args = joinPoint.getArgs();
        String params = (args != null && args.length > 0) ? Arrays.toString(args) : "No Parameters";

        log.error("================================================================");
        log.error("[Exception Detected]");
        log.error("Location: {}", signature);
        log.error("Arguments: {}", params);
        log.error("Exception Type: {}", ex.getClass().getName());
        log.error("Exception Message: {}", ex.getMessage());
        if (ex.getCause() != null) {
            log.error("Root Cause Type: {}", ex.getCause().getClass().getName());
            log.error("Root Cause Message: {}", ex.getCause().getMessage());
        }
        log.error("StackTrace", ex);
        log.error("================================================================");
    }
}
