package com.example.back_t2.ServletsForAdmin;

import com.example.back_t2.bd.DBManager;
import com.example.back_t2.bd.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "studentsList", value = "/studentsList")
public class StudentListServlet extends HttpServlet {


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
            request.getRequestDispatcher("/studentsList.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }


}