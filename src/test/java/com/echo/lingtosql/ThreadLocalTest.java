package com.echo.lingtosql;

import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @ClassName ThreadLocalTest
 * @Description
 * @Author cheerego
 * @Date 2019/7/12 15:10
 */
public class ThreadLocalTest {

    public static final ThreadLocal<String> REQUEST_TRACER_THREAD_LOCAL= new InheritableThreadLocal<>();

    @Test
    public void testThreadLocal(){
        REQUEST_TRACER_THREAD_LOCAL.set("future");
        CompletableFuture future = CompletableFuture.runAsync(() -> {
            String request=REQUEST_TRACER_THREAD_LOCAL.get();
            if(!StringUtils.isEmpty(request)){
                System.out.println(request);
            }
        });
        try {
            CompletableFuture.allOf(future).get();
        } catch (InterruptedException e) {
            String errorMsg=e.getCause()!=null?e.getCause().getMessage():e.getMessage();
        } catch (ExecutionException e) {
            String errorMsg=e.getCause()!=null?e.getCause().getMessage():e.getMessage();
        }
        String request=REQUEST_TRACER_THREAD_LOCAL.get();
        if(!StringUtils.isEmpty(request)){
            System.out.println(request);
        }

    }
}
