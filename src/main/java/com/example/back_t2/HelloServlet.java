package com.example.back_t2;

import java.io.*;
import java.util.ArrayList;

import com.example.back_t2.bd.DBManager;
import com.example.back_t2.bd.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "home", value = "/home")
public class HelloServlet extends HttpServlet {


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ArrayList<Student> students = DBManager.getStudents();
        request.setAttribute("DB_students", students);
        ArrayList<Student> students1 = DBManager.getStudentsMaxGpa();
        request.setAttribute("Max_GPA", students1);
        ArrayList<Student> students2 = DBManager.getStudentsMaxAge();
        request.setAttribute("Max_age", students2);
        try {
            request.getRequestDispatcher("/home.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

    }


}