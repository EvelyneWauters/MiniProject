<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
  <link rel="stylesheet" href="../../../resources/public/mainstylesheet.css"/>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

    <title>Create movie</title>
</head>

<body>
<div class="container">

    <div class="blueskies">
<h1>What have you been watching lately?</h1>



        <h2>add a movie <small>or edit an existing one</small></h2>


        <sf:form commandName="movie" action="/movie/create">


            <div class="form-group">
                <label for="title">title</label>
                <sf:input path="title" class="form-control"/>
                <sf:errors path="title"/>
            </div>

            <div class="form-group">
                <label for="summary">summary</label>
                <textarea class="form-control" rows="5" id="summary"></textarea>
            </div>

            <div class="form-group">
                <label for="length">length</label>
                <sf:input path="length" class="form-control" value="length"/>
            </div>

            <div class="form-group">
                <label for="coverImageUrl">URL poster</label>
                <sf:input path="coverImageUrl" class="form-control"/>
            </div>


            <sf:hidden path="id"/>


            <button type="submit" class="btn btn-success">submit</button>
        </sf:form>
    </div>
</div>
</body>
</html>
