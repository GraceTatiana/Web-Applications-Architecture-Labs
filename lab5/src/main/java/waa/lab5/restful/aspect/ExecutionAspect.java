package waa.lab5.restful.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import waa.lab5.restful.entity.dto.UserDto;

import java.util.List;

@Aspect
@Component
public class ExecutionAspect {

    @Around("@annotation(waa.lab5.restful.annotation.ExecutionTime)")
    public Object execution (ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        List<UserDto> result= (List<UserDto>)joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("time took is  " + (end - start) + "ms");
        return result;

    }


}
