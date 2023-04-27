<%@ page import="com.example.back_t2.bd.Administrator" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.back_t2.bd.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="vendor/head.jsp"%>
</head>
<body>
<%@include file="vendor/navbar2.jsp"%>

<div class="container">
    <div class="row mt-5">
        <h4>List of students</h4>
        <div class="col-sm-12">
            <table class="table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Age</th>
                    <th>Department</th>
                    <th>email</th>
                    <th>password</th>
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

</body>
</html>
