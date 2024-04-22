package com.parsam.controller.board;

import com.parsam.comm.Action;
import com.parsam.comm.Forward;
import com.parsam.dto.BoardDTO;
import com.parsam.service.BoardService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BoardListAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BoardService service = BoardService.getService();
        List<BoardDTO> list = service.getList();
        request.setAttribute("list", list);

        Forward forward = new Forward();
        forward.setForward(true);
        forward.setUrl("/WEB-INF/board/boardlist.jsp");

        return forward;
    }
}
