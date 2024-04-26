package com.parsam.controller.faq;

import com.parsam.comm.Action;
import com.parsam.comm.Forward;
import com.parsam.dto.FaqDTO;
import com.parsam.service.FaqService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FaqWriteResultAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String writer = request.getParameter("writer");

        FaqService service = FaqService.getService();
        FaqDTO dto = new FaqDTO();
        dto.setTitle(title);
        dto.setContent(content);
        dto.setWriter(writer);

        service.insertData(dto);

        Forward forward = new Forward();
        forward.setForward(false);
        forward.setUrl("faqlist.do");
        return forward;
    }
}
