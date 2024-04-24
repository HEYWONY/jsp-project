package com.parsam.controller;

import com.parsam.comm.Action;
import com.parsam.comm.Forward;
import com.parsam.dto.ProductDTO;
import com.parsam.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class IndexAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductService service = ProductService.getService();

        // 최신 물품입니다
        List<ProductDTO> list = service.productNewListService();
        request.setAttribute("list", list);

        // 인기 물품입니다.
        List<ProductDTO> list2 = service.productPopularListService();
        request.setAttribute("list2", list2);


        Forward forward = new Forward();
        forward.setForward(true);
        forward.setUrl("/WEB-INF/index.jsp");
        return forward;
    }
}
