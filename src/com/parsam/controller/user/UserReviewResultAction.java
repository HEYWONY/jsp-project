package com.parsam.controller.user;

import com.parsam.comm.Action;
import com.parsam.comm.Forward;
import com.parsam.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserReviewResultAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 파라마터
        String id = request.getParameter("id");
        Long u_id = Long.valueOf(request.getParameter("u_id"));
        Long pid = Long.valueOf(request.getParameter("pid"));
        int rank = Integer.parseInt(request.getParameter("rank"));

        UserService service = UserService.getService();
        int result = service.getReview(rank, id, u_id, pid);

        if(result == 1) {
            System.out.println("리뷰 작성 완료!");
        }else {
            System.out.println("리뷰 작성 실패");
        }

        Forward forward = new Forward();
        forward.setForward(false);
        forward.setUrl("myPage.do?u_id="+u_id);


        return forward;
    }
}
