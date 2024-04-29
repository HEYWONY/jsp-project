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

public class ProductlistResultAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // 선택지 받기
        String cate = request.getParameter("p_cate");
        String state = request.getParameter("p_state");
        String trade = request.getParameter("p_trade");

        // 선택지의 모음을 넘겨야 하는데 이걸 DTO? 혹은 다르게 처리?
        ProductDTO dto = new ProductDTO();
        dto.setP_cate(cate);
        dto.setP_state(state);
        dto.setP_trade(trade);

        ProductService service = ProductService.getService();
        List<ProductDTO> list = service.productListResult(dto);
        request.setAttribute("list", list);
        List<Long> like_data=new ArrayList<>();

        // 세션 값 받아오기
        HttpSession session = request.getSession(false);
        String id = (String) session.getAttribute("id");

        UserService service2 = UserService.getService();
        long uid = service2.getUid(id);
        System.out.println(uid);
        System.out.println(list.size());

        LikeService service3 = LikeService.getService();
        for (ProductDTO arr : list) {
            long result = service3.getFav(id, arr.getP_id());
            like_data.add(result);
        }

        request.setAttribute("uid", uid);
        request.setAttribute("like_data", like_data);

        Forward forward = new Forward();
        forward.setForward(true);
        forward.setUrl("WEB-INF/index.jsp?page=main/listResult.jsp");
        return forward;
    }
}
