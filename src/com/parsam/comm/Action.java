package com.parsam.comm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Action {
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
