<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <!-- Add Bootstrap! -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="mainstylesheet.css"/>

    <title>All comments per movie</title>
</head>
<body>
<div class="container">
  <h1>all comments for</h1>
  <c:choose>
    <c:when test="${comment == null or empty comment}">
      <p>No comments yet :-(</p>
    </c:when>
    <c:otherwise>
      <table class="table table-hover">
        <tr>
          <th>user</th>
          <th>content</th>
          <th>date</th>
        </tr>

        <c:forEach var="comment" items="${comment}">
          <tr>
            <td><a href="/movie/id/${movie.id}">${comment.user.login}</a></td>
            <td><a href="/movie/id/${movie.id}">${comment.content}</a></td>
            <td><a href="/movie/id/${movie.id}">${comment.dateAdded}</a></td>
          </tr>
        </c:forEach>
      </table>
    </c:otherwise>
  </c:choose>

  <a href="/movie/form" class="btn btn-primary">Add a comment</a>
  <a href="/" class="btn btn-default">Take me all the way home</a>


</div>!


</body>
</html>
