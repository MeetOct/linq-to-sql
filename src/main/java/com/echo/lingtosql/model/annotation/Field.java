package com.echo.lingtosql.model.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @ClassName Field
 * @Description
 * @Author cheerego
 * @Date 2019/6/20 16:11
 */
@Target(FIELD)
@Retention(RUNTIME)
public @interface Field {

    /**
     * 数据库字段名称
     * @return
     */
    String name() default "";

    /**
     * 是否主键
     * @return
     */
    boolean primaryKey() default false;
}
