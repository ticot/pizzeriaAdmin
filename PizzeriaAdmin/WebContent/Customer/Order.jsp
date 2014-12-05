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
				<div class="panel panel-default" id="cashpizza">
						<div class="panel-heading">
							Pizza X &#8364;
							
						</div>
						<div class="panel-body">
							Herkkusieni, jauheliha
							
						</div>

					</div>
				
				<h4 class="modal-title" id="myModalLabel">Kirjaudu sis��n</h4>
			
			</div>
			<form action="login" class="form-horizontal" role="form">

				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">E-mail</label>
					<div class="col-sm-10">
						<input type="email" class="form-control" id="inputEmail3" name="email"
							placeholder="E-mail" required="">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">Salasana</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="inputPassword3" name="salasana"
							placeholder="Salasana" required="">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<div class="checkbox" id="rmb">
							<label> <input type="checkbox"> Muista minut
							</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">Kirjaudu
							sis��n</button>
					</div>
				</div>
			</form>
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