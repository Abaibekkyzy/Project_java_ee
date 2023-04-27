package com.example.back_t2;

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

@WebServlet(value = "/test")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id =0L;
        try{
            id = Long.parseLong(request.getParameter("id"));

        }catch (Exception e){

        }

        Student user = DBManager.getStudent(id);
        if(user!=null){
            request.setAttribute("users", user);
            request.getRequestDispatcher("/test.jsp").forward(request, response);

        }else{
            request.getRequestDispatcher("/404.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String email = request.getParameter("email");

        String q1o1 = request.getParameter("q1o1");
        String q1o2 = request.getParameter("q1o2");
        String q1o3 = request.getParameter("q1o3");
        String answer1 = "";

        Test test = DBManager.getTest(1L);
        int points = 0;
        if(q1o1!=null){
            answer1 = q1o1;
            if(test.getAnswer1().equals(q1o1)){
                points++;
            }
        }else if(q1o2!=null){
            answer1 = q1o2;
            if(test.getAnswer1().equals(q1o2)){
                points++;
            }
        }else if(q1o3!=null){
            answer1 = q1o3;
            if(test.getAnswer1().equals(q1o3)){
                points++;
            }
        }

        String q2o1 = request.getParameter("q2o1");
        String q2o2 = request.getParameter("q2o2");
        String q2o3 = request.getParameter("q2o3");
        String answer2 = "";

        if(q2o1!=null){
            answer2 = q2o1;
            if(test.getAnswer2().equals(q2o1)){
                points++;
            }
        }else if(q2o2!=null){
            answer2 = q2o2;
            if(test.getAnswer2().equals(q2o2)){
                points++;
            }
        }else if(q2o3!=null){
            answer2 = q2o3;
            if(test.getAnswer2().equals(q2o3)){
                points++;
            }
        }

        String q3o1 = request.getParameter("q3o1");
        String q3o2 = request.getParameter("q3o2");
        String q3o3 = request.getParameter("q3o3");
        String answer3 = "";

        if(q3o1!=null){
            answer3 = q3o1;
            if(test.getAnswer3().equals(q3o1)){
                points++;
            }
        }else if(q3o2!=null){
            answer3 = q3o2;
            if(test.getAnswer3().equals(q3o2)){
                points++;
            }
        }else if(q3o3!=null){
            answer3 = q3o3;
            if(test.getAnswer3().equals(q3o3)){
                points++;
            }
        }

        String q4o1 = request.getParameter("q4o1");
        String q4o2 = request.getParameter("q4o2");
        String q4o3 = request.getParameter("q4o3");
        String answer4 = "";

        if(q4o1!=null){
            answer4 = q4o1;
            if(test.getAnswer4().equals(q4o1)){
                points++;
            }
        }else if(q4o2!=null){
            answer4 = q4o2;
            if(test.getAnswer4().equals(q4o2)){
                points++;
            }
        }else if(q4o3!=null){
            answer4 = q4o3;
            if(test.getAnswer4().equals(q4o3)){
                points++;
            }
        }

        String q5o1 = request.getParameter("q5o1");
        String q5o2 = request.getParameter("q5o2");
        String q5o3 = request.getParameter("q5o3");
        String answer5 = "";

        if(q5o1!=null){
            answer5 = q5o1;
            if(test.getAnswer5().equals(q5o1)){
                points++;
            }
        }else if(q5o2!=null){
            answer5 = q5o2;
            if(test.getAnswer5().equals(q5o2)){
                points++;
            }
        }else if(q5o3!=null){
            answer5 = q5o3;
            if(test.getAnswer5().equals(q5o3)){
                points++;
            }
        }

        String q6o1 = request.getParameter("q6o1");
        String q6o2 = request.getParameter("q6o2");
        String q6o3 = request.getParameter("q6o3");
        String answer6 = "";

        if(q6o1!=null){
            answer6 = q6o1;
            if(test.getAnswer6().equals(q6o1)){
                points++;
            }
        }else if(q6o2!=null){
            answer6 = q6o2;
            if(test.getAnswer6().equals(q6o2)){
                points++;
            }
        }else if(q6o3!=null){
            answer6 = q6o3;
            if(test.getAnswer6().equals(q6o3)){
                points++;
            }
        }

        String q7o1 = request.getParameter("q7o1");
        String q7o2 = request.getParameter("q7o2");
        String q7o3 = request.getParameter("q7o3");
        String answer7 = "";

        if(q7o1!=null){
            answer7 = q7o1;
            if(test.getAnswer7().equals(q7o1)){
                points++;
            }
        }else if(q7o2!=null){
            answer7 = q7o2;
            if(test.getAnswer7().equals(q7o2)){
                points++;
            }
        }else if(q7o3!=null){
            answer7 = q7o3;
            if(test.getAnswer7().equals(q7o3)){
                points++;
            }
        }

        String q8o1 = request.getParameter("q8o1");
        String q8o2 = request.getParameter("q8o2");
        String q8o3 = request.getParameter("q8o3");
        String answer8 = "";

        if(q8o1!=null){
            answer8 = q8o1;
            if(test.getAnswer8().equals(q8o1)){
                points++;
            }
        }else if(q8o2!=null){
            answer8 = q8o2;
            if(test.getAnswer8().equals(q8o2)){
                points++;
            }
        }else if(q8o3!=null){
            answer8 = q8o3;
            if(test.getAnswer8().equals(q8o3)){
                points++;
            }
        }


        Student student = DBManager.getStudent(id);


        student.setEmail(student.getEmail());
        student.setPassword(student.getPassword());
        student.setName(student.getName());
        student.setSurname(student.getSurname());
        student.setAge(student.getAge());
        student.setGPA(student.getGPA());
        student.setPoints(points);
        DBManager.updateStudents(student);


        StudentAnswers sa = new StudentAnswers(null, email, answer1, answer2, answer3,
                answer4, answer5, answer6, answer7, answer8);
        DBManager.addStudentAnswers(sa);

        response.sendRedirect("/StudentServlet");
    }
}
