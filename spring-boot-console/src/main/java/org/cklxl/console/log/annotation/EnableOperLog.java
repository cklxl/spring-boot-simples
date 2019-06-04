package org.cklxl.console.log.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.cklxl.console.log.config.OperLogAutoConfig;
import org.springframework.context.annotation.Import;

/**
 * 是否启用操作日志记录
 * 
 * @author Kun.Chen
 * @date 2019-06-04 11:35:38
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
@Import(OperLogAutoConfig.class)
public @interface EnableOperLog {
}
