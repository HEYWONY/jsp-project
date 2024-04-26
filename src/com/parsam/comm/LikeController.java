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

        /*2. 버튼을 누르면 ajax 처리로 해서 서버에 넘어간다
        3. 해당 컨트롤러에서 P_id를 받고, 해당 요청을 처리하는 클래스를 호출한다(LikeController) => ajax 처리를 위해 따로 생성함.
        4. DB로부터 데이터를 가지고 오고, 가지고 온 데이터를 JSON<- 멀 만들어?
        5, Service 클래스에서 DAO 클래스를 호출하기 (파일명 생각 안 함)
        6. 다시 그 페이지로 돌아와서 적절한 응답을 하기!
        */

        LikeService service = LikeService.getService();
        service.likeChange(id, pid);

        JSONArray arr= new JSONArray();
        JSONObject obj = new JSONObject();

        obj.put("pid", pid);
        obj.put("id", id);
        arr.add(obj);

        PrintWriter out = response.getWriter();
        out.print(arr);

    }
}

