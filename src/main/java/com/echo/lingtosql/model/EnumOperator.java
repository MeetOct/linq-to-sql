package com.echo.lingtosql.model;

/**
 * @ClassName EnumOperator
 * @Description
 * @Author cheerego
 * @Date 2019/6/20 16:22
 */
public enum EnumOperator {
    and("and"),
    or("or"),
    eq("="),
    gt(">"),
    lt("<"),
    like("like");
    String operator;
    EnumOperator(String operator) {
        this.operator = operator;
    }
    public String getOperator() {
        return operator;
    }
}
