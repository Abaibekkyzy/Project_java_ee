package com.example.back_t2.ServletsForAdmin;

import com.example.back_t2.bd.DBManager_administrator;
import com.example.back_t2.bd.Administrator;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "authAdmin", value = "/authAdmin")
public class AuthAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String redirect = "/login?emailerror";
        Administrator administrator = DBManager_administrator.getAdministrator(email);

        if(administrator!=null){
            redirect = "/login?passworderror";
            if(administrator.getPassword().equals((password))){
                request.getSession().setAttribute("CURRENT_ADMIN", administrator);
                redirect = "/AdminServlet";
            }
        }
        response.sendRedirect(redirect);

    }
}
