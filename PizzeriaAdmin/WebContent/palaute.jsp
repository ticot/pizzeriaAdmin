<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

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
	<div class="topbar">
		<header class="navbar navbar-inverse navbar-fixed-top bs-docs-nav"
			role="banner"> <nav
			class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
		<a class="navbar-brand" href="#">Melo e Castello Admin</a>
		<ul class="nav navbar-nav" id="loginbtn">

			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown"><span class="step size-21"> <i
						class="icon ion-ios7-bell"></i>
				</span><b class="caret"></b></a>
				<ul class="dropdown-menu dropdown-menu-right">
					<li><a href="#">Ilmoitus</a></li>
					<li><a href="#">Ilmoitus</a></li>
					<li><a href="#">Ilmoitus <span class="label label-danger">Tärkeä</span></a></li>
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
					<li><a href="#"><span class="step size-14"> <i
								class="icon ion-log-out"></i>
						</span>Kirjaudu ulos</a></li>
				</ul></li>

		</ul>
		</nav> </header>

	</div>
	<!-- Small modal -->


	<div id="centercontent">
		<div class="jumbotron">
			<h1>Palautteet</h1>
			<p>Sinulla on X määrä saapuneita palautteita</p>
			<p>
			
					<button class="btn btn-primary btn-lg" onclick="myFunction()">Päivitä sivu</button>
					
					<script>
function myFunction() {
    location.reload();
}
</script>
			</p>
		</div>
		<c:forEach items="${palautteet}" var="i">


			<div class="panel panel-primary">
				<div class="panel-heading">
					<c:out value="${i.id}" />
					.&nbsp;
					<c:out value="${i.otsikko}" />
					&nbsp; &nbsp;Lähettänyt:&nbsp;
					<c:out value="${i.nimi}" />
				</div>
				<div class="panel-body">
					
					<p class="collapse" id="viewdetails<c:out value="${i.id}" />"><c:out value="${i.sisalto}" /></p>
					<p>
						<a class="specialbtn" data-toggle="collapse"
							data-target="#viewdetails<c:out value="${i.id}" />">Palautteen sisältö
							&raquo;</a>
					</p>
				</div>
			</div>
		</c:forEach>
	</div>
	<div class="leftnavigation">
		<div id="leftwrap">
			<ul class="nav nav-pills nav-stacked">
				<li><a href="index.html">Etusivu</a></li>
				<li><a href="list">Tuotteet</a></li>
				<li><a href="user">Lisää käyttäjä</a></li>
				<li class="active"><a href="palaute.jsp">Palautteet</a></li>
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

</body>
</html>
