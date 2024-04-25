package com.parsam.controller.user;

import com.parsam.comm.Action;
import com.parsam.comm.Forward;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserReviewAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 파라미터
        Long pid = Long.valueOf(request.getParameter("pid"));
        Long u_id = Long.valueOf(request.getParameter("u_id"));
        String id = request.getParameter("id");

        request.setAttribute("pid", pid);
        request.setAttribute("u_id", u_id);
        request.setAttribute("id", id);

        Forward forward = new Forward();
        forward.setForward(true);
        forward.setUrl("WEB-INF/index.jsp?page=user/review.jsp");

        return forward;
    }
}
