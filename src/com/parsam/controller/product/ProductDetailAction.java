package com.parsam.controller.product;

import com.parsam.comm.Action;
import com.parsam.comm.Forward;
import com.parsam.dto.ProductDTO;
import com.parsam.service.FavService;
import com.parsam.service.ProductService;
import com.parsam.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ProductDetailAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long pid = Long.parseLong(request.getParameter("pid"));


        ProductService service = ProductService.getService();
        ProductDTO pdto = service.showDetail(pid);
        int fav_cnt = service.getFavCnt(pid);

        HttpSession session = request.getSession(false);
        String id = (String) session.getAttribute("id");
        UserService uservice = UserService.getService();
        long uid = uservice.getUid(id);
        int teacher_ck = uservice.getTcCheck(uid);

        FavService fservice = FavService.getService();
        int fav_yn = fservice.find_fav_yn(uid,pid);

        request.setAttribute("pdto",pdto);
        request.setAttribute("uid", uid);
        request.setAttribute("fav_cnt",fav_cnt);
        request.setAttribute("fav_yn",fav_yn);
        request.setAttribute("teacher_ck", teacher_ck);
        Forward forward = new Forward();
        forward.setForward(true);
        forward.setUrl("WEB-INF/index.jsp?page=chh_product/detail.jsp");

        return forward;
    }
}
