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
                <% Student st = (Student) request.getAttribute("detailsStudent");
                if(st!=null){
                %>
                <div class="jumbotron">
                    <h1 class="display-4"><%=(st.getName() + " " + st.getSurname())%></h1>
                    <p class="lead">Age: <%=st.getAge()%></p>
                    <hr class="my-4">
                    <p>GPA: <%=st.getGPA()%></p>
                    <p>email: <%=st.getEmail()%></p>
                    <p>password: <%=st.getPassword()%></p>
<%--                    <a class="btn btn-primary btn-sm" href="/edit?id=<%=st.getId()%>" role="button">EDIT</a>--%>
                </div>
                <%
                    }
                %>
            </div>
        </div>
    </div>
</body>
</html>
