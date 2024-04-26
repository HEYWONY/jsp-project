package com.parsam.controller.user;

import com.parsam.comm.Action;
import com.parsam.comm.Forward;
import com.parsam.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class idCheckAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        UserService service = UserService.getService();
        boolean check = service.getIdCheck(id);


        request.setAttribute("id", id);
        request.setAttribute("check", check);

        Forward forward = new Forward();
        forward.setForward(true);
        forward.setUrl("WEB-INF/user/idCheckForm.jsp");

        return forward;
    }
}
