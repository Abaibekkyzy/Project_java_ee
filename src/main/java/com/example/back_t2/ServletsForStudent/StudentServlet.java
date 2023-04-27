package com.example.back_t2.ServletsForStudent;

import com.example.back_t2.bd.DBManager;
import com.example.back_t2.bd.Student;
import com.example.back_t2.bd.Test;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "StudentServlet", value = "/StudentServlet")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Student> students = DBManager.getStudents();
        request.setAttribute("DB_students", students);

        ArrayList<Test> tests = DBManager.getTests();
        request.setAttribute("tests", tests);
        Student currentUser = (Student) request.getSession().getAttribute("CURRENT_USER");

        if(currentUser!=null){
        try {
            request.getRequestDispatcher("/studentMain.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

        }else{
            response.sendRedirect("/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/studentMain.jsp").forward(request, response);
    }
}
