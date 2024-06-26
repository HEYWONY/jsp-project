package com.parsam.controller.product;

import com.parsam.comm.Action;
import com.parsam.comm.Forward;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductUpdateAlertAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long pid = (Long) request.getAttribute("pid");

        request.setAttribute("pid", pid);
        Forward forward = new Forward();
        forward.setForward(true);
        forward.setUrl("WEB-INF/index.jsp?page=chh_product/update_alert.jsp");
        return forward;
    }
}
