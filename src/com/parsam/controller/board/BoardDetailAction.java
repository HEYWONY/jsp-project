package com.parsam.controller.board;

import com.parsam.comm.Action;
import com.parsam.comm.Forward;
import com.parsam.dto.BoardDTO;
import com.parsam.service.BoardService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardDetailAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bno = Integer.parseInt(request.getParameter("bno"));

        BoardService service = BoardService.getService();
        BoardDTO dto = service.showDetail(bno);
        request.setAttribute("dto", dto);

        Forward forward = new Forward();
        forward.setForward(true);
        forward.setUrl("/WEB-INF/board/boardDetail.jsp");
        return forward;
    }
}
