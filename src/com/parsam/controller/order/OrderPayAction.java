package com.parsam.controller.order;

import com.parsam.comm.Action;
import com.parsam.comm.Forward;
import com.parsam.dto.BoardDTO;
import com.parsam.dto.OrderDTO;
import com.parsam.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderPayAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oaddr = request.getParameter("oaddr");
        String omemo = request.getParameter("omemo");
        String ophone = request.getParameter("ophone");
        long pid = Long.parseLong(request.getParameter("pid"));
        int ocnt = Integer.parseInt(request.getParameter("ocnt"));
        long uid = 3; //orderform에서 부터 session으로 넘겨 받을 것 (임시, 수정해야 함)

        OrderDTO odto = new OrderDTO();
        odto.setO_addr(oaddr);
        odto.setO_memo(omemo);
        odto.setO_phone(ophone);
        odto.setP_id(pid);
        odto.setO_cnt(ocnt);
        odto.setU_id(uid);

        OrderService service = OrderService.getService();
        service.insertOrder(odto);

        service.subStock(odto);

        Forward forward = new Forward();
        forward.setForward(true);
        forward.setUrl("WEB-INF/main/index.jsp?page=../chh_order/order_complete.jsp");
        return forward;
    }
}
