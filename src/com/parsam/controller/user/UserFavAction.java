package com.parsam.controller.user;

import com.parsam.comm.Action;
import com.parsam.comm.Forward;
import com.parsam.dto.ProductDTO;
import com.parsam.service.ProductService;
import com.parsam.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserFavAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long u_id = Long.valueOf(request.getParameter("u_id"));
        String id = request.getParameter("id");

        ProductService service = ProductService.getService();
        List<ProductDTO> list = service.getFavList(u_id);

        UserService userService = UserService.getService();

        request.setAttribute("list", list);
        request.setAttribute("id", id);

        Forward forward = new Forward();
        forward.setForward(true);
        forward.setUrl("WEB-INF/index.jsp?page=user/userFavList.jsp");

        return forward;
    }
}
