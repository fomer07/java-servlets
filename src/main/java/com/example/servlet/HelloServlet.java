package com.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;


public class HelloServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the name parameter from the form
        String name = request.getParameter("name");

        // Set the response content type
        response.setContentType("text/html");

        // Generate a dynamic HTML response
        response.getWriter().write("<html><body>");
        response.getWriter().write("<h1>Hello, " + name + "!</h1>");
        response.getWriter().write("</body></html>");
    }
}
