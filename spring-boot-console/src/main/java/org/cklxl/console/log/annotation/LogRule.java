package org.cklxl.console.log.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.cklxl.console.base.api.BaseService;
import org.cklxl.console.log.parser.DefaultContentParse;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface LogRule {
    /**
     * 操作的中文说明 可以直接调用ModifyName
     * 
     * @return
     */
    String name() default "";

    /**
     * 获取编辑信息的解析类，目前为使用id获取，复杂的解析需要自己实现，默认不填写 则使用默认解析类
     * 
     * @return
     */
    Class<?> parseclass() default DefaultContentParse.class;

    /**
     * 查询数据库所调用的class文件
     * 
     * @return
     */
    Class<?> serviceclass() default BaseService.class;

    /**
     * 前台字段名称
     */
    String[] feildName() default { "id" };

    /**
     * 具体业务操作名称
     */
    String bizName() default "";
}
