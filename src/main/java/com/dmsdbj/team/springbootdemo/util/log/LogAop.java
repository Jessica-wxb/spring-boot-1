package com.dmsdbj.team.springbootdemo.util.log;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Jessica
 * @version 1.0.0
 * @ClassName LogAop.java
 * @Description TODO
 * @createTime 2020年03月14日 05:53:00
 */
@Slf4j
@Component
@Aspect
public class LogAop {
    ThreadLocal<Long> time = new ThreadLocal<Long>();
    ThreadLocal<String> tag = new ThreadLocal<String>();

    @Pointcut("@annotation(com.dmsdbj.team.springbootdemo.util.log.Log)")
    public void log() {
        log.info("我是一个切入点");
    }

/**
     * 在所有标注@Log的地方切入
     *
     * @param joinPoint
     */

    @Before("log()")
    public void beforeExec(JoinPoint joinPoint) {
        time.set(System.currentTimeMillis());
    }

    @After("log()")
    public void afterExec(JoinPoint joinPoint) {
        tag.set(IdWorker.getIdStr());
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String classname = joinPoint.getTarget().getClass().getSimpleName();
        String methodname = joinPoint.getSignature().getName();
        Object[] os = joinPoint.getArgs();
        String remoteAddr = request.getRemoteAddr();
        log.info("一后置通知一");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < os.length; i++) {
            stringBuilder.append("参数").append(i + 1).append(":").append(os[i]);
        }

        Long l = System.currentTimeMillis() - time.get();
        log.info("运行的类classname:[{}]", classname);
        log.info("运行的方法methodname:[{}]", methodname);
        log.info("运行的远程地址是remoteAddr:[{}]", remoteAddr);
        log.info("运行的方法时间time:[{}]", l);
    }

    @Around("log()")
    public void aroundExec(ProceedingJoinPoint pjp) throws Throwable {
        pjp.proceed();
    }

    @AfterThrowing(value = "log()",throwing = "exception")
    public void afterThrowingExec(JoinPoint joinPoint) {
        log.info("运行的切面joinPoint:[{}]", joinPoint);
        log.info("运行的线程tag:[{}]", tag.get());
    }
}
