package com.example.back_t2.ServletsForAdmin;

import com.example.back_t2.bd.DBManager_teacher;
import com.example.back_t2.bd.Teacher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "teachersList", value = "/teachersList")
public class TeachersListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Teacher> teachers = DBManager_teacher.getTeachers();
        request.setAttribute("DB_teachers", teachers);
        ArrayList<Teacher> teachers1 = DBManager_teacher.getTeachersMaxAge();
        request.setAttribute("DB_teachersMaxAge", teachers1);
        ArrayList<Teacher> teachers2 = DBManager_teacher.getTeachersMaxExperience();
        request.setAttribute("DB_teachersMaxExperience", teachers2);
        try {
            request.getRequestDispatcher("/teachersList.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
