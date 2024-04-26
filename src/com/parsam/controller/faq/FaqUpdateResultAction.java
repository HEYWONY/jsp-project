package com.parsam.controller.faq;

import com.parsam.comm.Action;
import com.parsam.comm.Forward;
import com.parsam.dto.FaqDTO;
import com.parsam.service.FaqService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FaqUpdateResultAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int f_no = Integer.parseInt(request.getParameter("f_no"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        FaqDTO dto = new FaqDTO();
        dto.setF_no(f_no);
        dto.setTitle(title);
        dto.setContent(content);

        FaqService service = FaqService.getService();
        service.updateData(dto);

        Forward forward = new Forward();
        forward.setForward(false);
        forward.setUrl("faq_detail.do?bno="+f_no);

        return forward;
    }
}
