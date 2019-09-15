package com.echo.lingtosql.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName QueryItem
 * @Description 队列 改成树结构的可行性？
 * @Author cheerego
 * @Date 2019/6/20 16:12
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QueryItem<T> {

    private QueryItem<T> next;
    private QueryItem<T> inner;
    private EnumOperator queryOperator;
    private QueryFunction<T, Object> function;
    private EnumOperator operator;
    private Object queryValue;

    public String getQueryValueString(){
        if(queryValue instanceof String){
            return "'"+queryValue.toString()+"'";
        }
        return queryValue.toString();
    }
}
