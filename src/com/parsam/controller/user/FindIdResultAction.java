package com.parsam.controller.user;

import com.parsam.comm.Action;
import com.parsam.comm.Forward;
import com.parsam.dto.UserDTO;
import com.parsam.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.System.out;

public class FindIdResultAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        UserService service = UserService.getService();
        String id = null;
        id = service.findId(name, email);

        Forward forward = new Forward();
        if(name!= null && email!=null) {
            if (id != null && id != "") {
                request.setAttribute("id", id);
                forward.setForward(true);
                forward.setUrl("WEB-INF/user/findidalert.jsp");
            } else {
                forward.setForward(true);
                forward.setUrl("WEB-INF/user/findidalert2.jsp");
            }
        }else {
             forward.setForward(true);
             forward.setUrl("WEB-INF/user/findidalert2.jsp");
        }
        return forward;
    }
}
