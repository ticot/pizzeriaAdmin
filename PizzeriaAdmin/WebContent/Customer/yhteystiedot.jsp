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
<jsp:include page="login.jsp"/>
<jsp:include page="register.jsp"/>
	<div id="navigation">
	<ul>
		<li><a href="index.jsp">Etusivu</a></li>
		<li><a href="pizzat">Pizzat</a></li>
		<li class="active"><a href="yhteystiedot.jsp">Yhteystiedot</a></li>
		<li><a href="palaute">Palaute</a></li>
	</ul>

	<jsp:include page="navigation.jsp" />
	
	</div>


	<div id="center">
		<div class="menu"></div>

		</textarea>

		<div class="content">
			<div class="contactwrapper">
				<h1>Yhteystiedot</h1>
				<p>Meidät löydät osoitteesta Raivolankatu 666. Omenapuun jälkeen
					vasemmalle ja Linnan vierestä oikella.Meidät löydät osoitteesta
					Raivolankatu 666. Omenapuun jälkeen vasemmalle ja Linnan vierestä
					oikella.Meidät löydät osoitteesta Raivolankatu 666. Omenapuun
					jälkeen vasemmalle ja Linnan vierestä oikella.</p>
				<p>Meidät löydät osoitteesta Raivolankatu 666. Omenapuun jälkeen
					vasemmalle ja Linnan vierestä oikella.</p>
				<br>
				<p>Lämpimästi tervetuloa!</p>
				<iframe
					src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d7310.432972733255!2d29.80535900046709!3d62.73748848654653!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x469c7ed0b92b17e3%3A0xa0146d8a395ed80!2s80790+Kontioranta!5e0!3m2!1sfi!2sfi!4v1412670547722"
					width="600" height="450" frameborder="0" style="border: 0"></iframe>
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
