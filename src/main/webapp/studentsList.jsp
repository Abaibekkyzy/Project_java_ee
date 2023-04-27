<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.back_t2.bd.Student" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="vendor/head.jsp"%>
</head>
<body>
<%@include file="vendor/navbar1.jsp"%>

    <div class="container">
        <div class="row mt-5">
            <div class="col-sm-12">
                <table class="table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Surname</th>
                            <th>Age</th>
                            <th>GPA</th>
                            <th>email</th>
                            <th>password</th>
                            <th>DETAILS</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ArrayList<Student> students = (ArrayList<Student>) request.getAttribute("DB_students");
                            if(students!=null){
                                for(Student student: students){
                        %>
                            <tr>
                                <td>
                                    <%=student.getId()%>
                                </td>
                                <td>
                                    <%=student.getName()%>
                                </td>
                                <td>
                                    <%=student.getSurname()%>
                                </td>
                                <td>
                                    <%=student.getAge()%>
                                </td>
                                <td>
                                    <%=student.getGPA()%>
                                </td>
                                <td>
                                    <%=student.getEmail()%>
                                </td>
                                <td>
                                    <%=student.getPassword()%>
                                </td>
                                <td>
                                    <a href="/detailsStudent?id=<%=student.getId()%>" class="btn btn-info btn-sm">DETAILS</a>
                                </td>
                            </tr>
                        <%
                                }
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

<div class="container">
    <div class="row mt-5">
        <div class="col-sm-6 offset-3">
            <%
                String success = request.getParameter("success");
                if(success!=null){

            %>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                Student added successfully!
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <%
                }
            %>
            <form action="/addstudent" method="post">
                <div class="form-group">
                    <label>Name:</label>
                    <input type="text" name="name" class="form-control">
                </div>
                <div class="form-group">
                    <label>Surname:</label>
                    <input type="text" name="surname" class="form-control">
                </div>
                <div class="form-group">
                    <label>Age:</label>
                    <input type="number" name="age" class="form-control">
                </div>
                <div class="form-group">
                    <label>GPA:</label>
                    <input type="double" name="gpa" class="form-control">
                </div>
                <div class="form-group">
                    <label>email:</label>
                    <input type="email" name="email" class="form-control">
                </div>
                <div class="form-group">
                    <label>password:</label>
                    <input type="password" name="password" class="form-control">
                </div>
                <div class="form-group">
                    <button class="btn btn-success">ADD Student</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
