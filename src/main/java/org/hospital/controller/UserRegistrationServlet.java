package org.hospital.controller;

import java.io.IOException;
import org.hospital.services.UserService;
import org.hospital.model.User;
import org.hospital.services.UserServiceImpl;

import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/register")
public class UserRegistrationServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/registration-form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
        String identifier = request.getParameter("identifier");
        String password = request.getParameter("password");

        User user = new User(name, age, gender, identifier, password);

        boolean registrationSuccess = userService.register(user);

        if (registrationSuccess) {
            response.sendRedirect(request.getContextPath() + "/registration-success.jsp");
        } else {
            request.setAttribute("errorMessage", "Registration failed. User already exists or invalid input.");
            request.getRequestDispatcher("/registration-form.jsp").forward(request, response);
        }
    }
}
