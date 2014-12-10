<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
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
	<!-- Katso login.jsp ja register.jsp -->
	<jsp:include page="register.jsp" />
	<div id="navigation">

		<ul>
			<li class="active"><a href="index.jsp">Etusivu</a></li>
			<!-- Yl�palkin navidgointinappulat -->
			<li><a href="pizzat">Pizzat</a></li>
			<li><a href="yhteystiedot.jsp">Yhteystiedot</a></li>
			<li><a href="palaute">Palaute</a></li>
		</ul>

		<jsp:include page="navigation.jsp" />
		<a href="shoppingcart.jsp"><img src="img/shopping.png" width="35"
			height="30" id="cartimg"></a>
		<!-- "kirjudu|rekister�idy" napit. Katso navigation.jsp -->

	</div>
	<div id="center">
		<div class="menu"></div>
		<div class="banner">
			<img src="img/logo.png" class="imglogo">
			<!-- Ravintolan logo ja bannerit -->
		</div>
		<div class="ornament">
			<img src="img/hello.png" align="middle">
		</div>
		<div class="content">
			<!-- Sivun keskelt� l�ytyv� leip�teksti, vaatii oikean tekstin -->
			<p>Kaupungin vanhin pizzeria, Melo e Castello, on perheyritys, joka
				avasi ovensa ensimm�isen kerran vuoden 1981 lopulla Asemakadulla.
				Pian t�m�n j�lkeen siirryttiin Raivolankadun tiloihin, joissa ollaan
				oltu jo melkein 30 vuotta. Aivan Joensuun pohjoisosassa sijaitsevassa Melo e
				Castellossa on aitoa italialaista tunnelmaa ja yst�v�llinen
				ilmapiiri.Ruokalistamme perustana ovat ensiluokkaiset raaka-aineet,
				joista ei tingit�. Pizzan herkullisuuden salaisuus piileekin
				alkuper�isess� reseptiss�, jonka opimme Melo e Castellon perustajalta,
				italialaiselta, Giovanni Castellolta. Olemme halunneet pit�� perinteist�
				kiinni ja keskittyneet vain siihen, mit� osaamme parhaiten, eli
				pizzaan.Vuonna 2007 Melo e Castello sai uuden ilmeen sisustuksen ja
				ruokalistan uusimisen my�t�. Saimme my�s kabinetin, jonne mahtuu 10
				-12 henkil�� ruokailemaan. Vuonna 2010 p�ivitettiin ruokalistaa ja
				sisustusta uudemman kerran. Listalta l�ytyy nyt my�s gluteenitonta
				pizzaa.Mielipiteenne on meille t�rke��, joten pyyd�mme Teit�
				j�tt�m��n palautetta Palaute-sivuillemme. Olemme halukkaita kuulemaan
				asiakkaittemme mielipiteen ravintolastamme ja parannuskehotuksia
				toiminnastamme tai ruokalistastamme. Melo e Castellolla ei ole muita
				toimipisteit� eik� sisaryrityksi�.</p>
		</div>
	</div>




	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.js"></script>

</body>
</html>
