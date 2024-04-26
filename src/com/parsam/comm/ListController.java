package com.parsam.comm;

import com.parsam.dto.ProductDTO;
import com.parsam.service.SearchProductService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

// 코드를 어떻게 구현할까?
/*
2. 검색 결과가 ajax 처리로 해서 서버에 넘어간다
3. 해당 컨트롤러에서 URL을 받고, 해당 요청을 처리하는 클래스를 호출한다(ListController) => ajax 처리를 위해 따로 생성함.
4. DB로부터 데이터를 가지고 오고, 가지고 온 데이터를 JSON 형태의 문자열로 만들어서 response 객체에 담아 보낸다. (Action 파일)
5, Service 클래스에서 DAO 클래스를 호출하기 (파일명 생각 안 함)
6. 다시 그 페이지로 돌아와서 적절한 응답을 하기!

=> 입력과 동시에 결과가 나와야 함 =>
*/
@WebServlet("/listjson")
public class ListController extends HttpServlet {


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

        String search = request.getParameter("header_search");

        // JSONArray arr = new JSONArray(); // 근데 이게 있어야 JSON으로 저장하는 것 아닌가...? 어떻게 저장함...? ㅎㅎ,,,

        SearchProductService service = SearchProductService.getService();
        List<ProductDTO> list =  service.searchResult(search);

        JSONArray arr = new JSONArray(); // 배열이 필요하니까 ㅇㅇ

        for (int i=0; i<list.size(); i++) {
            JSONObject obj = new JSONObject(); // 배열 내에 들어갈 JSON
            obj.put("p_id", list.get(i).getP_id());
            obj.put("p_img", list.get(i).getP_img());
            obj.put("p_cate", list.get(i).getP_cate());
            obj.put("p_name", list.get(i).getP_name());
            obj.put("p_price", list.get(i).getP_price());
            obj.put("p_state", list.get(i).getP_state());
            obj.put("p_fav", list.get(i).getP_fav());
            arr.add(obj);
        }

        PrintWriter out = response.getWriter();
        out.print(arr);

        // 주소 찾고 싶을 때 이용!~!
        // http://localhost:8080/jsp_project/listjson?header_search=검색하고 싶은 값

    }
}
