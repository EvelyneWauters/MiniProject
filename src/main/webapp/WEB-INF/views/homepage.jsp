
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Homepage Moviedatabase</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css"/>
  <link rel="stylesheet" type="text/css" href="/css/mainstylesheet.css"/>

    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
    <script type="text/javascript" src="jquery.konami.min.js"></script>


</head>

<body class="hollywoodbw">
<div class="container">

    <jsp:include page="navbar.jsp"></jsp:include>

    <br>

    <div class="row">
        <div class="col-sm-3">
            <div class="sidebar-nav">
                <div class="navbar navbar-default" role="navigation">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-navbar-collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <span class="visible-xs navbar-brand">menu</span>
                    </div>
                    <div class="navbar-collapse collapse sidebar-navbar-collapse">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="/movie/allsortonrating"><span class="glyphicon glyphicon-film"/> Top movies</a></li>
                            <li><a href="/movie/all">All movies</a></li>
                            <li><a href="/actor/all">All actors</a></li>
                            <li><a href="/movie/form">Add movie</a></li>
                            <li><a href="/user/form">Register!</a></li>

                            <li><a href="#">Reviews <span class="badge">1,118</span></a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div>
            </div>
        </div>
        <div class="col-sm-9 whitebackground">
            <h1>Hello there!</h1>
            <h6><span class="glyphicon glyphicon-fire"/>-- under construction -- under construction --<span class="glyphicon glyphicon-fire"/></h6>
            <p> <span class="glyphicon glyphicon-film"/> Welcome to this brand new movie database</p>
            <span>Movielist</span>
            <a href="/new">see the new website (will be ready after the break)::</a> <br/>
    </div>



    <footer>
        <p>
            © Let's move to Hollywood -- Evelyne 2015
        </p>
    </footer>
</div>
</body>
</html>
