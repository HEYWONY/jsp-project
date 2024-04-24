package com.parsam.controller.board;

import com.parsam.comm.Action;
import com.parsam.comm.Forward;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardWriteAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Forward forward = new Forward();
        forward.setForward(true);
        forward.setUrl("WEB-INF/index.jsp?page=board/boardwrite.jsp");

        return forward;
    }
}
