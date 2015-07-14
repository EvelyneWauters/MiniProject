<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="mainstylesheet.css"/>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

    <title>Movie in Detail</title>
</head>


<body>
<div class="container">
    <h1> ${movie.title} </h1>
    <h5>length: ${movie.length} min genre: ${movie.genre}</h5>

    <div class="row">
        <div class="col-md-4">
            <img src="${movie.coverImageUrl}" alt="cover img"/>

            <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal">take a look at the trailer here: </button>
            <!-- Modal -->
            <div class="modal fade" id="myModal" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Trailer: ${movie.title}</h4>
                        </div>
                        <div class="modal-body">
                            <p><iframe width="560" height="315" src="${movie.movieTrailerUrl}"
                                       frameborder="0" allowfullscreen></iframe></p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>

                </div>
            </div>

        </div>

        <div class="col-md-8">

            <h2>Summary: </h2>

            <p>${movie.summary} </p>

            <span><b>director:</b> ${movie.director}</span>

        </div>

    </div>

    <div class="whitebackground">

        <c:choose>
            <c:when test="${empty movie.cast}">
                <p>No actors found :-(</p>
            </c:when>
            <c:otherwise>
                <table class="table table-hover">
                    <tr>
                        <th>Character</th>
                        <th>Actor</th>

                    </tr>

                    <c:forEach var="movieCharacter" items="${movie.cast}">
                        <tr>
                            <td>${movieCharacter.name}</td>
                            <td>${movieCharacter.actor.firstName} ${movieCharacter.actor.lastName}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:otherwise>
        </c:choose>

    </div>





    <hr>
    <footer>
        <p>
            © Evelyne 2015
        </p>
    </footer>

</div>
</body>
</html>
