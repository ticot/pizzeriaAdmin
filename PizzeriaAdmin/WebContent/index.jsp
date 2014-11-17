<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE>
<html>
<head>
<link href="css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" type="text/css" href="css/ionicons.css">
<link href="img/title.png" rel="shortcut icon" type="image/x-icon" />

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
		       <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		       <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<meta charset="UTF-8">
<title>Melo e Castello</title>
</head>
<body>
	<%
		if (session.getAttribute("currentSessionUser") == null) {
			response.sendRedirect("Customer/index.jsp");

		} else {
	%>
	<div class="topbar">
		<header class="navbar navbar-inverse navbar-fixed-top bs-docs-nav"
			role="banner">

			<nav class="collapse navbar-collapse bs-navbar-collapse"
				role="navigation">
				<a class="navbar-brand" href="#">Melo e Castello Admin</a>
				<ul class="nav navbar-nav" id="loginbtn">

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><span class="step size-21"> <i
								class="icon ion-ios7-bell"></i>
						</span><b class="caret"></b></a>
						<ul class="dropdown-menu dropdown-menu-right">
							<li><a href="#">Ilmoitus</a></li>
							<li><a href="#">Ilmoitus</a></li>
							<li><a href="#">Ilmoitus <span
									class="label label-danger">T�rke�</span></a></li>
							<li><a href="#">Ilmoitus</a></li>


						</ul></li>



					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span>
							John Smith <b class="caret"></b></a>
						<ul class="dropdown-menu dropdown-menu-right">
							<li><a href="#"><span class="glyphicon glyphicon-user"></span>
									Profiili</a></li>
							<li><a href="#"><span class="step size-12"> <i
										class="icon ion-android-settings"></i>
								</span>Asetukset</a></li>
							<li role="presentation" class="divider"></li>
							<li><a href="logout.jsp"><span class="step size-14"> <i
										class="icon ion-log-out"></i>
								</span>Kirjaudu ulos</a></li>
						</ul></li>

				</ul>
			</nav>

		</header>

	</div>
	<!-- Small modal -->


	<div id="centercontent">
		<div class="jumbotron">
			<h1>Tervetuloa</h1>
			<p>T�n��n on kaunis p�iv�!</p>
		</div>
		<div class="row">
			<div class="col-sm-6 col-md-4" id="back">
				<div class="thumbnail" id="color1">
					<img src="img/messages.png" alt="Moi">
					<div class="caption">
						<h3>Palaute</h3>
						<ul>
							<li>object1</li>
							<li>object1</li>
							<li>object1</li>
							<li>object1</li>
						</ul>
						<p>
							<a href="#" class="btn btn-info" role="button" id="btn2">N�yt�
								lis��</a>
						</p>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-6 col-md-4" id="back">
				<div class="thumbnail" id="color2">
					<img src="img/orders.png" alt="Moi">
					<div class="caption">
						<h3>Tilaukset</h3>
						<ul>
							<li>object1</li>
							<li>object1</li>
							<li>object1</li>
							<li>object1</li>
						</ul>
						<p>
							<a href="#" class="btn btn-info" role="button" id="btn3">N�yt�
								lis��</a>
						</p>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-6 col-md-4" id="back">
				<div class="thumbnail" id="color3">
					<img src="img/products.png" alt="Moi">
					<div class="caption">
						<h3>Tuotteet</h3>
						<p>Sinulla x m��r� tuotteita tilattavissa</p>
						<p>
							<a href="#" class="btn btn-info" role="button" id="btn4">N�yt�
								lis��</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="leftnavigation">
		<div id="leftwrap">
			<ul class="nav nav-pills nav-stacked">
				<li class="active"><a href="index.html">Etusivu</a></li>
				<li><a href="list">Tuotteet</a></li>
				<li><a href="user">Lis�� k�ytt�j�</a></li>
				<li><a href="palaute.jsp">Palautteet</a></li>
			</ul>
		</div>
	</div>

	<div class="footer">
		<a href="#"><img id="logo" src="img/tikolicious.png" width="100px"
			height="auto"></a>
	</div>




	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.js"></script>

	<%
		}
	%>
</body>
</html>
