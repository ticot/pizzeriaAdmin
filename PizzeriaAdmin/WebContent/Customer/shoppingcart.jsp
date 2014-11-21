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
	<jsp:include page="register.jsp" />
	<jsp:include page="login.jsp" />
	<jsp:include page="navigation.jsp" />

	<div id="center">
		<div class="menu"></div>
		<div class="banner2"></div>

		<div class="content">
			<h1>Ostoskori</h1>
			<p>sinulla on x m‰‰r‰ tuotteita ostoskorissa</p>
			<div class="contentwhite">
				<h3>Tuotteet</h3>
				<div class="cartwrap">

					<div class="panel panel-default">
						
						<div class="panel-heading">Pizza  </div>
						
						<div class="panel-body">Herkkusieni, jauheliha</div>
					</div>
				</div>
				<div class="contentlink">
					<h2 >Siirry kassalle</h2>
					<p>Jatka ostosten tekemist‰</p>
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
