package com.parsam.controller.product;

import com.parsam.comm.Action;
import com.parsam.comm.Forward;
import com.parsam.dto.ProductDTO;
import com.parsam.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ProductDetailAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long pid = Long.parseLong(request.getParameter("pid"));

        ProductService service = ProductService.getService();
        ProductDTO pdto = service.showDetail(pid);

        Forward forward = new Forward();
        forward.setForward(true);
        forward.setUrl("WEB-INF/index.jsp?page=chh_product/detail.jsp");

        return forward;
    }
}
