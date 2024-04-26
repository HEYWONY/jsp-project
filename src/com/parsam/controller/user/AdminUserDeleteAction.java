package com.parsam.controller.user;

import com.parsam.comm.Action;
import com.parsam.comm.Forward;
import com.parsam.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminUserDeleteAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        UserService service = UserService.getService();
        int result = service.userDelete(id);


        System.out.println(result+" ..............admin user delete action ");

        Forward forward = new Forward();
        forward.setForward(false);
        forward.setUrl("admin.do");

        return forward;
    }
}
