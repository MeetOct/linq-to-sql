package com.echo.lingtosql.model;

import java.io.Serializable;
import java.util.function.Function;

/**
 * @ClassName QueryFunction
 * @Description
 * @Author cheerego
 * @Date 2019/6/20 17:18
 */
public interface QueryFunction<T,R> extends Function<T, R>,Serializable {
}
