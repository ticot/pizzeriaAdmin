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
		<li class="active"><a href="index.jsp">Etusivu</a></li>		<!-- Yl�palkin navidgointinappulat -->
		<li><a href="pizzat">Pizzat</a></li>
		<li><a href="yhteystiedot.jsp">Yhteystiedot</a></li>
		<li><a href="palaute">Palaute</a></li>
	</ul>
		
	<jsp:include page="navigation.jsp" /> 	<!-- "kirjudu|rekister�idy" napit. Katso navigation.jsp -->
	
	</div>
	<div id="center">
		<div class="menu"></div>
		<div class="banner">
			<img src="img/logo.png" class="imglogo"> <!-- Ravintolan logo ja bannerit -->
		</div>
		<div class="ornament">
			<img src="img/hello.png" align="middle">
		</div>
		<div class="content">		<!-- Sivun keskelt� l�ytyv� leip�teksti, vaatii oikean tekstin -->
			<p>T�m� on t�yteteksti� ettei kenellekk��n tulisi paha mieli niin
				t�ss� ei lue mit��n t�rke��.P�invastoin t�m� on vain turhaa l�pin��,
				jotta t�m� div olisi sen n�k�inen niinkuin asiakas julkaissessaan
				haluaa. H�n p��tt�� mit� kirjoittaa t�h�n. Ja kehitystiimin� olemme
				vain kirjoitelleet sit� sun t�t�. Teksti ei tarkoita mit��n ja
				t�m�kin lause on vain t�ytt�lause jotta koko kappale n�ytt�isi
				pidemm�lt�. Kirjoitin t�m�n itse enk� kopioinut internetist�.</p>
		</div>
	</div>




	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.js"></script>

</body>
</html>
