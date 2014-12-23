<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE>
<!-- 
████████╗██╗ ██████╗ ██████╗ ██╗     ██╗ ██████╗██╗ ██████╗ ██╗   ██╗███████╗
╚══██╔══╝██║██╔════╝██╔═══██╗██║     ██║██╔════╝██║██╔═══██╗██║   ██║██╔════╝
   ██║   ██║██║     ██║   ██║██║     ██║██║     ██║██║   ██║██║   ██║███████╗
   ██║   ██║██║     ██║   ██║██║     ██║██║     ██║██║   ██║██║   ██║╚════██║
   ██║   ██║╚██████╗╚██████╔╝███████╗██║╚██████╗██║╚██████╔╝╚██████╔╝███████║
   ╚═╝   ╚═╝ ╚═════╝ ╚═════╝ ╚══════╝╚═╝ ╚═════╝╚═╝ ╚═════╝  ╚═════╝ ╚══════╝
   Antti Eloranta, Heini Haatanen, Tanja Partanen, Péter Takács, Samu Tapanen
   2014
   
Sivusto on jaettu admin-puolen näkymään ja asiakkaan puolen näkymään. 

Asiakaspuoli kokonaisuudessaan löytyy "Customer"-hakemistosta ja kaikki admin-puolen sivut 
ovat "WebContent"-hakemiston juuressa. Varsinaisia sivuja admin-puolella ovat:
-index.jsp 	-etusivu, lyhyesti keskellä sivua listataan palautteet, tuotteet, ja tilaukset
-list.jsp	-tuotteiden lisäämistä varten tehty sivu. Lisäysominaisuuden lisäksi myös olemassa olevien pizzojen muokkaus.
-sisalto.jsp	-tuotteiden sisältöjen lisäystä ja poistoa varten. Kyseisellä sivulla myös listataan kaikki sisällöt.
-tilaukset.jsp	-tehdyt tilaukset, mahdollisuus suorittaa tilaus loppuun tai perua
-user.jsp		-käyttäjän lisäys sivustolle. Myös listattu olemassaolevat käyttäjät.

Hakemistosta löytyy myös .jsp-sivuja joita sisällytetään edellämainittuihin sivuihin jsp-includen avulla
-currentuser - sivun oikeasta yläreunasta löytyvä palkki joka näyttää kirjautuneen nkäyttäjän sähköpostin ja antaa mahdollisuuden kirjautua ulos
-logout - sivu jonka kautta käyttäjä ohjataan, kun kirjaudutaan ulos. Muuten tyhjä, servletti käyttää get-metodia.
 -->
<html>
<head>
<link href="css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" type="text/css" href="css/ionicons.css">
<link href="img/title.png" rel="shortcut icon" type="image/x-icon" />

<!--[if lt IE 9]>
		       <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		       <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<meta charset="UTF-8">
<title>Melo e Castello</title>
</head>
<body>
	<%
		if (session.getAttribute("currentSessionUser") == null) { /* tarkistetaan onko käyttäjä kirjautunut sisään */
			response.sendRedirect("Customer/index.jsp");

		}
	%>

	<div class="topbar">
		<header class="navbar navbar-inverse navbar-fixed-top bs-docs-nav"
			role="banner">

			<nav class="collapse navbar-collapse bs-navbar-collapse"
				role="navigation">
				<a class="navbar-brand" href="#">Melo e Castello Admin</a>
				<jsp:include page="currentuser.jsp" />
				<!-- kirjautuneen käyttäjän tiedot katso currentuser.jsp-->
			</nav>

		</header>

	</div>
	<!-- Small modal -->


	<div id="centercontent">
		<div class="jumbotron">
			<h1>Tervetuloa</h1>
			<p>Tänään on kaunis päivä!</p>
		</div>
		<div class="row">
			<div class="col-sm-6 col-md-4" id="back">
				<div class="thumbnail" id="color1">
					<img src="img/messages.png" alt="Moi">
					<div class="caption">
						<h3>Palaute</h3>
						<ul>
						<!-- Kaikki " tagin takaa löytyvät palautteet, tuotteet ja tilaukset tällä sivulla
						 ovat kotoisin src.fi.omapizzeria.admin.controller.Adminservlet.java -->
<!-- Listataan palautteet -->
							<c:forEach items="${palautteet}" var="i">
								
								<li><a href="palaute?id=<c:out value="${i.id}"/>"><c:out
											value="${i.otsikko}" /></a></li>
							</c:forEach>
						</ul>

						<p>
							<a href="palaute" class="btn btn-info" role="button" id="btn2">Näytä
								lisää</a>
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
						<ul><!-- Listataan tilaukset -->
							<c:forEach items="${tilaukset}" var="t">
								
								<li><a href="palaute?id=<c:out value="${t.tilaus_id}"/>"><c:out
											value="${t.tilaus_pvm}" /></a></li>
							</c:forEach>
						</ul>
						<p>
							<a href="#" class="btn btn-info" role="button" id="btn3">Näytä
								lisää</a>
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
						<!--  listataan tuotteet -->
						<p>
							Sinulla
							<c:out value="${yht}"></c:out>
							tuotetta tilattavissa
						</p>
						<p>
							<a href="#" class="btn btn-info" role="button" id="btn4">Näytä
								lisää</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="leftnavigation">
		<!-- Vasemmalta puolelta sivua löytyvä navigointi -->
		<div id="leftwrap">
			<ul class="nav nav-pills nav-stacked">
				<li class="active"><a href="index">Etusivu</a></li>
				<li><a href="list">Tuotteet</a></li>
				<li><a href="user">Käyttäjät</a></li>
				<li><a href="sisalto">Aineosat</a></li>
				<li><a href="palaute">Palautteet</a></li>
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
