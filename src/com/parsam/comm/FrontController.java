package com.parsam.comm;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.*;

@WebServlet(name = "FrontController", value = "*.do"
            , initParams = {@WebInitParam(name = "prop", value = "/WEB-INF/prop.properties")})
public class FrontController extends HttpServlet {

    private Map<String, Action> hm = Collections.synchronizedMap(new HashMap<>());

    @Override
    public void init(ServletConfig config) throws ServletException {
        String init = config.getInitParameter("prop");
        Properties prop = new Properties();
        FileReader fr = null;

        try {
            String path = config.getServletContext().getRealPath(init);
            fr = new FileReader(path);
            prop.load(fr);

            Enumeration enu = prop.propertyNames();
            while (enu.hasMoreElements()){
                String key = (String) enu.nextElement();
                String value = (String) prop.get(key);

                Class libclass = Class.forName(value);
                Constructor c = libclass.getConstructor();
                Action o = (Action) c.newInstance();
                hm.put(key, o);
            }
        } catch (Exception e){
            System.out.println(e);
        } finally {
            if (fr!=null){
                try {
                    fr.close();
                } catch (Exception e){
                    System.out.println(e);
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doReq(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doReq(req, resp);
    }

    private void doReq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.println("한글");
        String path = request.getServletPath();

        Action act = hm.get(path);

        Forward result = act.execute(request, response);
        if (result.isForward()){
            RequestDispatcher disp = request.getRequestDispatcher(result.getUrl());
            disp.forward(request, response);
        } else {
            response.sendRedirect(result.getUrl());
        }
    }
}
