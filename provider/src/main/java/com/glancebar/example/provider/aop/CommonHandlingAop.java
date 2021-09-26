package com.glancebar.example.provider.aop;

import com.glancebar.commons.CommonHandling;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 通用AOP处理器
 *
 * @author YISHEN CAI
 */
@Aspect
@Component
public class CommonHandlingAop {

    @Around("@annotation(com.glancebar.commons.CommonHandling)")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        CommonHandling commonHandling = method.getAnnotation(CommonHandling.class);
        Class<?> targetClass = joinPoint.getTarget().getClass();
        Logger logger = LoggerFactory.getLogger(targetClass);
        Object[] args = joinPoint.getArgs();

        try {
            long start = 0L;
            if (commonHandling.countLastTime()) {
                start = System.currentTimeMillis();
            }

            // invoke target
            logger.info(commonHandling.initMsg());
            Object proceed = joinPoint.proceed(args);
            logger.info(commonHandling.finishMsg());

            if (commonHandling.countLastTime()) {
                // log last time....
                logger.info("invoke method last: {} milliseconds", System.currentTimeMillis() - start);
            }
            return proceed;
        } catch (Exception e) {
            // TODO: 2021/9/25 do something else.
            if (logger.isDebugEnabled()) {
                logger.error(targetClass.getName(), method.getName(), commonHandling.errMsg(), e.getMessage());
                logger.error("params: {}", Arrays.stream(args).map(Object::toString).collect(Collectors.joining(",")));
            } else {
                logger.error(targetClass.getName(), method.getName(), commonHandling.errMsg(), e.getMessage());
            }
            if (commonHandling.errPropagating()) {
                throw e;
            } else {
                // TODO: 2021/9/25 return default obj.
                return null;
            }
        }
    }
}
