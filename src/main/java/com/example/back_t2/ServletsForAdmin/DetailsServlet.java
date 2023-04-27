package com.example.back_t2.ServletsForAdmin;

import com.example.back_t2.bd.DBManager;
import com.example.back_t2.bd.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "detailsStudent", value = "/detailsStudent")
public class DetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id =  Long.parseLong(request.getParameter("id"));

        Student st = DBManager.getStudent(id);

        if(st!=null){
            request.setAttribute("detailsStudent", st);
            request.getRequestDispatcher("/detailsStudent.jsp").forward(request, response);
        } else{
            request.getRequestDispatcher("/404.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
