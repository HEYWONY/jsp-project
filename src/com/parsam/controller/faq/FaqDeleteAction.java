package com.parsam.controller.faq;

import com.parsam.comm.Action;
import com.parsam.comm.Forward;
import com.parsam.service.FaqService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FaqDeleteAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bno = Integer.parseInt(request.getParameter("bno"));

        FaqService service = FaqService.getService();
        service.deleteData(bno);

        Forward forward = new Forward();
        forward.setForward(false);
        forward.setUrl("faqlist.do");

        return forward;
    }
}
