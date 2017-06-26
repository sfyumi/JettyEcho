/*
* Copyright (c) 2016 Jiulvxing.com. All Rights Reserved.
*/
package com.qunar.ychen.math;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ychen  Date: 12/3/16 Time: 8:40 PM
 */
@WebServlet("/add")
public class Add extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String a = req.getParameter("a");
        String b = req.getParameter("b");
        String response;

        if (a == null || b == null) {
            response = "{\"status\":1,\"message\":\"error\",\"data\":\"requires a and b\"}";
            log("parameter is blank, default response is:" + response);
        } else {
            Integer ia = Integer.parseInt(a);
            Integer ib = Integer.parseInt(b);
            response = "{\"status\":0,\"message\":\"success\",\"data\":\"a + b is " + (ia + ib) + "\"}";
            log("echo is " + (ia + ib) + ", response is :" + response);
        }
        response = response.concat(System.lineSeparator());
        resp.setContentType("application/json; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.write(response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
