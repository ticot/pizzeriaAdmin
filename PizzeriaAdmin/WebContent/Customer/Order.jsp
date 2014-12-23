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
   
   Order.jsp on sivu, jossa varmistetaan käyttäjän tilaus. Käyttäjä voi kirjautua sisään täyttääkseen kentät tai sitten täyttää ne käsin.
   
   katso pohjan kommentit index.jsp
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
			<div id="cash">
				<h2>Vahvista tilauksesi</h2>
				
				<div class="pricepanel">
				<c:forEach items="${ostosKoriLista}" var="okl">		<!--Listataan käyttäjän ostoskoriin lisäämät tuotteet tähän mennessä. -->

			
					<h4><c:out value="${okl.tuote_nimi}" />, <c:out value="${okl.glu}" />, <c:out value="${okl.lakt}" />, <c:out value="${okl.hinta}" /><br></h4>
					</c:forEach>
					<br>
					<h4>Hinta yhteensä: <c:out value="${yht}"/> &#8364;</h4>
					<br><br>
				</div>
				
			</div>
			  
			 <div id="formwrapper">
			 	
			 	<form class="form-horizontal" action="order" method="post" >
			 	
<fieldset>


<h3>Yhteystiedot</h3>

<!-- Tilaajan yhteystiedot-->


<div class="control-group">
  <label class="control-label" for="Etunimi"><h5>Etunimi</h5></label>
  <div class="controls">
    <input value="<c:out value="${currentSessionUser.etunimi}" />" id="Etunimi" name="Etunimi" placeholder="" class="input-medium" required="" type="text" autofocus>
    
  </div>
</div>


<div class="control-group">
  <label class="control-label" for="Sukunimi"><h5>Sukunimi</h5></label>
  <div class="controls">
    <input value="<c:out value="${currentSessionUser.sukunimi}" />" id="Sukunimi" name="Sukunimi" placeholder="" class="input-medium" required="" type="text">
    
  </div>
</div>

<div class="control-group">
  <label class="control-label" for="Osoite"><h5>Osoite</h5></label>
  <div class="controls">
    <input value="<c:out value="${currentSessionUser.katuosoite}" />" id="Osoite" name="Osoite" placeholder="" class="input-medium" required="" type="text">
    
  </div>
</div>

<div class="control-group">
  <label class="control-label" for="Postinro"><h5>Postinro</h5></label>
  <div class="controls">
    <input value="<c:out value="${currentSessionUser.postinumero}" />" id="Postinro" name="Postinro" placeholder="" class="input-medium" required="" type="text">
    
  </div>
</div>

<div class="control-group">
  <label class="control-label" for="Postitoimipaikka"><h5>Postitoimipaikka</h5></label>
  <div class="controls">
    <input value="<c:out value="${currentSessionUser.postitoimipaikka}" />" id="Postitoimipaikka" name="Postitoimipaikka" placeholder="" class="input-medium" required="" type="text">
    
  </div>
</div>


<div class="control-group">
  <label class="control-label" for="Puhelin.nro"><h5>Puhelin.nro</h5></label>
  <div class="controls">
    <input value="<c:out value="${currentSessionUser.puhelinnumero}" />" id="Puhelinnro" name="Puhelinnro" placeholder="" class="input-medium" type="text">
    <input value="<c:out value="${currentSessionUser.id}" />" id="kayttaja_id"  name="kayttaja_id" placeholder="" class="input-medium" type="hidden">
    
  </div>
</div>

<div class="control-group">
  <label class="control-label" for="toimitustapa">Toimitustapa</label>
  <div class="controls">
    <label class="radio" for="toimitustapa-0">
      <input type="radio" name="toimitustapa" id="toimitustapa-0" value="Nouto" checked="checked">
      Nouto
    </label>
    <label class="radio" for="toimitustapa-1">
      <input type="radio" name="toimitustapa" id="toimitustapa-1" value="Toimitus">
      Toimitus
    </label>
  </div>
</div>

<div class="control-group">
  <label class="control-label" for="maksutapa">Maksutapa</label>
  <div class="controls">
    <label class="radio" for="maksutapa-0">
      <input type="radio" name="maksutapa" id="maksutapa-0" value="Kateinen" checked="checked">
      Käteinen
    </label>
    <label class="radio" for="maksutapa-1">
      <input type="radio" name="maksutapa" id="maksutapa-1" value="Paypal">
      Paypal
    </label>
    <label class="radio" for="maksutapa-2">
      <input type="radio" name="maksutapa" id="maksutapa-2" value="Luottokortti">
      Luottokortti
    </label>
  </div>
</div>
	
</fieldset>
<button type="submit" class="btn btn-success" id="confirmation" >Vahvista tilaus</button>
</form>
<%
		
		if (session.getAttribute("currentSessionUser") == null) {		/* tarkistetaan onko käyttäjä kirjautunut sisään */
		

%>
				<div id="infotext">			<!-- Jos ei, näytetään nappula josta voi kirjautua sisään ja täyttää kentät automaattisesti. -->
				<button class="btn btn-primary" data-toggle="modal"
		data-target=".bs-example-modal-sm" data-keyboard="true" id="sign">Kirjaudu sisään</button>
				<p>Kirjautumalla sisään<br>
				 lomake hakee tietosi, jotka olet tallentanut kirjautuessasi ja täyttää ne automaattisesti.<br><br>
				Jos sinulla ei vielä ole tiliä Melo e Castelloon, voit rekisteröityä kohdasta rekisteröidy, sivun ylälaidassa.
				Rekisteröinminen on maksutonta eikä Melo e Castello oy myy asiakkaan tietoja mainostajille</p> </div>
				<%		} 
		 %>
			 	
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
