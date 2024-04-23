package com.parsam.controller;

import com.parsam.comm.Action;
import com.parsam.comm.Forward;
import com.parsam.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductDeleteResultAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long pid = Long.parseLong(request.getParameter("pid"));
        String pimg = request.getParameter("pimg");

        String realpath = request.getServletContext().getRealPath("productUpload");
        ProductService service = ProductService.getService();

        if (pimg==null)
            pimg="";

        service.deleteData(pid, realpath+"/"+pimg);

        Forward forward = new Forward();
        forward.setForward(true);
        forward.setUrl("WEB-INF/main/index.jsp?page=../chh_product/delete_alert.jsp");
        return forward;
    }
}
