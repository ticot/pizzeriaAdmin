<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
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
   
 Ostoskorin sisältöä voi tarkastella tällä sivulla. Myös tuotteiden poistaminen tapahtuu täällä.
   
   pohjan kommentit index.jsp
   -->
<head>
<link href="css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="style.css">
<link href="img/title.png" rel="shortcut icon" type="image/x-icon" />
<link href='http://fonts.googleapis.com/css?family=Lora:400,400italic'
	rel='stylesheet' type='text/css'>

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
	<jsp:include page="login.jsp" />
	<jsp:include page="register.jsp" />
	<div id="navigation">

		<ul>
			<li><a href="index.jsp">Etusivu</a></li>
			<li><a href="pizzat">Pizzat</a></li>
			<li><a href="yhteystiedot.jsp">Yhteystiedot</a></li>
			<li><a href="palaute">Palaute</a></li>
		</ul>
		<jsp:include page="navigation.jsp" />


	</div>

	<div id="center">
		<div class="menu"></div>
		<div class="banner2"></div>

		<div class="content">

			

			<h1 class="cent">Ostoskori</h1>
			<p class="cent">Sinulla on <c:out value="${tyht}" /> kpl tuotteita ostoskorissa!</p>
			<div class="contentwhite">
				<h3>Tuotteet</h3>
				<div class="cartwrap">
					<!-- Listataan tuotteet -->
					<c:forEach items="${ostosKoriLista}" var="okl">
						<div class="panel panel-default">
							<div class="panel-heading">
								<c:out value="${okl.tuote_nimi}" />
								<c:out value="${okl.hinta}" />
								&#8364;
								<form name="input" action="ostoskori?id=<c:out value="${okl.tuote_id}"/>&action=1"
									method="POST">
									<button type="submit" class="glyphicon glyphicon-remove"
										style="float: right;"/>
								</form>

							</div>
							<div class="panel-body">
								Gluteeniton:
								<c:out value="${okl.glu}" />
								Laktoositon:
								<c:out value="${okl.lakt}" />

							</div>

						</div>
					</c:forEach>
				</div>
				<div class="contentlink">
					<h2>Ostosten hinta <c:out value="${yht}"/>  &#8364;</h2>	<!-- Lopuksi vielä näytetään paljon tuotteet maksoi yhteensä. -->

					<a href="Order.jsp"><button type="button"
							class="btn btn-default" id="cashout">Kassalle</button></a>
				</div>
			</div>

		</div>
	</div>




	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.js"></script>
</body>
</html>
