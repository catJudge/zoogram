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
<nav class="navbar navbar-default"
     style="background: white; padding: 15pt 18%">
    <div class="container-fluid">
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="${pageContext.request.contextPath}/" style="font-size: 20pt"><strong>Zoogram</strong></a>
                </li>
            </ul>
            <form class="navbar-form navbar-left" role="search" style="margin-left: 100pt">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${pageContext.request.contextPath}/logout/" style="font-size: 20pt">
                    <span class="glyphicon glyphicon-log-out"
                          aria-hidden="true"
                          title="profile"></span></a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${pageContext.request.contextPath}/profile/edit/${user.username}/" style="font-size: 20pt">
                    <span class="glyphicon glyphicon-edit"
                          aria-hidden="true"
                          title="edit"></span></a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${pageContext.request.contextPath}/profile/${user.username}/" style="font-size: 20pt">
                    <span class="glyphicon glyphicon-user"
                          aria-hidden="true"
                          title="profile"></span></a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="content container">
    <div class="row">
        <div class="col-md-2">

        </div>
        <div class="col-md-8">
            <div class="well">
                <h2><strong>Sorry, this page isn't available.</strong></h2>

                <h3><a href="${pageContext.request.contextPath}/" style="text-decoration: none">Go back to Zoogram.</a>
                </h3>
            </div>
        </div>
        <div class="col-md-2">

        </div>
    </div>
</div>

</body>
</html>
