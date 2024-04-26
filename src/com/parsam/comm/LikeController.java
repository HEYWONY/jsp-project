package com.parsam.comm;

import com.parsam.dto.ProductDTO;
import com.parsam.service.LikeService;
import com.parsam.service.SearchProductService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/like")
public class LikeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doReq(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doReq(request, response);
    }

    private void doReq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");

        HttpSession session = request.getSession(false);
        String id= (String) session.getAttribute("id");

        long pid = Long.parseLong(request.getParameter("p_id"));
        long result = 0;
        LikeService service = LikeService.getService();
        service.likeChange(id, pid);
        result = service.getFav(id, pid);
        System.out.println("con " + result);

        PrintWriter out = response.getWriter();
        out.print(result);

    }
}

