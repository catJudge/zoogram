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
    <style>
        table.text {
            width: 100%; /* Ширина таблицы */
            border-spacing: 0; /* Расстояние между ячейками */
        }

        table.text td {
            width: 50%; /* Ширина ячеек */
            vertical-align: top; /* Выравнивание по верхнему краю */
        }

        td.rightcol {
            /* Правая ячейка */
            text-align: right; /* Выравнивание по правому краю */
        }

        td {
            padding: 5px;
        }

        a {
            text-decoration: none;
        }
    </style>
    <script>
        $(function () {

            // We can attach the `fileselect` event to all file inputs on the page
            $(document).on('change', ':file', function () {
                var input = $(this),
                        numFiles = input.get(0).files ? input.get(0).files.length : 1,
                        label = input.val().replace(/\\/g, '/').replace(/.*\//, '');
                input.trigger('fileselect', [numFiles, label]);
            });

            // We can watch for our custom `fileselect` event like this
            $(document).ready(function () {
                $(':file').on('fileselect', function (event, numFiles, label) {

                    var input = $(this).parents('.input-group').find(':text'),
                            log = numFiles > 1 ? numFiles + ' files selected' : label;

                    if (input.length) {
                        input.val(log);
                    } else {
                        if (log) alert(log);
                    }

                });
            });

        });
    </script>
</head>
<body style="background: #f8f8f8">
<nav class="navbar navbar-default"
     style="background: white; padding: 15pt 20%">
    <div class="container-fluid">
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="<c:url value="${pageContext.request.contextPath}/"/>" style="font-size: 20pt"><strong>Zoogram</strong></a>
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

<div class="contetnt container">
    <div class="row">
        <div class="col-md-2">

        </div>
        <div class="col-md-8">
            <div class="well">
                <div style="margin-top: 10pt">
                    <form action=" <c:url value="/add/post/"/>" method="post">
                        <div class="form-group" style="height: 20pt">
                            <input type="text" class="form-control" name="inputDescription"
                                   placeholder="What's a new?">
                        </div>
                        <div class="input-group">
                            <label class="input-group-btn">
                                <span class="btn btn-primary" style="background: white; border-color:#ccc; color: gray">
                                    Browse&hellip; <input type="file" name="inputFile" style="display: none;">
                                </span>
                            </label>
                            <input type="text" class="form-control" style="background: white; text-decoration: none; width: 80%"
                                   readonly >
                            <input type="submit" class="btn btn-default" value="Post" style="width: 20%">
                        </div>
                    </form>
                </div>
            </div>

            <c:forEach var="post" items="${posts}">
                <div class="well">
                    <table class="text">
                        <tr>
                            <td></td>
                            <td class="rightcol"
                                style="font-size: 10pt">${post.createdDate.toGMTString().replace("GMT", "")}</td>
                        </tr>
                    </table>
                    <div class="thumbnail">
                        <img
                                src="/static/images/back.jpg"
                                data-holder-rendered="true"
                                style="height: 100%; width: 100%; display: block;">
                    </div>
                    <div>
                        <div style="">
                    <span style="font-size: 20pt;" class="glyphicon glyphicon-heart" aria-hidden="true"
                          title="profile"></span>

                            <strong style="font-size: 14pt; ">${post.likes.size()}</strong>
                        </div>
                        <p><strong>${post.user.username}</strong>
                                ${post.description}
                        </p>
                        <table class="text">
                            <c:forEach var="comment" items="${post.comments}">
                                <tr style="">
                                    <td><strong>${comment.user.username}</strong>
                                            ${comment.text}</td>
                                    <td class="rightcol"
                                        style="font-size: 10pt">${comment.createdDate.toGMTString().replace("GMT", "")}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                    <div style="margin-top: 10pt">
                        <form action=" <c:url value="/post/${post.id}/add/comment/"/>" method="post">
                            <div class="form-group" style="height: 20pt">
                                <input type="text" class="form-control" name="inputComment" placeholder="Comment">
                            </div>
                        </form>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="col-md-2">

        </div>
    </div>
</div>

</body>
</html>
