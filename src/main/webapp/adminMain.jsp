<%@ page import="com.example.back_t2.bd.Administrator" %>
<%@ page import="java.util.ArrayList" %>
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
                <h4>List of administrators</h4>
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
                            ArrayList<Administrator> administrators = (ArrayList<Administrator>) request.getAttribute("DB_administrators");
                            if(administrators!=null){
                                for(Administrator administrator: administrators){
                        %>
                        <tr>
                            <td>
                                <%=administrator.getId()%>
                            </td>
                            <td>
                                <%=administrator.getName()%>
                            </td>
                            <td>
                                <%=administrator.getSurname()%>
                            </td>
                            <td>
                                <%=administrator.getAge()%>
                            </td>
                            <td>
                                <%=administrator.getDepartment()%>
                            </td>
                            <td>
                                <%=administrator.getEmail()%>
                            </td>
                            <td>
                                <%=administrator.getPassword()%>
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
