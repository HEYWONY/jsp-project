package com.parsam.controller.user;

import com.parsam.comm.Action;
import com.parsam.comm.Forward;
import com.parsam.dto.UserDTO;
import com.parsam.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserModifyResultAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 회원정보 수정 파라미터
//        long u_id = Long.parseLong((request.getParameter("u_id")));
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String nickname = request.getParameter("nickname");
        String addr1 = request.getParameter("addr1");
        String addr2 = request.getParameter("addr2");
        String addr3 = request.getParameter("addr3");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String photo = request.getParameter("photo");

        if(addr1 == null) {
            addr1 = "";
        }
        if(addr2 == null) {
            addr1 = "";
        }
        if(addr3 == null) {
            addr1 = "";
        }
        UserDTO dto = new UserDTO();
//        dto.setU_id(u_id);
        dto.setId(id);
        dto.setName(name);
        dto.setNickname(nickname);
        dto.setAddr(addr1 +"<br>" + addr2 + "<br>" + addr3);
        dto.setPhone(phone);
        dto.setEmail(email);
//        dto.setPhoto(photo);

        UserService service = UserService.getService();
        int result = service.updateUserData(dto);

        Forward forward = new Forward();
        forward.setForward(false);


        if(result == 1) {
            System.out.println("회원정보 수정 성공!");
            forward.setUrl("myPage.do?id="+dto.getId());
        }else {
            System.out.println("회원정보 수정 실패..");
            forward.setUrl("userModify.do?id="+dto.getId());
        }

        return forward;
    }
}
