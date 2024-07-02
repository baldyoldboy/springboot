package com.user.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringJoiner;

/**
 * @ClassName LogAspect
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@Component
@Aspect
public class LogAspect {
    @Before("execution(* com.user.aop.service..*(..))")
    public void sysLog(JoinPoint joinPoint) {
        StringJoiner log = new StringJoiner("|", "{", "}");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateTime = simpleDateFormat.format(new Date());
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //log.add(formatter.format(LocalDateTime.now()));
        log.add(dateTime);
        //当前执行的业务方法名称
        String methodName = joinPoint.getSignature().getName();
        log.add(methodName);
        //目标方法参数列表
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            log.add(arg == null ? "-" : arg.toString());
        }
        System.out.println("日志：" + log);

    }

}
