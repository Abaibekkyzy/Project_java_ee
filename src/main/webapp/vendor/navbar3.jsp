<%@include file="user.jsp"%>
<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: lightseagreen">
    <a class="navbar-brand" href="/">UNI</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/StudentServlet">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/studentEdit?id=1">My page</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="/details?id=<%=currentUser.getId()%>">Test</a>
            </li>



        </ul>
    </div>
</nav>
