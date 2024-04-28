package com.parsam.controller.user;

import com.parsam.comm.Action;
import com.parsam.comm.Forward;
import com.parsam.dto.ProductDTO;
import com.parsam.service.LikeService;
import com.parsam.service.ProductService;
import com.parsam.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserFavAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        String id = (String) session.getAttribute("id");

        ProductService service = ProductService.getService();
        UserService service2 = UserService.getService();
        long u_id = service2.getUid(id);
        List<ProductDTO> list = service.getFavList(u_id);
        List<Long> like_data=new ArrayList<>();

        LikeService service3 = LikeService.getService();
        for (ProductDTO dto : list) {
            long result = service3.getFav(id, dto.getP_id());
            like_data.add(result);
        }

        System.out.println(list.toString());

        request.setAttribute("like_data", like_data);
        request.setAttribute("list", list);
        request.setAttribute("u_id", u_id);
        request.setAttribute("id", id);

        Forward forward = new Forward();
        forward.setForward(true);
        forward.setUrl("WEB-INF/index.jsp?page=user/userFavList.jsp");

        return forward;
    }
}
