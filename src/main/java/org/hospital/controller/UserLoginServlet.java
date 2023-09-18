package org.hospital.controller;

import org.hospital.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;

import org.hospital.services.UserServiceImpl;



@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login-form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String identifier = request.getParameter("identifier");
        String password = request.getParameter("password");

        boolean loginSuccess = userService.login(identifier, password);

        if (loginSuccess) {
            response.sendRedirect(request.getContextPath() + "/login-success.jsp");
        } else {
            request.setAttribute("errorMessage", "Login failed. Invalid credentials.");
            request.getRequestDispatcher("/login-form.jsp").forward(request, response);
        }
    }
}