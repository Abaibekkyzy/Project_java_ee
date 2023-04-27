<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>IITU</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</head>
<body>
<%@include file="vendor/navbar3.jsp"%>

<div class="container" style="text-align:center">
    <div class="row mt-5">
        <div class="col-sm-12">
            <div class="container">
                <div class="row mt-5">
                    <div class="col-sm-12">
                        <div class="jumbotron">
                            <h1 class="display-4">Backend Quiz </h1>
                            <br><br>
                            <p class="lead">This is a test to test your skills in the subject "Backend".</p>
                            <p class="lead">Here are 10 questions for 30 minutes.</p>
                            <p class="lead">Please submit this test BEFORE April 20, 2023, 00:00 pm.</p>
                            <br><br><br>
                            <a class="btn btn-primary btn-lg" href="/test?id=<%=currentUser.getId()%>" role="button"
                               style="color: white; background-color: darkred; border: none; width: 150px; height: 50px;">SUBMIT</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
