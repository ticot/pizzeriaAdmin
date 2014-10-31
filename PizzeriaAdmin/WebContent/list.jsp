<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
		<
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

		<%
			if (request.getParameter("added") != null) {
		%>
		<div class="alert alert-success alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert">
				<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
			</button>
			Pizza lis‰tty!
		</div>

		<%
			}
			if (request.getParameter("poistettu") != null) {
		%>
		<div class="alert alert-info alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert">
				<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
			</button>
			Pizza poistettu!
		</div>
		<%
			}

			if (request.getParameter("muokattu") != null) {
		%>
		<div class="alert alert-info alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert">
				<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
			</button>
			Pizza muokattu!
		</div>
		<%
			}
		%>

		<h1>Tervetuloa</h1>
		<p>
			Hei sinulla on t‰ll‰ hetkell‰
			<c:out value="${yht}" />
			tuottetta valikoimassa.
		</p>
		<button class="btn btn-success" data-toggle="modal"
			data-target=".bs-example-modal-lg" id="addbtn">Lis‰‰ tuote</button>
		<div class="modal fade bs-example-modal-lg" tabindex="-1"
			role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<h1 class="hh">Lis‰‰ uusi tuote</h1>
					<form name="input" action="list" method="POST">
						<input type="text" class="form-control"
							placeholder="Tuotteen nimi" id="name" name="nimi"><br>
						<input type="text" class="form-control"
							placeholder="Tuotteen hinta" id="name" name="hinta">
						<textarea class="form-control" rows="3" id="textarea">
								</textarea>


						<input type="checkbox" name="tilattavissa" value="1">
						Tilattavissa


						<div class="btnwrapper">
							<button type="submit" class="btn btn-primary" id="ybtn"
								value="Submit">Tallenna</button>
							<button type="button" data-dismiss="modal"
								class="btn btn-default" id="nbtn">Peruuta</button>
					</form>

				</div>
			</div>
		</div>
	</div>
	<!-- 
						<form name="input" action="controller" method="POST">
						<input type="text" name="nimi"><br>
						<input type="text" name="hinta"><br>
						<input type="submit" value="Submit">
						</form> 
						 -->
	<ul>


		<c:forEach items="${pizzatTilattavissa}" var="ptilattavissa">
			<h1>Tilattavissa olevat pizzat</h1>
			<li>
				<div class="pizzawrapper">
					<h2>
						<c:out value="${ptilattavissa.nimi}" />
					</h2>

					<p class="info">

						<c:out value="${ptilattavissa.hinta}" />


					</p>

					<button class="btn btn-alert" data-toggle="modal"
						data-target=".bs-example-modal-sm-muokkaa<c:out value="${ptilattavissa.id}"/>">Muokkaa</button>
					<div
						class="modal fade bs-example-modal-sm-muokkaa<c:out value="${ptilattavissa.id}"/>"
						tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel"
						aria-hidden="true">
						<div class="modal-dialog modal-sm">
							<div class="modal-content" id="del">
								<h1>Muokkaa tuotetta</h1>
								<p>
									Oletko varma ett‰ haluat poistaa tuotteen n‰kyvist‰? <b><c:out
											value="${ptilattavissa.nimi}" /></b> ?
								</p>
								<div id="btnwrap2">
									<form name="input"
										action="muokkaa?id=<c:out value="${ptilattavissa.id}"/>"
										method="POST">
										<form>
											<input type="radio" name="action" value="1">Tilattavissa<br>
											<input type="radio" name="action" value="0">Ei tilattavissa
										</form>
										<button type="submit" class="btn btn-primary" id="ybtn"
											value="Submit">Muokkaa tuote</button>
										<button type="button" data-dismiss="modal"
											class="btn btn-default" id="nbtn">Peruuta</button>
									</form>
									<!-- 
								<!-- <form name="input" action="list?action=poistatuote=<c:out value="${p.id}"/>" method="POST"> 
								
									<a href="list?action=poistaTuote&id=<c:out value="${p.id}"/>"><button type="submit" class="btn btn-primary">Poista tuote</button></a>
									<button type="button" data-dismiss="modal" class="btn btn-default">Peruuta</button>
								 -->

								</div>
							</div>
						</div>
					</div>


					<button class="btn btn-danger" data-toggle="modal"
						data-target=".bs-example-modal-sm<c:out value="${ptilattavissa.id}"/>">Poista</button>
					<div
						class="modal fade bs-example-modal-sm<c:out value="${ptilattavissa.id}"/>"
						tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel"
						aria-hidden="true">
						<div class="modal-dialog modal-sm">
							<div class="modal-content" id="del">
								<h1>Poista tuote</h1>
								<p>
									Oletko varma ett‰ haluat poistaa tuotteen <b><c:out
											value="${ptilattavissa.nimi}" /></b> ?
								</p>
								<div id="btnwrap2">
									<form name="input"
										action="poista?id=<c:out value="${ptilattavissa.id}"/>"
										method="POST">

										<button type="submit" class="btn btn-primary" id="ybtn"
											value="Submit">Poista tuote</button>
										<button type="button" data-dismiss="modal"
											class="btn btn-default" id="nbtn">Peruuta</button>
									</form>
									<!-- 
								<!-- <form name="input" action="list?action=poistatuote=<c:out value="${p.id}"/>" method="POST"> 
								
									<a href="list?action=poistaTuote&id=<c:out value="${p.id}"/>"><button type="submit" class="btn btn-primary">Poista tuote</button></a>
									<button type="button" data-dismiss="modal" class="btn btn-default">Peruuta</button>
								 -->

								</div>
							</div>
						</div>
					</div>



				</div>
			</li>
		</c:forEach>



		<h1>Kaikki pizzat</h1>
		<c:forEach items="${pizzat}" var="p">
			<li>
				<div class="pizzawrapper">
					<h2>
						<c:out value="${p.nimi}" />
					</h2>

					<p class="info">

						<c:out value="${p.hinta}" />


						<c:forEach items="${pizzatSisalto}" var="ps">
							<c:out value="${ps.tuote_id}" />
							<c:out value="${ps.nimi}" />

						</c:forEach>
					</p>
	
					<button class="btn btn-alert" data-toggle="modal"
						data-target=".bs-example-modal-sm-muokkaa<c:out value="${p.id}"/>">Muokkaa</button>
					<div
						class="modal fade bs-example-modal-sm-muokkaa<c:out value="${p.id}"/>"
						tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel"
						aria-hidden="true">
						<div class="modal-dialog modal-sm">
							<div class="modal-content" id="del">
								<h1>Muokkaa tuotetta</h1>
								<p>
									Oletko varma ett‰ haluat poistaa tuotteen n‰kyvist‰? <b><c:out
											value="${p.nimi}" /></b> ?
								</p>
								<div id="btnwrap2">
									<form name="input"
										action="muokkaa?id=<c:out value="${p.id}"/>"
										method="POST">
										<form>
											<input type="radio" name="action" value="1">Tilattavissa<br>
											<input type="radio" name="action" value="0">Ei tilattavissa
										</form>
										<button type="submit" class="btn btn-primary" id="ybtn"
											value="Submit">Muokkaa tuote</button>
										<button type="button" data-dismiss="modal"
											class="btn btn-default" id="nbtn">Peruuta</button>
									</form>
									<!-- 
								<!-- <form name="input" action="list?action=poistatuote=<c:out value="${p.id}"/>" method="POST"> 
								
									<a href="list?action=poistaTuote&id=<c:out value="${p.id}"/>"><button type="submit" class="btn btn-primary">Poista tuote</button></a>
									<button type="button" data-dismiss="modal" class="btn btn-default">Peruuta</button>
								 -->

								</div>
							</div>
						</div>
					</div>

					<button class="btn btn-danger" data-toggle="modal"
						data-target=".bs-example-modal-sm<c:out value="${p.id}"/>">Poista</button>
					<div class="modal fade bs-example-modal-sm<c:out value="${p.id}"/>"
						tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel"
						aria-hidden="true">
						<div class="modal-dialog modal-sm">
							<div class="modal-content" id="del">
								<h1>Poista tuote</h1>
								<p>
									Oletko varma ett‰ haluat poistaa tuotteen <b><c:out
											value="${p.nimi}" /></b> ?
								</p>
								<div id="btnwrap2">
									<form name="input" action="poista?id=<c:out value="${p.id}"/>"
										method="POST">

										<button type="submit" class="btn btn-primary" id="ybtn"
											value="Submit">Poista tuote</button>
										<button type="button" data-dismiss="modal"
											class="btn btn-default" id="nbtn">Peruuta</button>
									</form>
									<!-- 
								<!-- <form name="input" action="list?action=poistatuote=<c:out value="${p.id}"/>" method="POST"> 
								
									<a href="list?action=poistaTuote&id=<c:out value="${p.id}"/>"><button type="submit" class="btn btn-primary">Poista tuote</button></a>
									<button type="button" data-dismiss="modal" class="btn btn-default">Peruuta</button>
								 -->

								</div>
							</div>
						</div>
					</div>
				</div>
			</li>
		</c:forEach>
		<h1>Debug</h1>
		<c:forEach items="${pizzat}" var="p">
			<tr>
				<td><c:out value="${p.id}" /></td>
				<td><c:out value="${p.nimi}" /></td>
				<td><c:out value="${p.hinta}" /></td>
			</tr>
		</c:forEach>
	</ul>
	</div>

	<div class="leftnavigation">
		<div id="leftwrap">
			<ul class="nav nav-pills nav-stacked">
				<li><a href="index.html">Home</a></li>
				<li class="active"><a href="tuotteet.html">Lis‰‰ tuotteitta</a></li>
				<li><a href="#">Messages</a></li>
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

<!--  
<c:if test="${not empty param.added}">Uusi Pizza lis‰tty<br></c:if>
<c:out value="${aloitusaika}"/>
<c:forEach items="${piz}" var="pizza">
<p><b>${pizza.nimi}</b>
${pizza.hinta}e</p>
</c:forEach>
 -->


<!-- 
<form name="input" action="controller" method="POST">
<input type="text" name="nimi"><br>
<input type="text" name="hinta"><br>
<input type="submit" value="Submit">
</form> 
	 -->
