package com.parsam.controller.board;

import com.parsam.comm.Action;
import com.parsam.comm.Forward;
import com.parsam.dto.BoardDTO;
import com.parsam.service.BoardService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardUpdateResultAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int b_no = Integer.parseInt(request.getParameter("b_no"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        BoardDTO dto = new BoardDTO();
        dto.setB_no(b_no);
        dto.setTitle(title);
        dto.setContent(content);

        BoardService service = BoardService.getService();
        service.updateData(dto);

        Forward forward = new Forward();
        forward.setForward(false);
        forward.setUrl("board_detail.do?bno="+b_no);

        return forward;
    }
}
