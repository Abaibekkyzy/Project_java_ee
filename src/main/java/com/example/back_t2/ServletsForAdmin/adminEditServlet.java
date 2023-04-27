package com.example.back_t2.ServletsForAdmin;

import com.example.back_t2.bd.Administrator;
import com.example.back_t2.bd.DBManager_administrator;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;


@WebServlet(name = "adminEdit", value = "/adminEdit")
public class adminEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        Administrator administrator = DBManager_administrator.getAdministrator(id);

        if(administrator!=null){
            request.setAttribute("adminEdit", administrator);
            request.getRequestDispatcher("/adminEdit.jsp").forward(request, response);
        } else{
            request.getRequestDispatcher("/404.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        int age = Integer.parseInt(request.getParameter("age"));
        String department = request.getParameter("department");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Administrator administrator = DBManager_administrator.getAdministrator(id);

        if(administrator!=null){
            administrator.setName(name);
            administrator.setSurname(surname);
            administrator.setAge(age);
            administrator.setDepartment(department);
            administrator.setEmail(email);
            administrator.setPassword(password);

            if(DBManager_administrator.saveAdministrator(administrator)){
                response.sendRedirect("/adminEdit?id="+id+"&success");
            }
            else{
                response.sendRedirect("/adminEdit?id="+id+"&error");
            }
        } else{
            response.sendRedirect("/");
        }
    }
}

