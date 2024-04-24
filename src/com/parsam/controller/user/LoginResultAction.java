package com.parsam.controller.user;

import com.parsam.comm.Action;
import com.parsam.comm.Forward;
import com.parsam.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginResultAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");

        UserService service = UserService.getService();
        boolean login = service.doLogin(id, pw);

        Forward forward = new Forward();
        if (id != null && pw != null) {
            if (login == true) {  //로그인 성공
                HttpSession session = request.getSession();
                session.setAttribute("id", id);
                forward.setForward(false);
                forward.setUrl("index.do");
            } else { //비번 틀렸을 경우
                forward.setForward(false);
                forward.setUrl("login.do");
            }
        }else {
            forward.setForward(false);
            forward.setUrl("login.do");
        }
        return forward;
    }
}
