<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.example.back_t2.bd.Student" %>


<%
    Gson gsonObj = new Gson();
    Map<Object,Object> map = null;
    List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();

    ArrayList<Student> students = (ArrayList<Student>) request.getAttribute("DB_students");
    for (int i=0; i< students.size();i++){
        map = new HashMap<Object,Object>();
        map.put("label", students.get(i).getName());
        map.put("y", students.get(i).getPoints()); list.add(map);
    }


    String dataPoints = gsonObj.toJson(list);
%>

<!DOCTYPE HTML>
<html>
<head>
    <title>IITU</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript">
        window.onload = function() {
            var chart = new CanvasJS.Chart("chartContainer", {
                theme: "light2",
                title: {
                    text: "Backend Skills Quiz"
                },
                axisX: {
                    title: "Students"
                },
                axisY: {
                    title: "Points",
                    includeZero: true
                },
                data: [{
                    type: "line",
                    yValueFormatString: "#,##0 points",
                    dataPoints : <%=dataPoints%>
                }]
            });
            chart.render();

        }
    </script>
</head>
<body>
<%@include file="vendor/navbar.jsp"%>
<div style="padding: 100px">
    <div id="chartContainer" style="height: 370px; width: 100%;"></div>
    <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</div>

</body>
</html>