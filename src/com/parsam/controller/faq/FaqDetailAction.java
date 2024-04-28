package com.parsam.controller.faq;

import com.parsam.comm.Action;
import com.parsam.comm.Forward;
import com.parsam.dto.FaqDTO;
import com.parsam.service.FaqService;
import com.parsam.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class FaqDetailAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bno = Integer.parseInt(request.getParameter("bno"));

        HttpSession session = request.getSession(false);
        String id = (String) session.getAttribute("id");
        UserService uservice = UserService.getService();
        long uid = uservice.getUid(id);

        FaqService service = FaqService.getService();
        FaqDTO dto = service.showDetail(bno);
        request.setAttribute("dto", dto);

        request.setAttribute("uid",uid);
        Forward forward = new Forward();
        forward.setForward(true);
        forward.setUrl("WEB-INF/index.jsp?page=faq/faqDetail.jsp");
        return forward;
    }
}
