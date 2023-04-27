<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.back_t2.bd.Student" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.example.back_t2.bd.Teacher" %>
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
                            <th>experience</th>
                            <th>email</th>
                            <th>password</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ArrayList<Teacher> teachers = (ArrayList<Teacher>) request.getAttribute("DB_teachers");
                            if(teachers!=null){
                                for(Teacher teacher: teachers){
                        %>
                            <tr>
                                <td>
                                    <%=teacher.getId()%>
                                </td>
                                <td>
                                    <%=teacher.getName()%>
                                </td>
                                <td>
                                    <%=teacher.getSurname()%>
                                </td>
                                <td>
                                    <%=teacher.getAge()%>
                                </td>
                                <td>
                                    <%=teacher.getExperience()%>
                                </td>
                                <td>
                                    <%=teacher.getEmail()%>
                                </td>
                                <td>
                                    <%=teacher.getPassword()%>
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
