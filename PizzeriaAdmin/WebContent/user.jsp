<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<link href="css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" type="text/css" href="css/ionicons.css">
<link href="img/title.png" rel="shortcut icon" type="image/x-icon" />

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
	<div class="topbar">
		<header class="navbar navbar-inverse navbar-fixed-top bs-docs-nav"
			role="banner">

			<nav class="collapse navbar-collapse bs-navbar-collapse"
				role="navigation">
				<a class="navbar-brand" href="#">Melo e Castello Admin</a>
				<ul class="nav navbar-nav" id="loginbtn">

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><span class="step size-21"> <i
								class="icon ion-ios7-bell"></i>
						</span><b class="caret"></b></a>
						<ul class="dropdown-menu dropdown-menu-right">
							<li><a href="#">Ilmoitus</a></li>
							<li><a href="#">Ilmoitus</a></li>
							<li><a href="#">Ilmoitus <span
									class="label label-danger">T‰rke‰</span></a></li>
							<li><a href="#">Ilmoitus</a></li>


						</ul></li>



					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span>
							John Smith <b class="caret"></b></a>
						<ul class="dropdown-menu dropdown-menu-right">
							<li><a href="#"><span class="glyphicon glyphicon-user"></span>
									Profiili</a></li>
							<li><a href="#"><span class="step size-12"> <i
										class="icon ion-android-settings"></i>
								</span>Asetukset</a></li>
							<li role="presentation" class="divider"></li>
							<li><a href="#"><span class="step size-14"> <i
										class="icon ion-log-out"></i>
								</span>Kirjaudu ulos</a></li>
						</ul></li>

				</ul>
			</nav>

		</header>

	</div>
	<!-- Small modal -->


	<div id="centercontent">
		<div class="jumbotron">
			<h1>Lis‰‰ k‰ytt‰j‰</h1>
			<p>T‰n‰‰n on kaunis p‰iv‰!</p>
		</div>



		<form class="form-horizontal" name="input" action="user" method="POST">
			<fieldset>

				<!-- Form Name -->
				<legend>Lis‰‰ uusi k‰ytt‰j‰</legend>

				<!-- Email input -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="email">E-mail</label>
					<div class="col-md-4">
						<input id="email" name="email" placeholder="E-mail"
							class="form-control input-md" required="" type="text" required="">

					</div>
				</div>

				<!-- Password input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="salasana">Salasana</label>
					<div class="col-md-4">
						<input id="salasana" name="salasana" placeholder="Salasana"
							class="form-control input-md" required="" type="password" required="">

					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label" for="salasana">Salasana uudelleen</label>
					<div class="col-md-4">
						<input id="salasana2" name="salasana2" placeholder="Salasana uudelleen"
							class="form-control input-md" required="" type="password" required="">

					</div>
				</div>
				
				<!-- User level input -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="userlevel">K‰ytt‰j‰taso</label>
					<div class="col-md-4">
						<select id="level" name="level" placeholder="Level">
							<option value="0">0 - Ei m‰‰ritelty.</option>
							<option value="1">1 - Yll‰pito.</option>
							<option value="2">2 - Perusk‰ytt‰j‰.</option>
						</select>

					</div>
				</div>

				<button type="submit" class="btn btn-primary" id="ybtn"
					value="Submit">Lis‰‰ K‰ytt‰j‰</button>
				<button type="button" data-dismiss="modal" class="btn btn-default"
					id="nbtn">Peruuta</button>

			</fieldset>
		</form>

	</div>
	<div class="leftnavigation">
		<div id="leftwrap">
			<ul class="nav nav-pills nav-stacked">
				<li ><a href="index.html">Etusivu</a></li>
				<li><a href="list">Tuotteet</a></li>
				<li class="active"><a href="user">Lis‰‰ k‰ytt‰j‰</a></li>
				<li><a href="palaute.jsp">Palautteet</a></li>
			</ul>
		</div>
	</div>

	<div class="footer">
		<a href="#"><img src="img/ico_tico.png"></a>
	</div>




	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.js"></script>

</body>
</html>
