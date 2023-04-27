package com.example.back_t2.ServletsForAdmin;

import com.example.back_t2.bd.DBManager_administrator;
import com.example.back_t2.bd.Administrator;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class AdminServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Administrator> administrators = DBManager_administrator.getAdministrators();
        request.setAttribute("DB_administrators", administrators);
        ArrayList<Administrator> administrators1 = DBManager_administrator.getAdministratorsMaxAge();
        request.setAttribute("DB_administratorsMaxAge", administrators1);

            try {
                request.getRequestDispatcher("/adminMain.jsp").forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/adminMain.jsp").forward(request, response);
    }
}
