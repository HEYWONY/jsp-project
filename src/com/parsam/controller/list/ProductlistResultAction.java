package com.parsam.controller.list;

import com.parsam.comm.Action;
import com.parsam.comm.Forward;
import com.parsam.dto.ProductDTO;
import com.parsam.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductlistResultAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 선택지의 값을 받는다.
        String p_cate = request.getParameter("p_cate");
        String p_state = request.getParameter("p_state");
        String p_trade = request.getParameter("p_trade");
        System.out.println("p_cate :" + p_cate);

        // 선택지의 모음을 넘겨야 하는데 이걸 DTO? 혹은 다르게 처리?
        ProductDTO dto = new ProductDTO();
        dto.setP_cate(p_cate);
        dto.setP_state(p_state);
        dto.setP_trade(p_trade);

        // 넘겨야 하니까...
        request.setAttribute("list", dto);


        ProductService service = ProductService.getService();
        service.productListResult(dto);

        Forward forward = new Forward();
        forward.setForward(true);
        forward.setUrl("WEB-INF/main/index.jsp?page=listResult.jsp");
        return forward;
    }
}
