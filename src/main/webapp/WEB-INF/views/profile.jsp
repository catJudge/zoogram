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
     style="background: white; padding: 15pt 20%">
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
                <li><a href="/logout/" style="font-size: 20pt">
                    <span class="glyphicon glyphicon-log-out"
                          aria-hidden="true"
                          title="profile"></span></a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/profile/edit/${user.username}/" style="font-size: 20pt">
                    <span class="glyphicon glyphicon-edit"
                          aria-hidden="true"
                          title="edit"></span></a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/profile/${user.username}/" style="font-size: 20pt">
                    <span class="glyphicon glyphicon-user"
                          aria-hidden="true"
                          title="profile"></span></a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <div class="col-md-2">

    </div>
    <div class="col-md-8">
        <div>
            <div style="display: inline-block">
                <div style="margin-top: 20pt; margin-bottom: 20pt; margin-left: 30pt">
                    <img class="img-circle" src="/static/images/back.jpg"
                         style="height: 20%; width: 20%; display: block;">
                </div>
            </div>
            <div style="display: inline-block ;font-size: 13pt">
                <div>
                    <h1>${user.username}</h1>
                </div>
                <div style="margin-bottom: 5pt"><strong>${user.name}</strong> ${user.bio}</div>
                <div style="margin-bottom: 5pt"><strong>${user.posts.size()}</strong> posts
                    <a href="" style="text-decoration: none"><strong>${user.followers.size()}</strong> followers</a>
                    <a href="" style="text-decoration: none "><strong>${user.followees.size()}</strong> following</a>
                </div>
            </div>
        </div>

        <div class="bs-example" data-example-id="simple-thumbnails">
            <div class="row">
                <c:if test="${user.posts.size() != 0}">
                    <c:forEach var="post" items="${user.posts}">
                        <div class="col-md-4">
                            <a href="${pageContext.request.contextPath}/post/${post.id}/" class="thumbnail">
                                <img
                                        src="/static/images/back.jpg"
                                        data-holder-rendered="true"
                                        style="height: 30%; width: 100%; display: block;">
                            </a></div>
                    </c:forEach>
                </c:if>
                <c:if test="${user.posts.size() == 0}">
                    <h1>This profile doesn't have posts</h1>
                </c:if>
            </div>
        </div>
    </div>
    <div class="col-md-2">

    </div>
</div>


</body>
</html>
