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
        
        // 선택지 받기
        String textbook = request.getParameter("교재");
        String adis = request.getParameter("교구");
        String handout = request.getParameter("수업자료");
        String etc = request.getParameter("기타");

        String no = request.getParameter("상관없음");
        String good = request.getParameter("미개봉");
        String soso = request.getParameter("거의 새것");
        String bad = request.getParameter("사용감 있음 ");

        String trade = request.getParameter("택배거래");
        String state = request.getParameter("직거래");
        String all = request.getParameter("직거래, 택배거래");

        // 선택지의 모음을 넘겨야 하는데 이걸 DTO? 혹은 다르게 처리?
        ProductDTO dto = new ProductDTO();
        dto.setP_state(state);
        dto.setP_trade(trade);

        // 넘겨야 하니까...
        request.setAttribute("list", dto);


        ProductService service = ProductService.getService();
        service.productListResult(dto);

        Forward forward = new Forward();
        forward.setForward(true);
        forward.setUrl("WEB-INF/index.jsp?page=main/listResult.jsp");
        return forward;
    }
}
