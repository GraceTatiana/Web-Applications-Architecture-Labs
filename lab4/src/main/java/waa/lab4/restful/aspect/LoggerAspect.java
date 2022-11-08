package waa.lab4.restful.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import waa.lab4.restful.entity.dto.versioning.Logger;
import waa.lab4.restful.repo.LoggerRepo;

import java.util.Date;

@Aspect
@Component
public class LoggerAspect {

    @Autowired
    private LoggerRepo loggerRepo;

    // for every method in this waa.lab4.restful.service package and that have any argument
    @Before("execution(* waa.lab4.restful.service..*.*(..))")
    public void logging(JoinPoint joinPoint){
        var x = Logger.builder()
                .dateTime(new Date())
                .principle("Grace")
                .operation(joinPoint.getSignature().getName())
                .build();
        loggerRepo.save(x);
    }

}
