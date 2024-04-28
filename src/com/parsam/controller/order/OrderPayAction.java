package com.parsam.controller.order;

import com.parsam.comm.Action;
import com.parsam.comm.Forward;
import com.parsam.dto.BoardDTO;
import com.parsam.dto.OrderDTO;
import com.parsam.service.OrderService;
import com.parsam.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OrderPayAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oaddr = request.getParameter("oaddr");
        String omemo = request.getParameter("omemo");
        String ophone = request.getParameter("ophone");
        long pid = Long.parseLong(request.getParameter("pid"));
        int ocnt = Integer.parseInt(request.getParameter("ocnt"));

        HttpSession session = request.getSession(false);
        String id = (String) session.getAttribute("id");
        UserService uservice = UserService.getService();
        long uid = uservice.getUid(id);

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
        forward.setUrl("WEB-INF/index.jsp?page=chh_order/ordercomplete.jsp");
        return forward;
    }
}
