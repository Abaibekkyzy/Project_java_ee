package com.example.back_t2.ServletsForTeacher;

import com.example.back_t2.bd.DBManager;
import com.example.back_t2.bd.Student;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "TeacherServlet", value = "/TeacherServlet")
public class TeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Student> students = DBManager.getStudents();
        request.setAttribute("DB_students", students);
//
//        try {
//            request.getRequestDispatcher("/teacherMain.jsp").forward(request, response);
//        } catch (ServletException e) {
//            throw new RuntimeException(e);
//        }
        request.getRequestDispatcher("/chart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/chart.jsp").forward(request, response);
    }
}
