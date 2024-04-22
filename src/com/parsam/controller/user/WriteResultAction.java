package com.parsam.controller.user;

import com.parsam.comm.Action;
import com.parsam.comm.Forward;
import com.parsam.dto.UserDTO;
import com.parsam.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WriteResultAction implements Action {

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 회원가입 폼의 파라미터를 받는다
        String name = request.getParameter("name");         // 이름
        String nickname =request.getParameter("nickname");  // 닉네임
        String id = request.getParameter("id");             // 아이디
        String pw = request.getParameter("pw");           // 비밀번호
        String email = request.getParameter("email");       // 이메일
        String addr = request.getParameter("addr");         // 주소
        String phone = request.getParameter("phone");       // 연락처

        // dto에 담아서 회원가입 정보 넘긴다
        UserDTO dto = new UserDTO();
        dto.setName(name);
        dto.setNickname(nickname);
        dto.setId(id);
        dto.setPw(pw);
        dto.setEmail(email);
        dto.setAddr(addr);
        dto.setPhone(phone);

        // UserService에 dto에 회원가입 데이터 담아서 넘긴다
        UserService service = UserService.getService();
        int result = service.insertUserData(dto);
        Forward forward = new Forward();
        forward.setForward(true);

        if(result == 1) {
            System.out.println("회원가입 성공!");
            forward.setUrl("/WEB-INF/user/joinSuccess.jsp");
        }else {
            System.out.println("회원가입 실패");
            forward.setUrl("/WEB-INF/user/joinForm.jsp");
        }

        return forward;
    }
}
