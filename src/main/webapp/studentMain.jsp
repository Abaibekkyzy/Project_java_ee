<%@ page import="com.example.back_t2.bd.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="vendor/head.jsp"%>
</head>
<body>
<%@include file="vendor/navbar3.jsp"%>


<div class="container">
    <div class="row mt-5">
        <div class="col-sm-12">
            <div style="border: solid #d5d5d5 1px; border-radius: 5px">
                <div class="left-main-sections">
                    <div class="section-text" style="border-bottom: solid #d5d5d5 1px; padding: 10px; color: #0480ff">
                        <b style="padding-left: 25px"><a href="/myprofile?email=<%=(ONLINE?currentUser.getEmail():"NO USER")%>">My Profile</a></b></div>
                    <div class="section-text" style="border-bottom: solid #d5d5d5 1px; padding: 10px; color: #0480ff">
                        <b style="padding-left: 25px; color: darkred">Settings</b></div>
                </div>
            </div>

        </div>
    </div>
</div>

</body>
</html>
