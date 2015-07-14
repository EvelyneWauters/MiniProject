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

  <h1>Who have you been watching lately?</h1>



  <h2>add an actor <small>or edit an existing one</small></h2>


  <sf:form commandName="actor" action="/actor/create">


    <div class="form-group">
      <label for="firstName">first name</label>
      <sf:input path="firstName" class="form-control"/>
      <sf:errors path="firstName"/>
    </div>

    <div class="form-group">
      <label for="lastName">last name</label>
      <sf:input path="lastName" class="form-control"/>
    </div>

    <div class="form-group">
      <label for="bio">biography</label>
      <sf:textarea class="form-control" rows="5" path="bio" ></sf:textarea>
    </div>

    <div class="form-group">
      <label for="gender">gender</label>
      <sf:select path="gender" items="${genders}" cssClass="form-control"/>
    </div>

    <div class="form-group">
      <label for="birthDate">born:</label>
      <sf:input path="birthDate" class="form-control" />
    </div>

    <div class="form-group">
      <label for="cityBornIn">city where she/he was born</label>
      <sf:input path="cityBornIn" class="form-control" />
    </div>

    <div class="form-group">
      <label for="countryBornIn">country where she/he was born</label>
      <sf:input path="countryBornIn" class="form-control" />
    </div>


    <div class="form-group">
      <label for="imageUrl">URL headshot</label>
      <sf:input path="imageUrl" class="form-control"/>
    </div>


    <sf:hidden path="id"/>


    <button type="submit" class="btn btn-success">submit</button>
  </sf:form>
</div>
</body>
</html>
