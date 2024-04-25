package com.parsam.controller.user;

import com.parsam.comm.Action;
import com.parsam.comm.Forward;
import com.parsam.dto.ProductDTO;
import com.parsam.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserSaleListAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 파라미터
//        String id = request.getParameter("id");
        long u_id = Long.parseLong(request.getParameter("u_id"));   // 회원번호

        // 사용자 상품 목록 가져오기
        UserService service = UserService.getService();
        List<ProductDTO> list= service.getUserSaleList(u_id);

        request.setAttribute("u_id", u_id);
        request.setAttribute("list", list);

        Forward forward = new Forward();
        forward.setForward(true);
        forward.setUrl("WEB-INF/index.jsp?page=user/userSaleList.jsp");

        return forward;
    }
}
