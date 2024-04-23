package com.parsam.controller.board;

import com.parsam.comm.Action;
import com.parsam.comm.Forward;
import com.parsam.dto.BoardDTO;
import com.parsam.service.board.BoardService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardUpdateAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int b_no = Integer.parseInt(request.getParameter("bno"));

        BoardService service = BoardService.getService();
        BoardDTO dto = service.showDetail(b_no);
        request.setAttribute("dto", dto);

        Forward forward = new Forward();
        forward.setForward(true);
        forward.setUrl("/WEB-INF/board/boardupdate.jsp");

        return forward;
    }
}
