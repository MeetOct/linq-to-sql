package com.echo.lingtosql;

import com.echo.lingtosql.model.annotation.Field;
import com.echo.lingtosql.model.annotation.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName ProductModel
 * @Description
 * @Author cheerego
 * @Date 2019/6/20 16:18
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class ProductModel {

    @Field(name = "id",primaryKey = true)
    private Integer id;

    @Field(name = "product_name")
    private String productName;
}
