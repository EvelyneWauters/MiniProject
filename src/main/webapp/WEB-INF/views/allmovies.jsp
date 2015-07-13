<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Movie list</title>

    <!-- Add Bootstrap! -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>


<body>
<div class="container">
    <h1>Top Movies</h1>
    <c:choose>
        <c:when test="${movie == null or empty movie}">
            <p>No movies found :-(</p>
        </c:when>
        <c:otherwise>
            <table class="table table-hover">
                <tr>
                    <th>id</th>
                    <th>title</th>
                    <th>release year</th>
                    <th>genre</th>
                </tr>

                <c:forEach var="movie" items="${movie}">
                    <tr>
                        <td><a href="/movie/id/=${movie.id}">${movie.id}</a></td>
                        <td><a href="/movie/id/=${movie.id}">${movie.title}</a></td>
                        <td><a href="/movie/id/=${movie.id}">${movie.yearReleased}</a></td>
                        <td><a href="/movie/id/=${movie.id}">${movie.genre}</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>

    <a href="/form" class="btn btn-primary">Add a movie</a>
    <a href="/hello" class="btn btn-default">Take me all the way home</a>
</div>
</body>
</html>