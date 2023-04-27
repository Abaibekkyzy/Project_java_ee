package com.example.back_t2.ServletsForTeacher;

import com.example.back_t2.bd.Administrator;
import com.example.back_t2.bd.DBManager_administrator;
import com.example.back_t2.bd.DBManager_teacher;
import com.example.back_t2.bd.Teacher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "authTeacher", value = "/authTeacher")
public class AuthTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String redirect = "/loginTeacher?emailerror";
        Teacher teacher = DBManager_teacher.getTeacher(email);

        if(teacher!=null){
            redirect = "/loginTeacher?passworderror";
            if(teacher.getPassword().equals((password))){
                request.getSession().setAttribute("CURRENT_Teacher", teacher);
                redirect = "/TeacherServlet";
            }
        }
        response.sendRedirect(redirect);

    }
}
