package az.edu.turing.az.springboot05jpa.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* az.edu.turing.az.springboot05jpa.controller.*.*(..))")
    public void logBeforeAllMethods(JoinPoint joinPoint) {
        System.out.println("Entering method: " + joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* az.edu.turing.az.springboot05jpa.controller.*.*(..))")
    public void logAfterAllMethods(JoinPoint joinPoint) {
        System.out.println("Exiting method: " + joinPoint.getSignature().getName());
    }
}
