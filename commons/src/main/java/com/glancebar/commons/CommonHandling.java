package com.glancebar.commons;

import java.lang.annotation.*;

/**
 * 通用处理注解, 提供方法调用前后的计时, 日志, 异常默认操作等
 *
 * @author YISHEN CAI
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(value = { ElementType.METHOD, ElementType.TYPE })
public @interface CommonHandling {

    /**
     * 额外消息
     */
    String message() default "";

    String initMsg() default "start running....";

    String finishMsg() default "finish running...";

    /**
     * 异常消息模板
     */
    String errMsg() default "";

    /**
     * 异常是否向上传播
     */
    boolean errPropagating() default false;

    /**
     * 日志消息
     */
    String logMessage() default "";

    /**
     * 是否记录下调用时间
     */
    boolean countLastTime() default false;
}
