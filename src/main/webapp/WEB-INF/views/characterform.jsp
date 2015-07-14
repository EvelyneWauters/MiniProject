<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
  <link rel="stylesheet" href="mainstylesheet.css"/>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

  <style>
    .blueskies{ background-image: url("http://nhtheatreawards.org/Data/Sites/1/aaImages/graphics/Sky%20and%20Clouds/beautiful_sky-dsc01468-dws.jpg");
      background-position: center;
      background-repeat: no-repeat;}
  </style>
  <title>Add actor</title>
</head>

<body class = "blueskies">
<div class="container">

  <h1>Who's your new favorite character?</h1>



  <h2>add a character <small>or edit an existing one</small></h2>


  <sf:form commandName="movieCharacter" action="/character/create">


    <div class="form-group">
      <label for="name"> name</label>
      <sf:input path="name" class="form-control"/>
      <sf:errors path="name"/>
    </div>

    <%--TODO: add actors to a character--%>
    <%--<div class="form-group">--%>
      <%--<label for="actor">ACTOR</label>--%>
      <%--<sf:select path="actor" items="${actors}" cssClass="form-control"/>--%>
    <%--</div>--%>



    <sf:hidden path="id"/>


    <button type="submit" class="btn btn-success">submit</button>
  </sf:form>
</div>
</body>
</html>
