package com.parsam.controller;

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

public class IndexAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductService service = ProductService.getService();
        List<Long> like_data=new ArrayList<>();

        // 최신 물품입니다
        List<ProductDTO> list = service.productNewListService();
        request.setAttribute("list", list);

        // 인기 물품입니다.
        List<ProductDTO> list2 = service.productPopularListService();
        request.setAttribute("list2", list2);

        HttpSession session = request.getSession(false);

        if (session == null) {
            Forward forward = new Forward();
            forward.setForward(true);
            forward.setUrl("/WEB-INF/index.jsp");
            return forward;
        } else {
            // 세션 값 받아오기

            String id = (String) session.getAttribute("id");

            UserService service2 = UserService.getService();
            long uid = service2.getUid(id);

            // 선생 인증
            int tc = service2.getTcCheck(uid);

            LikeService service3 = LikeService.getService();
            for (ProductDTO dto : list ) {
                long result = service3.getFav(id, dto.getP_id());
                like_data.add(result);
            }

            request.setAttribute("uid", uid);
            request.setAttribute("like_data", like_data);
            request.setAttribute("tc", tc);


            Forward forward = new Forward();
            forward.setForward(true);
            forward.setUrl("/WEB-INF/index.jsp");
            return forward;
        }
    }
}
