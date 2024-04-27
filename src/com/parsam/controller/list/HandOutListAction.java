package com.parsam.controller.list;

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

public class HandOutListAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService service = ProductService.getService();
        List<ProductDTO> list = service.getHandoutList();
        request.setAttribute("list", list);
        List<Long> like_data=new ArrayList<>();

        // 세션 값 받아오기
        HttpSession session = request.getSession(false);

        if (session == null) {
            Forward forward = new Forward();
            forward.setForward(true);
            forward.setUrl("WEB-INF/index.jsp?page=main/handout.jsp");
            return forward;
        } else {
            // 세션 값 받아오기

            String id = (String) session.getAttribute("id");

            UserService service2 = UserService.getService();
            long uid = service2.getUid(id);

            LikeService service3 = LikeService.getService();
            for (ProductDTO dto : list) {
                long result = service3.getFav(id, dto.getP_id());
                like_data.add(result);
            }

            request.setAttribute("uid", uid);
            request.setAttribute("like_data", like_data);
        }

        Forward forward = new Forward();
        forward.setForward(true);
        forward.setUrl("WEB-INF/index.jsp?page=main/handout.jsp");
        return forward;
    }
}
