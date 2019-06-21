package com.echo.lingtosql.servlet;

import com.echo.lingtosql.model.Queryable;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName CustomHttpServlet
 * @Description
 * @Author cheerego
 * @Date 2019/6/21 10:34
 */
public class CustomHttpServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req,res);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer=resp.getWriter();
        writer.println("hello world!->"+req.getPathInfo());
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer=resp.getWriter();
        writer.println("hello world!->"+req.getPathInfo());
        writer.close();
    }
}
