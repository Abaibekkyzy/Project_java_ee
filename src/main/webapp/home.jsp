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
    <%@include file="vendor/navbar.jsp"%>
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
                                    <a href="/details?id=<%=student.getId()%>" class="btn btn-info btn-sm">DETAILS</a>
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

        <div>
            <div class="accordion" id="accordionExample">
                <div class="accordion-item">
                    <h2 class="accordion-header" id="headingOne">
                        <button class="accordion-button" type="btn btn-outline-primary" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                            Max GPA
                        </button>
                    </h2>
                    <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
                        <div class="accordion-body">

                                        <table class="table">

                                            <tbody>
                                            <%
                                                ArrayList<Student> students1 = (ArrayList<Student>) request.getAttribute("Max_GPA");
//                                                if(n!=1){
//                                                    for(Student student: students1){
//                                                        n++;
                                            %>
                                            <tr>
                                                <td>
                                                    <%=students1.get(0).getId()%>
                                                </td>
                                                <td>
                                                    <%=students1.get(0).getName()%>
                                                </td>
                                                <td>
                                                    <%=students1.get(0).getSurname()%>
                                                </td>
                                                <td>
                                                    <%=students1.get(0).getAge()%>
                                                </td>
                                                <td>
                                                    <%=students1.get(0).getGPA()%>
                                                </td>
                                                <td>
                                                    <a href="/details?id=<%=students1.get(0).getId()%>" class="btn btn-info btn-sm">DETAILS</a>
                                                </td>
                                            </tr>
                                            <%
                                                //                                                    }
//                                                }
                                            %>
                                            </tbody>
                                        </table>

                        </div>
                    </div>
                </div>
                <div class="accordion-item">
                    <h2 class="accordion-header" id="headingTwo">
                        <button class="accordion-button collapsed" type="btn btn-outline-success" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                            Max age
                        </button>
                    </h2>
                    <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
                        <div class="accordion-body">
                            <table class="table">
                                <tbody>
                                <%
                                    ArrayList<Student> students2 = (ArrayList<Student>) request.getAttribute("Max_age");
//                                                if(n!=1){
//                                                    for(Student student: students1){
//                                                        n++;
                                %>
                                <tr>
                                    <td>
                                        <%=students2.get(0).getId()%>
                                    </td>
                                    <td>
                                        <%=students2.get(0).getName()%>
                                    </td>
                                    <td>
                                        <%=students2.get(0).getSurname()%>
                                    </td>
                                    <td>
                                        <%=students2.get(0).getAge()%>
                                    </td>
                                    <td>
                                        <%=students2.get(0).getGPA()%>
                                    </td>
                                    <td>
                                        <a href="/details?id=<%=students2.get(0).getId()%>" class="btn btn-info btn-sm">DETAILS</a>
                                    </td>
                                </tr>
                                <%
                                    //                                                    }
//                                                }
                                %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>


<%--            <button type="button" class="btn btn-outline-danger">Danger</button>--%>
        </div>
    </div>
</body>
</html>
