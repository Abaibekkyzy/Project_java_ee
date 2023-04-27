package com.example.back_t2.ServletsForAdmin;

import com.example.back_t2.bd.DBManager;
import com.example.back_t2.bd.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "addstudent", value = "/addstudent")
public class AddStudentServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        int age = (Integer.parseInt(request.getParameter("age")));
        double GPA = (Double.parseDouble(request.getParameter("gpa")));
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int points = (Integer.parseInt(request.getParameter("points")));

        Student st = new Student(null, name, surname, age, GPA, email, password, points);
        DBManager.addStudent(st);

        response.sendRedirect("/addstudent?success");//автомат перенаправить

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/addstudent.jsp").forward(request, response);
    }
}
