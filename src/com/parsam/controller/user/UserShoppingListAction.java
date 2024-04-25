package com.parsam.controller.user;

import com.parsam.comm.Action;
import com.parsam.comm.Forward;
import com.parsam.dto.ProductDTO;
import com.parsam.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class UserShoppingListAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 파라미터
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");
        Long u_id = Long.valueOf(request.getParameter("u_id"));

        // 사용자 구매목록 가져오는 서비스
        UserService service = UserService.getService();
        List<ProductDTO> list = service.getUserShoppingList(u_id);

        // list로 묶는다
        request.setAttribute("list", list);
        request.setAttribute("u_id", u_id);
        request.setAttribute("id", id);

        Forward forward = new Forward();
        forward.setForward(true);
        forward.setUrl("WEB-INF/index.jsp?page=user/userShoppingList.jsp");

        return forward;
    }
}
