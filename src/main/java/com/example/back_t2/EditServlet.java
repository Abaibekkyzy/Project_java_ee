package com.example.back_t2;

import com.example.back_t2.bd.DBManager;
import com.example.back_t2.bd.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "edit", value = "/edit")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        Student st = DBManager.getStudent(id);

        if(st!=null){
            request.setAttribute("student", st);
            request.getRequestDispatcher("/edit.jsp").forward(request, response);
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
        double GPA = Double.parseDouble(request.getParameter("gpa"));

        Student st = DBManager.getStudent(id);

        if(st!=null){
            st.setName(name);
            st.setSurname(surname);
            st.setAge(age);
            st.setGPA(GPA);
            //DBManager.saveStudent(st);

            if(DBManager.saveStudent(st)){
                response.sendRedirect("/edit?id="+id+"&success");
            }
            else{
                response.sendRedirect("/edit?id="+id+"&error");
            }
        } else{
            response.sendRedirect("/");
        }
    }
}
