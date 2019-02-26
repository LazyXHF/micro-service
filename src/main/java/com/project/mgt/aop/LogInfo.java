package com.project.mgt.aop;

import java.lang.annotation.*;

/**
 * 日志信息
 * @author sunyuan
 *
 */
@Target({ ElementType.METHOD }) // 注解放置的目标位置，METHOD是可注解在方法级别上
@Retention(RetentionPolicy.RUNTIME) // 注解在哪个阶段执行
@Documented // 生成文档
public @interface LogInfo {
	String methodName() default "  ";
}
