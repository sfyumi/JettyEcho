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
import java.math.BigDecimal;
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
        BigDecimal totalLoan = BigDecimal.valueOf(total).multiply(BigDecimal.valueOf(10000)).setScale(2, BigDecimal.ROUND_HALF_UP);

        log("req is:" + totalLoan);
        String response;


        // 36 0.5%
        BigDecimal profit = totalLoan.multiply(BigDecimal.valueOf(0.18)).setScale(2, BigDecimal.ROUND_HALF_UP);
        log("profit is:" + profit);
        BigDecimal payPerMonth = profit.add(totalLoan).divide(BigDecimal.valueOf(36), BigDecimal.ROUND_HALF_UP);

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
