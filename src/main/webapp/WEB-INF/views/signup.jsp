<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="../../static/js/jquery-2.2.1.min.js"></script>

    <link rel="stylesheet" href="../../static/bootstrap-3.3.6-dist/css/bootstrap.css"/>
    <script type="text/javascript" src="../../static/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../../static/css/styles.css"/>
    <link rel="shortcut icon" href="../../static/images/favicon.ico" type="image/x-icon">
    <title>Zoogram</title>
</head>
<body style="background: #f8f8f8">
<div class="container">

    <div class="col-md-4">

    </div>
    <div class="col-md-4">
        <div class="panel panel-default" style=" margin-top: 10pt">
            <div class="panel-body" style=" margin: 20pt;">
                <h1 style="text-align: center">Zoogram</h1>
                <form action="<c:url value="/signup"/>" method="post">
                    <h3  style="text-align: center">
                        Sign up to see photos from your friends.
                    </h3>
                    <div class="form-group">
                        <input type="email" class="form-control" name="inputEmail" placeholder="Email">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="inputFullname" placeholder="Full Name">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="inputUsername" placeholder="Username">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" name="inputPassword" placeholder="Password">
                    </div>
                    <button type="submit" class="btn btn-primary" style="background: #3897f0; width: 100%">Sign up
                    </button>
                </form>
            </div>
        </div>
        <div class="panel panel-default" style=" margin-top: 10pt">
            <div class="panel-body">
                <div style=" text-align: center">
                    Have an account?
                    <a href="${pageContext.request.contextPath}/login" style="color: #3897f0; text-decoration: none">Log in</a>
                </div>
            </div>
        </div>
    </div>
    <div class="col-md-4">

    </div>
</div>

</body>
</html>
