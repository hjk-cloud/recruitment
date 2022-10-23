package edu.lnu.recruitment.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Package: edu.lnu.recruitment.common.aspect
 * @ClassName: logAspect
 * @Author: huangjk
 * @CreateTime: 2022/10/23 20:02
 * @Description:
 */
@Aspect
@Component
public class logAspect {
    ThreadLocal<Long> startTime = new ThreadLocal<>();
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(public * edu.lnu.recruitment.modules.*.service.impl..*(..))")
    public void aopLog() {
    }

    @Before("aopLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        startTime.set(System.currentTimeMillis());

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info("URL:" + request.getRequestURL().toString());
        logger.info("HTTP方法：" + request.getMethod());
        logger.info("IP地址：" + request.getRemoteAddr());
        logger.info("类的方法：" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("参数：" + request.getQueryString());
    }

    @AfterReturning(pointcut = "aopLog()", returning = "retObject")
    public void doAfterReturning(Object retObject) throws Throwable {
        logger.info("返回值" + retObject.toString());
        logger.info("耗时：" + (System.currentTimeMillis() - startTime.get()) + "ms");
    }

    @AfterThrowing(pointcut = "aopLog()", throwing = "exception")
    public void addAfterThrowingLogger(JoinPoint joinPoint, Exception exception) {
        logger.error("执行  " + "  异常", exception);
    }
}
