package com.example.back_t2;

import com.example.back_t2.bd.DBManager;
import com.example.back_t2.bd.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet( value = "/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));

        Student st = DBManager.getStudent(id);

        if(st!=null){

            if(DBManager.deleteStudent(st)){
                response.sendRedirect("/");
            }
            else{
                response.sendRedirect("/edit?id="+id+"&error");
            }
        } else{
            response.sendRedirect("/");
        }
    }
}
