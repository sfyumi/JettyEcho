package com.qunar.ychen.echo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ychen  Date: 12/8/15 Time: 4:55 PM
 */
@WebServlet("/echo")
public class HangServer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String sleep = req.getParameter("sleep");
        Thread.sleep(Long.parseLong(sleep));

        String echo = req.getParameter("name");
        String response;

        if (echo == null || echo.length() == 0) {
            response = "{\"status\":1,\"message\":\"error\",\"data\":\"name is null\"}";
            log("echo is blank, default response is:" + response);
        } else {
            response = "{\"status\":0,\"message\":\"success\",\"data\":\"hello " + echo + "\"}";
            log("echo is " + echo + ", response is :" + response);
        }
        response = response.concat(System.lineSeparator());
        resp.setContentType("application/json; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.write(response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String response = req.getReader().readLine();
        response = response.concat(System.lineSeparator());
        resp.setContentType("application/json; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.write(response);
    }
}
