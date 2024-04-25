package com.parsam.controller.faq;

import com.parsam.comm.Action;
import com.parsam.comm.Forward;
import com.parsam.dto.FaqDTO;
import com.parsam.service.FaqService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FaqUpdateAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int b_no = Integer.parseInt(request.getParameter("bno"));

        FaqService service = FaqService.getService();
        FaqDTO dto = service.showDetail(b_no);
        request.setAttribute("dto", dto);

        Forward forward = new Forward();
        forward.setForward(true);
        forward.setUrl("WEB-INF/index.jsp?page=faq/faqupdate.jsp");

        return forward;
    }
}
