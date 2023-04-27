<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>IITU</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>

</head>
<body>
<%@include file="vendor/navbar3.jsp"%>

    <%
        Student user = (Student) request.getAttribute("users");
        if(user!=null){
    %>
        <%
            String success = request.getParameter("success");
            if(success!=null){

        %>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                Test saved successfully!
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
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
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        <%
            }
        %>

    <form action="/test" method="post">
        <input type="hidden" name="id" value="<%=user.getId()%>">
        <input type="hidden" name="email" value="<%=user.getEmail()%>">
        <div style="padding: 40px; font-size: 18px">
            <h2 style="margin-left: 550px; margin-bottom: 20px">Backend Skills Quiz</h2>
            <div style="margin-left: 150px; margin-right: 150px; padding:40px; background-color: #e3e5e5; border-radius: 12px">
                <p style="margin-bottom: 0px; padding-bottom: 5px">
                    1. Where is Brazil located?
                </p>
                <input type='radio' name='q1o1' value='South America'>
                South America
                <br>
                <input type='radio' name='q1o2' value='North America'>
                North America
                <br>
                <input type='radio' name='q1o3' value='Africa'>
                Africa
                <br><br>

                <p style="margin-bottom: 0px; padding-bottom: 5px">
                    2. Which country is the largest in the world?
                </p>
                <input type='radio' name='q2o1' value='Russia'>
                Russia
                <br>
                <input type='radio' name='q2o2' value='Canada'>
                Canada
                <br>
                <input type='radio' name='q2o3' value='Japan'>
                Japan
                <br><br>

                <p style="margin-bottom: 0px; padding-bottom: 5px">
                    3. In which country is the Statue of Liberty located?
                </p>
                <input type='radio' name='q3o1' value='Poland'>
                Poland
                <br>
                <input type='radio' name='q3o2' value='USA'>
                USA
                <br>
                <input type='radio' name='q3o3' value='Japan'>
                Japan
                <br><br>

                <p style="margin-bottom: 0px; padding-bottom: 5px">
                    4. What is the name of the place where the river flows into another river, sea or lake?
                </p>
                <input type='radio' name='q4o1' value='Mouth'>
                Mouth
                <br>
                <input type='radio' name='q4o2' value='Source'>
                Source
                <br>
                <input type='radio' name='q4o3' value='Riverbed'>
                Riverbed
                <br><br>

                <p style="margin-bottom: 0px; padding-bottom: 5px">
                    5. Which country is the birthplace of the Olympic Games?
                </p>
                <input type='radio' name='q5o1' value='Italy'>
                Italy
                <br>
                <input type='radio' name='q5o2' value='Greece'>
                Greece
                <br>
                <input type='radio' name='q5o3' value='Turkey'>
                Turkey
                <br><br>

                <p style="margin-bottom: 0px; padding-bottom: 5px">
                    6. Which country's capital is located on the Nile River?
                </p>
                <input type='radio' name='q6o1' value='Egypt'>
                Egypt
                <br>
                <input type='radio' name='q6o2' value='USA'>
                USA
                <br>
                <input type='radio' name='q6o3' value='India'>
                India
                <br><br>

                <p style="margin-bottom: 0px; padding-bottom: 5px">
                    7. Minsk is the capital ...
                </p>
                <input type='radio' name='q7o1' value='Belarus'>
                Belarus
                <br>
                <input type='radio' name='q7o2' value='Of Russia'>
                Of Russia
                <br>
                <input type='radio' name='q7o3' value='France'>
                France
                <br><br>

                <p style="margin-bottom: 0px; padding-bottom: 5px">
                    8. Where is India located?
                </p>
                <input type='radio' name='q8o1' value='North America'>
                North America
                <br>
                <input type='radio' name='q8o2' value='Europe'>
                Europe
                <br>
                <input type='radio' name='q8o3' value='Asia'>
                Asia
                <br><br>

                <button class="btn btn-success" style="background-color: darkred; color: white; border: none">SUBMIT</button>

            </div>
        </div>
    </form>
    <%
        }
    %>
</body>
</html>

