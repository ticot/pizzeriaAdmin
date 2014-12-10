<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<link href="css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="style.css">
<link href="img/title.png" rel="shortcut icon" type="image/x-icon" />
<link href='http://fonts.googleapis.com/css?family=Lora:400,400italic' rel='stylesheet' type='text/css'>

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
<jsp:include page="login.jsp"/>		<!-- Katso login.jsp ja register.jsp -->
<jsp:include page="register.jsp"/>
<div id="navigation">

	<ul>
		<li class="active"><a href="index.jsp">Etusivu</a></li>		<!-- Yläpalkin navidgointinappulat -->
		<li><a href="pizzat">Pizzat</a></li>
		<li><a href="yhteystiedot.jsp">Yhteystiedot</a></li>
		<li><a href="palaute">Palaute</a></li>
	</ul>
		
	<jsp:include page="navigation.jsp" /> 	<!-- "kirjudu|rekisteröidy" napit. Katso navigation.jsp -->
	
	</div>
	<div id="center">
		<div class="menu"></div>
		<div class="banner">
			<img src="img/logo.png" class="imglogo"> <!-- Ravintolan logo ja bannerit -->
		</div>
		<div class="ornament">
			<img src="img/hello.png" align="middle">
		</div>
		<div class="content">		<!-- Sivun keskeltä löytyvä leipäteksti, vaatii oikean tekstin -->
			<p>Tämä on täytetekstiä ettei kenellekkään tulisi paha mieli niin
				tässä ei lue mitään tärkeää.Päinvastoin tämä on vain turhaa löpinää,
				jotta tämä div olisi sen näköinen niinkuin asiakas julkaissessaan
				haluaa. Hän päättää mitä kirjoittaa tähän. Ja kehitystiiminä olemme
				vain kirjoitelleet sitä sun tätä. Teksti ei tarkoita mitään ja
				tämäkin lause on vain täyttölause jotta koko kappale näyttäisi
				pidemmältä. Kirjoitin tämän itse enkä kopioinut internetistä.</p>
		</div>
	</div>




	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.js"></script>

</body>
</html>
