package com.echo.lingtosql.servlet;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName ServletConfiguration
 * @Description
 * @Author cheerego
 * @Date 2019/6/21 10:49
 */
@SpringBootConfiguration
public class ServletConfiguration {

    @Bean
    public ServletRegistrationBean createServlet(){
        ServletRegistrationBean servletRegistrationBean=new ServletRegistrationBean(new CustomHttpServlet());
        return servletRegistrationBean;
    }
}
