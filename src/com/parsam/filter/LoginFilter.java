package com.parsam.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@WebFilter(urlPatterns = {"*.do","/like"}, initParams={@WebInitParam(
        name="exclude"
        , value="/login.do, /login_result.do, /index.do ,/boardlist.do, /list.do, /join.do, /findId.do, /findId_result.do")})
public class LoginFilter implements Filter {
    private final Set<String> excluded=Collections.synchronizedSet(new HashSet<>());

    public void init(FilterConfig filterConfig) throws ServletException {
         String exclude_file=   filterConfig.getInitParameter("exclude");
         String[] data=exclude_file.split(",");
         for(String item:data){
            excluded.add(item.trim());
         }
    }

    boolean isExclude(HttpServletRequest request){
         String path=     request.getServletPath();
        System.out.println(path);
       return  excluded.contains(path);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;

            HttpSession session = request.getSession(false);

           if(excluded.contains(request.getServletPath())){
               filterChain.doFilter(request, response);
           } else {
                   if(session!=null){
                         String id = (String) session.getAttribute("id");
                       if (id != null) {
                           //System.out.println("filter!!! login !!");
                           System.out.println("filer  login!!!!!");
                           System.out.println("session not null");
                           filterChain.doFilter(request, response);

                       } else {
                           RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/user/login.jsp");
                           dispatcher.forward(request, response);
                       }
               } else {
                       RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/user/login.jsp");
                       dispatcher.forward(request, response);
                       }
                }
           }


    }
