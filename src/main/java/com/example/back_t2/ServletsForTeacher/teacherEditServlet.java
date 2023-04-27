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


@WebServlet(name = "teacherEdit", value = "/teacherEdit")
public class teacherEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        Administrator administrator = DBManager_administrator.getAdministrator(id);

        if(administrator!=null){
            request.setAttribute("teacherEdit", administrator);
            request.getRequestDispatcher("/teacherEdit.jsp").forward(request, response);
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
        int experience = Integer.parseInt(request.getParameter("experience"));
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Teacher teacher = DBManager_teacher.getTeacher(id);

        if(teacher!=null){
            teacher.setName(name);
            teacher.setSurname(surname);
            teacher.setAge(age);
            teacher.setExperience(experience);
            teacher.setEmail(email);
            teacher.setPassword(password);

            if(DBManager_teacher.saveTeacher(teacher)){
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

