
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
  <link rel="stylesheet" href="mainstylesheet.css"/>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

    <title>Movie in Detail</title>
</head>


<body>
<div class="container">
     <h1>  ${movie.title} </h1>
    <h5>length: ${movie.length}  genre: ${movie.genre}</h5>

    <div class="row">
        <div class="col-md-4">
            <img src="${movie.coverImageUrl}" alt="cover img"/>
            <a class="btn btn-default" role="button" href="#">take a look at the trailer here : </a>

        </div>

        <div class="col-md-8">

            <h2>Summary: </h2>
            <p>${movie.summary} </p>

            <span><b>director:</b> ${movie.director}</span>

        </div>

    </div>
    <hr>

    <c:choose>
        <c:when test="${empty movie.cast}">
            <p>No actors found :-(</p>
        </c:when>
        <c:otherwise>
            <table class="table table-hover">
                <tr>
                    <th>name</th>
                    <th>name</th>

                </tr>

                <c:forEach var="movieCharacter" items="${movie.cast}">
                    <tr>
                        <td>${movieCharacter.name}</td>
                        <td>${movieCharacter.actor.firstName}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>




    <video width="320" height="240" controls="controls">
        <source src="${movie.movieTrailerUrl}"/>
    </video>

    <iframe width="560" height="315" src="${movie.movieTrailerUrl}"
            frameborder="0" allowfullscreen></iframe>

    <footer>
        <p>
            © Evelyne 2015
        </p>
    </footer>

</div>
</body>
</html>
