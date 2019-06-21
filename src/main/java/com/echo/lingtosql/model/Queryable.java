package com.echo.lingtosql.model;

import com.echo.lingtosql.model.annotation.Table;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;

/**
 * @ClassName Queryable
 * @Description
 * @Author cheerego
 * @Date 2019/6/20 16:13
 */
public class Queryable<T> {

    private QueryItem current;

    public static Queryable builder(){
        return new Queryable();
    }

    public Queryable<T> Where(QueryFunction<T,Object> function, EnumOperator operator, Object value) throws Exception {
        setCurrentQueryItem(function,EnumOperator.and,operator,value);
        return this;
    }

    public Queryable<T> Or(QueryFunction<T,Object> function, EnumOperator operator, Object value){
        setCurrentQueryItem(function,EnumOperator.or,operator,value);
        return this;
    }

    private void setCurrentQueryItem(QueryFunction<T,Object> function, EnumOperator queryOperator, EnumOperator operator, Object value) {
        QueryItem item=new QueryItem();
        item.setQueryOperator(queryOperator);
        item.setFunction(function);
        item.setOperator(operator);
        item.setQueryValue(value);
        if(current==null){
            current=item;
        }else {
            current.setNext(item);
        }
    }

    public String translateToSql(Class<?> entityClass) throws Exception {
        Table[] tables= entityClass.getAnnotationsByType(Table.class);
        if(tables==null||tables.length!=1){
            throw new Exception("no table annotation");
        }
        String tableName=tables[0].name();
        if(StringUtils.isEmpty(tableName)){
            tableName=entityClass.getName();
        }
        StringBuilder builder=new StringBuilder();
        while (current!=null){
            String fieldName=Reflections.fnToFieldName(current.getFunction());
            Field field=entityClass.getDeclaredField(fieldName);
            if(field!=null){
                com.echo.lingtosql.model.annotation.Field sqlField= field.getAnnotation(com.echo.lingtosql.model.annotation.Field.class);
                if(sqlField!=null&&!StringUtils.isEmpty(sqlField.name())){
                    fieldName=sqlField.name();
                }
            }
            builder.append(current.getQueryOperator().operator+" ("+fieldName+" "+current.getOperator().operator+" "+current.getQueryValue()+") ");
            current=current.getNext();
        }
        return "select * from "+tableName+" where 1=1 "+builder.toString();
    }

//    public List<T> apply(Class<?> entityClass,List<T> sources){
//        if(CollectionUtils.isEmpty(sources)){
//            return null;
//        }
//        while (current!=null){
//            sources.stream().filter(f->{
//                Object object= current.getFunction().apply(f);
//            })
//        }
//    }
}
