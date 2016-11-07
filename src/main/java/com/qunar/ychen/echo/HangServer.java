package com.qunar.ychen.echo;

import com.qunar.ychen.utils.SleepUtil;

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
@WebServlet("/hang")
public class HangServer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String sleep = req.getParameter("sleep");
        sleep = SleepUtil.sleep(sleep);


        String response = "{\"status\":0,\"message\":\"success\",\"data\":\"sleep" + sleep + "millis" + "\"}";
        log("response is :" + response);

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
