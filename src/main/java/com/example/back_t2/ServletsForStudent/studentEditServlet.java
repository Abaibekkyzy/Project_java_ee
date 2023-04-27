package com.example.back_t2.ServletsForStudent;

import com.example.back_t2.bd.Administrator;
import com.example.back_t2.bd.DBManager;
import com.example.back_t2.bd.DBManager_administrator;
import com.example.back_t2.bd.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "studentEdit", value = "/studentEdit")
public class studentEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        Administrator administrator = DBManager_administrator.getAdministrator(id);

        if(administrator!=null){
            request.setAttribute("studentEdit", administrator);
            request.getRequestDispatcher("/studentEdit.jsp").forward(request, response);
        } else{
            request.getRequestDispatcher("/404.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        int age = Integer.parseInt(request.getParameter("age"));
        Double gpa = Double.parseDouble(request.getParameter("gpa"));
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Student student = DBManager.getStudent(id);

        if(student!=null){
            student.setName(name);
            student.setSurname(surname);
            student.setAge(age);
            student.setGPA(gpa);
            student.setEmail(email);
            student.setPassword(password);

            if(DBManager.saveStudent(student)){
                response.sendRedirect("/adminEdit?id="+id+"&success");
            }
            else{
                response.sendRedirect("/adminEdit?id="+id+"&error");
            }
        } else{
            response.sendRedirect("/");
        }
    }
}

