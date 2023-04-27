<%@ page import="com.example.back_t2.bd.Administrator" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <%@include file="vendor/head.jsp"%>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: lightseagreen">
    <a class="navbar-brand" href="/">UNI</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/indexStudent.jsp">Student</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/indexTeacher.jsp">Teacher</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/">Administrator</a>
            </li>
        </ul>

    </div>
</nav>
<%@include file="vendor/photo.jsp"%>

<div class="container">
    <div class="row mt-5">
        <div class="col-sm-7">
            <h4 class = "mb-4">
                LOGIN TO SYSTEM
            </h4>
            <%
                String passworderror = request.getParameter("passworderror");
                if(passworderror!=null){

            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                Incorrect password!
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <%
                }
            %>

            <%
                String emailerror = request.getParameter("emailerror");
                if(emailerror!=null){

            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                Incorrect email!
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <%
                }
            %>


                <form action="/authAdmin" method="post">
                    <div class="form-group">
                        <label>email:</label>
                        <input type="email" name="email" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>password:</label>
                        <input type="password" name="password" class="form-control">
                    </div>

                    <div class="form-group">
                        <button class="btn btn-success">Join</button>
                    </div>
                </form>

        </div>
    </div>
</div>


</body>
</html>