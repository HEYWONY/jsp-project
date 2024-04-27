package com.parsam.controller.user;

import com.parsam.comm.Action;
import com.parsam.comm.Forward;
import com.parsam.dto.ReviewDTO;
import com.parsam.dto.UserDTO;
import com.parsam.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class myPageAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 파라미터
        // 로그인한 사용자의 dto
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");

        UserService service = UserService.getService();
        Long u_id = service.getUid(id);
        UserDTO dto = service.getModifyList(u_id);

        // 판매자 u_id 예외처리
        Long uid = Long.valueOf(0);
        try {
            uid = Long.parseLong(request.getParameter("uid")); // 판매자의 u_id
        }catch (Exception e){}

        // 판매자의 회원 정보
        UserDTO pdto = service.getModifyList(uid);

        // 교사 인증 현황
        String teacher_ck = "";
        if(!dto.isTeacher_ck()) {
            teacher_ck = "인증이 진행중입니다.";
        }else {
            teacher_ck = "교사 인증 완료";
        }

        // 판매자 리뷰 평점 가져오기
        ReviewDTO reviewAvg = service.getReviewAvg(u_id);
        Double avg = reviewAvg.getAvg();

        request.setAttribute("uid", uid);
        request.setAttribute("dto", dto);
        request.setAttribute("pdto", pdto);
        request.setAttribute("teacher_ck", teacher_ck);
        request.setAttribute("avg", avg);




        Forward forward = new Forward();
        forward.setForward(true);
        forward.setUrl("WEB-INF/index.jsp?page=user/myPage.jsp");

        return forward;
    }
}
