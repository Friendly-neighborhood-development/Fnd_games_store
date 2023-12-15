package com.fnd.games_store.games.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Component
@Aspect
@Slf4j
public class Benchmarking {


    @Around("@annotation(com.fnd.games_store.games.annotations.Benchmarked)")
    public Object performTImeMeasure(ProceedingJoinPoint joinPoint) throws Throwable {

        Instant startTime = Instant.now();

        Object proceed = joinPoint.proceed();

        Instant endTime = Instant.now();

        log.info(Duration.between(endTime,startTime).toString());

        return proceed;
    }

}
