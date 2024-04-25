package com.parsam.controller.order;

import com.parsam.comm.Action;
import com.parsam.comm.Forward;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderConfirmAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long pid = Long.parseLong(request.getParameter("pid")); //상품 아이디
        String pname = request.getParameter("pname"); // 상품명
        int pprice = Integer.parseInt(request.getParameter("pprice")); // 가격
        int ocnt = Integer.parseInt(request.getParameter("ocnt")); //주문수량
        int total = pprice*ocnt; //총결제금액

        String oname = request.getParameter("oname"); //주문자 이름
        String ophone = request.getParameter("ophone"); //주문자 전화번호

        String oaddr1 = request.getParameter("addr1"); // 우편번호
        String oaddr2 = request.getParameter("addr2"); // 주소
        String oaddr3 = request.getParameter("addr3"); // 상세주소
        String oaddr4 = request.getParameter("addr4"); // 참고항목

        String oaddr = oaddr2+" "+oaddr3+" "+oaddr4+" "+oaddr1; // 배송지 주소

        String omemo = request.getParameter("omemo"); //배송 메모

        request.setAttribute("pid", pid);
        request.setAttribute("pname",pname);
        request.setAttribute("pprice",pprice);
        request.setAttribute("ocnt",ocnt);
        request.setAttribute("total",total);
        request.setAttribute("oname",oname);
        request.setAttribute("ophone",ophone);
        request.setAttribute("oaddr",oaddr);
        request.setAttribute("omemo",omemo);

        Forward forward = new Forward();
        forward.setForward(true);
        forward.setUrl("WEB-INF/index.jsp?page=chh_order/orderconfirm.jsp");
        return forward;
    }
}
