<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.back_t2.bd.StudentAnswers" %>
<%@ page import="com.example.back_t2.bd.Test" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>IITU</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>

</head>
<body>

<%@include file="vendor/navbar3.jsp"%>
<%
    Student student = (Student) request.getAttribute("student");
    StudentAnswers studentAnswers = (StudentAnswers) request.getAttribute("studentanswers");
    Test test = (Test) request.getAttribute("tests");
    Long studId = (Long) request.getAttribute ("studId");
    if(student!=null){
%>
<div class="container" style="text-align:center">
    <div class="row mt-5">
        <div class="col-sm-12">
            <div class="container">
                <div class="row mt-5">
                    <div class="col-sm-12">
                        <div class="jumbotron">
                                    <h1 class="display-4">Backend Quiz </h1>
                                    <br>
                                    <p class="lead">You have already passed this test.</p>
                                    <p class="lead">Score: <%=student.getPoints()%> / 8</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
    <div style="padding-left: 150px; font-size: 18px; padding-bottom: 100px">
        <p class="lead" style="font-size: 28px;"><b>Your answers are below:</b></p>
        <hr style="margin-right: 150px">
        <p class="lead">1. Where is Brazil located?</p>
        <p class="lead">Your answer: <%=studentAnswers.getAnswer1()%> </p>
        <p class="lead"><b>Correct answers: <%=test.getAnswer1()%> </p>
        <br>
        <p class="lead">2. Which country is the largest in the world?</p>
        <p class="lead">Your answer: <%=studentAnswers.getAnswer2()%> </p>
        <p class="lead"><b>Correct answers: <%=test.getAnswer2()%> </p>
        <br>
        <p class="lead">3. In which country is the Statue of Liberty located?</p>
        <p class="lead">Your answer: <%=studentAnswers.getAnswer3()%> </p>
        <p class="lead"><b>Correct answers: <%=test.getAnswer3()%> </p>
        <br>
        <p class="lead">4. What is the name of the place where the river flows into another river, sea or lake?</p>
        <p class="lead">Your answer: <%=studentAnswers.getAnswer4()%> </p>
        <p class="lead"><b>Correct answers: <%=test.getAnswer4()%> </p>
        <br>
        <p class="lead">5. Which country is the birthplace of the Olympic Games?</p>
        <p class="lead">Your answer: <%=studentAnswers.getAnswer5()%> </p>
        <p class="lead"><b>Correct answers: <%=test.getAnswer5()%> </p>

        <br><p class="lead">6. Which country's capital is located on the Nile River?</p>
        <p class="lead">Your answer: <%=studentAnswers.getAnswer6()%> </p>
        <p class="lead"><b>Correct answers: <%=test.getAnswer6()%> </p>
        <br>
        <p class="lead">7. Minsk is the capital ...</p>
        <p class="lead">Your answer: <%=studentAnswers.getAnswer7()%> </p>
        <p class="lead"><b>Correct answers: <%=test.getAnswer7()%> </p>
        <br>
        <p class="lead">8. Where is India located?</p>
        <p class="lead">Your answer: <%=studentAnswers.getAnswer8()%> </p>
        <p class="lead"><b>Correct answers: <%=test.getAnswer8()%> </p>
        <br>
        <a class="btn btn-primary btn-lg" href="/StudentServlet" role="button"
           style="color: white; background-color: darkred; border: none; width: 150px; height: 50px;">BACK</a>
    </div>
<%

    }
%>

</body>
</html>


