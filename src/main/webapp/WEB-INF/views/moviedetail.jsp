
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

    <title>Movie in Detail</title>
</head>


<body>
<div class="container">
     <h1>  ${movie.title} </h1>
    <h6>length: ${movie.length}  genre: ${movie.genre}</h6>

    <h4>Summary:</h4>
    <p> ${movie.summary} </p>
    <img src="${movie.coverImageUrl}" alt="cover img"/>
</div>
</body>
</html>
