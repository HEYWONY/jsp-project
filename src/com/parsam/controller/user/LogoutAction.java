package com.parsam.controller.user;

import com.parsam.comm.Action;
import com.parsam.comm.Forward;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 로그인 세션 제거하기
        request.getSession().removeAttribute("id");

        // 로그아웃 후 메인 페이지로 이동
        Forward forward = new Forward();
        forward.setForward(true);
        forward.setUrl("index.do");

        return forward;
    }
}
