<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.back_t2.bd.Student" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.example.back_t2.bd.Administrator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/vendor/head.jsp"%>
</head>

<body>
<%@include file="vendor/navbar1.jsp"%>
<%--<div class="container">--%>
<%--    <div class="row mt-5">--%>
<%--        <div class="col-sm-12">--%>
<%--            <% Administrator admin = (Administrator) request.getAttribute("adminEdit");--%>
<%--                if(admin!=null){--%>
<%--            %>--%>
<%--            <div class="jumbotron">--%>
<%--                <h1 class="display-4"><%=(admin.getName() + " " + admin.getSurname())%></h1>--%>
<%--                <p class="lead">Age: <%=admin.getAge()%></p>--%>
<%--                <hr class="my-4">--%>
<%--                <p>Department: <%=admin.getDepartment()%></p>--%>
<%--                <p>Email: <%=admin.getEmail()%></p>--%>
<%--                <p>password: <%=admin.getPassword()%></p>--%>
<%--            </div>--%>
<%--            <%--%>
<%--                }--%>
<%--            %>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<div class="container">
    <div class="row mt-5">
        <div class="col-sm-6 offset-3">
            <% Administrator st = (Administrator) request.getAttribute("adminEdit");
                if(st!=null){
            %>
            <%
                String success = request.getParameter("success");
                if(success!=null){
            %>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                Administrator saved successfully!
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <%
                }
            %>

            <%
                String error = request.getParameter("error");
                if(error!=null){
            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                Something went wrong!
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <%
                }
            %>
            <form action="/adminEdit" method="post">
                <input type="hidden" name="id" value="<%=st.getId()%>">
                <div class="form-group">
                    <label>Name:</label>
                    <input type="text" name="name" class="form-control" value="<%=st.getName()%>">
                </div>
                <div class="form-group">
                    <label>Surname:</label>
                    <input type="text" name="surname" class="form-control" value="<%=st.getSurname()%>">
                </div>
                <div class="form-group">
                    <label>Age:</label>
                    <input type="number" name="age" class="form-control" value="<%=st.getAge()%>">
                </div>
                <div class="form-group">
                    <label>department:</label>
                    <input type="double" name="department" class="form-control" value="<%=st.getDepartment()%>">
                </div>
                <div class="form-group">
                    <label>email:</label>
                    <input type="text" name="email" class="form-control" value="<%=st.getEmail()%>">
                </div>
                <div class="form-group">
                    <label>password:</label>
                    <input type="text" name="password" class="form-control" value="<%=st.getPassword()%>">
                </div>
                <div class="form-group">
                    <button class="btn btn-success">Save Admin</button>
                    <button type="button" class="btn btn-danger float-right" data-bs-toggle="modal" data-bs-target="#exampleModal">
                        Delete Admin
                    </button>
                </div>
            </form>
            <!-- Модальное окно -->
            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="/delete" method="post">
                            <input type="hidden" name="id" value="<%=st.getId()%>">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Confirm delete process</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Закрыть"></button>
                            </div>
                            <div class="modal-body">
                                Are you sure?
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
                                <button type="submit" class="btn btn-danger">Yes</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <%
                }
            %>
        </div>
    </div>
</div>
</body>
</html>
