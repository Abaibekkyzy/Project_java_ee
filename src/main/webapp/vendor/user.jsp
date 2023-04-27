<%@ page import="com.example.back_t2.bd.Student" %><%
    Student currentUser = (Student) request.getSession().getAttribute("CURRENT_USER");
    boolean ONLINE = false;
    if(currentUser!=null){
        ONLINE=true;
    }
%>