package com.parsam.controller.board;

import com.parsam.comm.Action;
import com.parsam.comm.Forward;
import com.parsam.dto.BoardDTO;
import com.parsam.service.BoardService;
import com.parsam.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class BoardListAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String curr = request.getParameter("curr");
        String search_txt  = request.getParameter("search_txt");

        HttpSession session = request.getSession(false);
        String id = (String) session.getAttribute("id");
        UserService uservice = UserService.getService();
        long uid = uservice.getUid(id);

        BoardService service = BoardService.getService();

        if(search_txt==null)
            search_txt= "";

        int currpage = 1;

        if(curr!=null){
            currpage = Integer.parseInt(curr);
        }
        int pagesize = 8;
        int blocksize = 3;
        int startrow = (currpage-1)*pagesize;


        int total_data = service.getCount(search_txt);
        int total_page = (int) (Math.ceil(total_data/(float)pagesize));
        int startpage = (currpage-1)/blocksize*blocksize+1;
        int endpage = startpage+blocksize-1;

        if(endpage>total_page){
            endpage = total_page;
        }

        List<BoardDTO> list = service.getList(startrow, pagesize, search_txt);
        request.setAttribute("list", list);
        request.setAttribute("currpage", currpage);
        request.setAttribute("total_page", total_page);
        request.setAttribute("startpage", startpage);
        request.setAttribute("endpage", endpage);
        request.setAttribute("search_txt", search_txt);

        request.setAttribute("uid",uid);
        Forward forward = new Forward();
        forward.setForward(true);
        forward.setUrl("WEB-INF/index.jsp?page=board/boardlist.jsp");

        return forward;
    }
}
