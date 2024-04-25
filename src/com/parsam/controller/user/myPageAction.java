package com.parsam.controller.user;

import com.parsam.comm.Action;
import com.parsam.comm.Forward;
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
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");

        UserService service = UserService.getService();
        UserDTO dto = service.getModifyList(id);

        String teacher_ck = "";
        if(!dto.isTeacher_ck()) {
            teacher_ck = "인증이 진행중입니다.";
        }else {
            teacher_ck = "교사 인증 완료";
        }

        request.setAttribute("dto", dto);
        request.setAttribute("teacher_ck", teacher_ck);

        Forward forward = new Forward();
        forward.setForward(true);
        forward.setUrl("WEB-INF/index.jsp?page=user/myPage.jsp");

        return forward;
    }
}
