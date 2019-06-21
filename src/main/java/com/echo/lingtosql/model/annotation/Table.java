package com.echo.lingtosql.model.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @ClassName Table
 * @Description
 * @Author cheerego
 * @Date 2019/6/20 16:11
 */
@Target(TYPE)
@Retention(RUNTIME)
public @interface Table {

    String name() default "";
}
