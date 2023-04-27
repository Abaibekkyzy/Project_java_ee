package com.example.back_t2.ServletsForStudent;

import com.example.back_t2.bd.DBManager;
import com.example.back_t2.bd.Student;
import com.example.back_t2.bd.StudentAnswers;
import com.example.back_t2.bd.Test;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/details")
public class DetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id =0L;
        try{
            id = Long.parseLong(request.getParameter("id"));

        }catch (Exception e){

        }
        Student student = DBManager.getStudent(id);
        Test test = DBManager.getTest(1L);

        StudentAnswers studentAnswers = DBManager.getStudentAnswers(student.getEmail());
        if(studentAnswers!=null){
            int attempts = 0;
            student.setAttempts(attempts);
            DBManager.updateStudents(student);
        }
        if(student.getAttempts()==0){
            request.setAttribute("student", student);
            request.setAttribute("studentanswers", studentAnswers);
            request.setAttribute("tests", test);
            request.getRequestDispatcher("/submittedtest").include(request, response);
            //request.getRequestDispatcher("/submittedtest.jsp").forward(request, response);

        }else{
            if(student!=null){
                request.setAttribute("students", student);
                request.getRequestDispatcher("/details.jsp").forward(request, response);

            }else{
                request.getRequestDispatcher("/404.jsp").forward(request, response);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

