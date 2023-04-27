package com.example.back_t2.ServletsForStudent;

import com.example.back_t2.bd.DBManager;
import com.example.back_t2.bd.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "authStudent", value = "/authStudent")
public class AuthStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String redirect = "/loginStudent?emailerror";
        Student student = DBManager.getStudent(email);

        if(student!=null){
            redirect = "/loginStudent?passworderror";
            if(student.getPassword().equals(password)){
                request.getSession().setAttribute("CURRENT_USER", student);
                redirect = "/StudentServlet";
            }
        }
        response.sendRedirect(redirect);

    }
}
