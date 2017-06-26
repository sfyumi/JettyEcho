/*
 * Copyright (c) 2017 Jiulvxing.com. All Rights Reserved.
 */
package com.qunar.ychen.math;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

/**
 * ychen Date: 6/26/17 Time: 5:25 PM
 */
@WebServlet("/calc")
public class LoanCalc extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String a = req.getParameter("total");
        if (Objects.equals(a, null)) {
            a = "20";
        }
        Integer total = Integer.parseInt(a);
        log("req is:" + total);
        String response;

        // 36 0.5%
        int profit = total * 36 * 50;
        log("profit is:" + profit);
        double payPerMonth = (total*10000 + profit) * 1.0 / 36;

        response = "{\"status\":0,\"message\":\"success\",\"data\":\"" + payPerMonth + "\"}";
        log("response is:" + response);
        response = response.concat(System.lineSeparator());
        resp.setContentType("application/json; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.write(response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
