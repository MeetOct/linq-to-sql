package com.echo.lingtosql;

import com.echo.lingtosql.model.EnumOperator;
import com.echo.lingtosql.model.Queryable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LingToSqlApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void sqlQuery() throws Exception {
        Queryable<ProductModel> query=new Queryable<>();
        query.where(ProductModel::getId, EnumOperator.eq,1).or(ProductModel::getProductName,EnumOperator.like,"test");
        System.out.println(query.translateToSql(ProductModel.class));
    }
}
