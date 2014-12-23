<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- 
████████╗██╗ ██████╗ ██████╗ ██╗     ██╗ ██████╗██╗ ██████╗ ██╗   ██╗███████╗
╚══██╔══╝██║██╔════╝██╔═══██╗██║     ██║██╔════╝██║██╔═══██╗██║   ██║██╔════╝
   ██║   ██║██║     ██║   ██║██║     ██║██║     ██║██║   ██║██║   ██║███████╗
   ██║   ██║██║     ██║   ██║██║     ██║██║     ██║██║   ██║██║   ██║╚════██║
   ██║   ██║╚██████╗╚██████╔╝███████╗██║╚██████╗██║╚██████╔╝╚██████╔╝███████║
   ╚═╝   ╚═╝ ╚═════╝ ╚═════╝ ╚══════╝╚═╝ ╚═════╝╚═╝ ╚═════╝  ╚═════╝ ╚══════╝
   Antti Eloranta, Heini Haatanen, Tanja Partanen, Péter Takács, Samu Tapanen
   2014

Tilaussivulla listataan tilaukset. Aika simppeliä.

Katso pohjaan kuuluvat kommentit index.jsp
    --> 
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
	<%
		if (session.getAttribute("currentSessionUser") == null) {
			response.sendRedirect("Customer/index.jsp");

		}
	%>
	<div class="topbar">
		<header class="navbar navbar-inverse navbar-fixed-top bs-docs-nav"
			role="banner"> <nav
			class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
		<a class="navbar-brand" href="#">Melo e Castello Admin</a> <jsp:include
			page="currentuser.jsp" /> </nav> </header>

	</div>
	<!-- Small modal -->


	<div id="centercontent">
		<div class="jumbotron">
			<h1>Tilaukset</h1>
			<p>
				Sinulla on yhteensä
				<c:out value="${yht}" />
				saapunutta palautetta
			</p>
			<p>

				<button class="btn btn-primary btn-lg" onclick="refresh()">Päivitä
					sivu</button>

				<script>
					function refresh() {
						location.reload();
					}
				</script>
			</p>
		</div>
		<c:forEach items="${tilaukset}" var="i"><!-- Listataan palautteet -->


			<div class="panel panel-primary"> <!-- Jos käyttäjä klikkasi etusivulta löytyvää jotain palautetta, niin korostetaan klikatun palautteen otsikko ja avataan se --> 
				<c:set var="h" value="${highlight}" />
				<c:choose>
					<c:when test="${i.id == h}">
						<div class="panel-heading">
							<a data-toggle="collapse"
								data-target=".panel-body<c:out value="${i.id}" />"><span
								class="collapsespan">
									<div class="ribbon-wrapper">
										<div class="glow">&nbsp;</div>
										<div class="ribbon-front"></div>

									</div>
							</span></a>
					</c:when>
					<c:otherwise>
						<div class="panel-heading">
							<a data-toggle="collapse"
								data-target=".panel-body<c:out value="${i.id}" />"><span
								class="collapsespan"> </span></a>
					</c:otherwise>
				</c:choose>



				<a name="palaute<c:out value="${i.id}" />"></a>
				<c:out value="${i.id}" />
				.&nbsp;
				<c:out value="${i.otsikko}" />


			</div>
			<!-- 
				<div class="panel-body<c:out value="${i.id}" /> collapse">
 -->
			<c:choose>
				<c:when test="${i.id == h}">
					<div class="panel-body<c:out value="${i.id}" /> collapse in">
						<c:out value="${i.sisalto}" />
				</c:when>
				<c:otherwise>
					<div class="panel-body<c:out value="${i.id}" /> collapse">
						<c:out value="${i.sisalto}" />
				</c:otherwise>
			</c:choose>


			<br>
			<br>
					Lähettäjä:<c:out value="${i.nimi}" />
			<br>
					Sähköposti:<c:out value="${i.email}" />

			</p>


			<!-- 
							<p>
						<a class="specialbtn" data-toggle="collapse"
							data-target="#viewdetails<c:out value="${i.id}" />">
							Palautteen sisältö&raquo;</a>
					</p>
					 -->
	</div>
	</div>
	</c:forEach>
	</div>
	<div class="leftnavigation">
		<div id="leftwrap">
			<ul class="nav nav-pills nav-stacked">
				<li><a href="index">Etusivu</a></li>
				<li><a href="list">Tuotteet</a></li>
				<li><a href="user">Käyttäjät</a></li>
				<li><a href="sisalto">Aineosat</a></li>
				<li class="active"><a href="palaute">Palautteet</a></li>
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
