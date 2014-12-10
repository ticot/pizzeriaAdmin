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
<!--  pohjan kommentit index.jsp -->
</head>
<body>
	<jsp:include page="login.jsp" />
	<jsp:include page="register.jsp" />
	<div id="navigation">
		<ul>
			<li><a href="index.jsp">Etusivu</a></li>
			<li><a href="pizzat">Pizzat</a></li>
			<li><a href="yhteystiedot.jsp">Yhteystiedot</a></li>
			<li class="active"><a href="palaute">Palaute</a></li>
		</ul>
		
		<jsp:include page="navigation.jsp" />
		<a href="shoppingcart.jsp"><img src="img/shopping.png" width="35"
			height="30" id="cartimg"></a>

	</div>

	<div id="center">
		<div class="menu"></div>


		<div class="content">
			<h1 class="feedback">Anna Palautetta</h1>
			<div class="mvm">
				<form class="form-horizontal" name="input" action="palaute"
					method="POST">
					<!-- Palautelomake fi/omapizzeria/admin/controller/PalauteServletAdmin.java -->
					<input type="text" class="form-control" placeholder="Nimi"
						id="name" name="nimi" required=""> <input type="text"
						class="form-control" placeholder="Sähköposti" id="name"
						name="email"> <input type="text" class="form-control"
						placeholder="Otsikko" id="name" name="otsikko" required="">
			</div>
			<textarea class="form-control" rows="1" id="textarea" name="palaute"
				required="">
			
				</textarea>
			<p class="infofield">Sähköposti- tai nimikentät eivät ole pakollisia.
				Laita sähköpostiosoitteesi vain, jos haluat
				meiltä vastauksen palautteestasi tai hyvityksen. Muussa tapauksessa
				voit jättää kentät tyhjiksi ja palautteesi tulee meille nimettömänä
				Arvostamme kaikkea meille saapuvaa palautetta!</p>
			<button type="submit" class="btn btn-primary">Lähetä</button>
			</form>
		</div>


	</div>




	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.js"></script>

</body>
</html>
