package com.echo.lingtosql;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName LambdaTest
 * @Description
 * @Author cheerego
 * @Date 2019/6/28 16:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LambdaTest {

    List<Integer> list=null;

    @Before
    public void generateLambdaList(){
        list=Arrays.asList(0,1,2,4,5,6);
    }

    /**
     * remark:println 输出顺序不同 代表函数执行的先后顺序不同，同时begin break end的输出顺序揭示了Stream内部函数的开始执行点
     */
    @Test
    public void intermediateAndTerminalOperations(){
        System.out.println("begin");
        Stream stream=list.stream()
                .filter(f->{
                    System.out.println("filter1");
                    return true;
                })
                .map(m->{
                    System.out.println("map1");
                    return m+1;
                })
                .filter(m->{
                    System.out.println("filter2");
                    return true;
                })
                .sorted(Comparator.comparing(s->{
                    System.out.println("comparing1");
                    return s;
                }))
                .skip(3);
        stream=stream.filter(f->{
            System.out.println("filter3");
            return true;
        });
        System.out.println("break");
        stream.collect(Collectors.toList());
        System.out.println("end");
    }

    @Test
    public void operationOrderTest(){
        Stream stream= list.stream().filter(f->{
            System.out.println("filter2");
            return true;
        }).filter(f->{
            System.out.println("filter2");
            return true;
        });
        System.out.println("break");
        stream.collect(Collectors.toList());
    }

    @Test
    public void beginSizeTest(){
        list.stream().filter(f->f>1).sorted(Comparator.comparing(s->s)).findFirst();
    }
}
