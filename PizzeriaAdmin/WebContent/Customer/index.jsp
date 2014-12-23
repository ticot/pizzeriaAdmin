<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
   
Sivusto on jaettu admin-puolen näkymään ja asiakkaan puolen näkymään. 

Admin-puoli löytyy suoraan WebContent-hakemistosta ja kaikki asiakas-puolen sivut 
ovat "Customer"-hakemiston juuressa. Varsinaisia sivuja admin-puolella ovat:
-index.jsp 	-etusivu, lyhyesti keskellä sivua kerrotaan yrityksestä, ylhäältä löytyy navigointipalkki ja kirjautumisnappulat
-pizzat.jsp	-tällä sivulla listataan kaikki valikoimasta tilattavissa olevat tuotteet
-yhteystiedot - yrityksen kivijalkaliikkeen osoite (ei oikea)
-palaute - Sivu, jolla käyttäjä voi jättää palautetta sähköpostilla ja otsikolla varustettuna.
-shoppincart.jsp - ostoskori-sivu, missä käyttäjän valitsemat tuotteet näytetään
-Order.jsp - Tilauksen varmistus. 

Hakemistosta löytyy myös .jsp-sivuja joita sisällytetään edellämainittuihin sivuihin jsp-include avulla
-currentuser - sivun oikeasta yläreunasta löytyvä palkki joka näyttää kirjautuneen nkäyttäjän sähköpostin ja antaa mahdollisuuden kirjautua ulos
-logout - sivu jonka kautta käyttäjä ohjataan, kun kirjaudutaan ulos. Muuten tyhjä, servletti käyttää get-metodia.
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
	<!-- Katso login.jsp ja register.jsp -->
	<jsp:include page="register.jsp" />
	<div id="navigation">

		<ul>
			<li class="active"><a href="index.jsp">Etusivu</a></li>
			<!-- Yläpalkin navidgointinappulat -->
			<li><a href="pizzat">Pizzat</a></li>
			<li><a href="yhteystiedot.jsp">Yhteystiedot</a></li>
			<li><a href="palaute">Palaute</a></li>
		</ul>

		<jsp:include page="navigation.jsp" />
		
		<!-- "kirjudu|rekisteröidy" napit. Katso navigation.jsp -->

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
			<!-- Sivun keskeltä löytyvä leipäteksti-->
			<p>Kaupungin vanhin pizzeria, Melo e Castello, on perheyritys, joka
				avasi ovensa ensimmäisen kerran vuoden 1981 lopulla Asemakadulla.
				Pian tämän jälkeen siirryttiin Raivolankadun tiloihin, joissa ollaan
				oltu jo melkein 30 vuotta. Aivan Joensuun pohjoisosassa sijaitsevassa Melo e
				Castellossa on aitoa italialaista tunnelmaa ja ystävällinen
				ilmapiiri.Ruokalistamme perustana ovat ensiluokkaiset raaka-aineet,
				joista ei tingitä. Pizzan herkullisuuden salaisuus piileekin
				alkuperäisessä reseptissä, jonka opimme Melo e Castellon perustajalta,
				italialaiselta, Giovanni Castellolta. Olemme halunneet pitää perinteistä
				kiinni ja keskittyneet vain siihen, mitä osaamme parhaiten, eli
				pizzaan.Vuonna 2007 Melo e Castello sai uuden ilmeen sisustuksen ja
				ruokalistan uusimisen myötä. Saimme myös kabinetin, jonne mahtuu 10
				-12 henkilöä ruokailemaan. Vuonna 2010 päivitettiin ruokalistaa ja
				sisustusta uudemman kerran. Listalta löytyy nyt myös gluteenitonta
				pizzaa.Mielipiteenne on meille tärkeää, joten pyydämme Teitä
				jättämään palautetta Palaute-sivuillemme. Olemme halukkaita kuulemaan
				asiakkaittemme mielipiteen ravintolastamme ja parannuskehotuksia
				toiminnastamme tai ruokalistastamme. Melo e Castellolla ei ole muita
				toimipisteitä eikä sisaryrityksiä.</p>
		</div>
	</div>




	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.js"></script>

</body>
</html>
