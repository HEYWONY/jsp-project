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

public class UserModifyAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 파라미터
        // 마이페이지에서 u_id 파라미터 받는다
        Long u_id = Long.parseLong(request.getParameter("u_id"));

        UserService service = UserService.getService();
        UserDTO dto = service.getModifyList(u_id);

        String address = dto.getAddr();
        String addr[] = address.split("<br>");
        String addr1 = addr[0];
        String addr2 = addr[1];
        String addr3 = addr[2];
//        String addr4 = addr[3];

//        request.setAttribute("u_id", u_id);
        request.setAttribute("id", dto.getId());
        request.setAttribute("name", dto.getName());
        request.setAttribute("nickname", dto.getNickname());
        request.setAttribute("addr1",addr1);
        request.setAttribute("addr2",addr2);
        request.setAttribute("addr3",addr3);
//        request.setAttribute("addr4",addr4);
        request.setAttribute("phone",dto.getPhone());
        request.setAttribute("email", dto.getEmail());
        request.setAttribute("photo", dto.getPhoto());

        // 프로필 수정 폼으로 이동한다
        Forward forward = new Forward();
        forward.setForward(true);
        forward.setUrl("WEB-INF/index.jsp?page=user/userModify.jsp");
        return forward;
    }
}
