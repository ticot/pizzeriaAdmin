<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<title>Melo e Castello</title> <!-- Katso pohjan kommentit index.jsp -->
</head>
<body>


	<%
		if (session.getAttribute("currentSessionUser") == null) {
			response.sendRedirect("Customer/index.jsp");

		}
	%>
	<div class="topbar">
		<header class="navbar navbar-inverse navbar-fixed-top bs-docs-nav"
			role="banner">

			<nav class="collapse navbar-collapse bs-navbar-collapse"
				role="navigation">
				<a class="navbar-brand" href="#">Melo e Castello Admin</a>
				<jsp:include page="currentuser.jsp" />
			</nav>

		</header>

	</div>
	<!-- Small modal -->


	<div id="centercontent">
	<!-- N‰ytet‰‰n ilmoituslaatikko onnistuneesta k‰ytt‰j‰n lis‰yksest‰ ja poistosta -->
	<%
			if (request.getParameter("removed") != null && request.getParameter("removed").equals("true")) {
		%>
		<div class="alert alert-info alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert">
				<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
			</button>
			K‰ytt‰j‰ poistettu!
		</div>
		<%
			}

			%>
			<%
			if (request.getParameter("removed") != null && request.getParameter("removed").equals("false")) {
		%>
		<div class="alert alert-danger alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert">
				<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
			</button>
			K‰ytt‰j‰n poistaminen ep‰onnistui!
		</div>
		<%
			}

			if (request.getParameter("added") != null && request.getParameter("added").equals("true")) {
				%>
				<div class="alert alert-info alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					K‰ytt‰j‰ lis‰tty!
				</div>
				<%
					}

					%>
					<%
					if (request.getParameter("added") != null && request.getParameter("added").equals("false")) {
				%>
				<div class="alert alert-danger alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					K‰ytt‰j‰n lis‰‰minen ep‰onnistui!
				</div>
				<%
					}

					%>
	
		<div class="jumbotron">
			<h1>Lis‰‰ k‰ytt‰j‰</h1>
			<p>T‰n‰‰n on kaunis p‰iv‰!</p>
		</div>



		<form class="form-horizontal" name="input" action="user" method="POST">
			<fieldset>			<!--	Lomake k‰ytt‰j‰n lis‰ykseen.
			 fi/omapizzeria/admin/controller/User.java -->

				<!-- Form Name -->
				<legend>Lis‰‰ uusi k‰ytt‰j‰</legend>

				<div class="form-group">
					<label class="col-md-4 control-label" for="etunimi">Etunimi</label>
					<div class="col-md-4">
						<input id="etunimi" name="etunimi" placeholder="Etunimi"
							class="form-control input-md" required="" type="text" required="">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label" for="Sukunimi">Sukunimi</label>
					<div class="col-md-4">
						<input id="sukunimi" name="sukunimi" placeholder="Sukunimi"
							class="form-control input-md" required="" type="text" required="">
					</div>
				</div>
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
							class="form-control input-md" required="" type="password"
							required="">

					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label" for="salasana">Salasana
						uudelleen</label>
					<div class="col-md-4">
						<input id="salasana2" name="salasana2"
							placeholder="Salasana uudelleen" class="form-control input-md"
							required="" type="password" required="">

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
					value="register" name="button">Lis‰‰ K‰ytt‰j‰</button>
				<button type="button" data-dismiss="modal" class="btn btn-default"
					id="nbtn">Peruuta</button>

			</fieldset>
		</form>

		<legend>Olemassa olevat k‰ytt‰j‰t</legend>
		<table class = "table table-hover" id="usertable">
			<thead>
			<tr>
				<th>Etunimi</th>
				<th>Sukunimi</th>
				<th>Email</th>
				<th>Level</th>
				<th>Poista</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${users}" var="u">	<!-- Listataan olemassa olevat k‰ytt‰j‰t -->
			<tr>
				<td><c:out value="${u.etunimi}" /></td>
				<td><c:out value="${u.sukunimi}" /></td>
				<td><c:out value="${u.email}" /></td>
				<td><c:out value="${u.level}" /></td>
				<td><button class="glyphicon glyphicon-remove" id="rmv2"
						data-toggle="modal"
						data-target=".bs-example-modal-sm-<c:out value="${u.id}"/>"></button>
					<div class="modal fade bs-example-modal-sm-<c:out value="${u.id}"/>"
						tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel"	aria-hidden="true">
						<div class="modal-dialog modal-sm">
							<div class="modal-content" id="del">
								<h1>Poista tuote</h1>
								<p>
									Oletko varma ett‰ haluat poistaa k‰ytt‰j‰n <b><c:out value="${u.etunimi}" /></b> ?
								</p>
								<div id="btnwrap2">
									<form name="input" action="user?id=<c:out value="${u.id}"/>"
										method="POST">

										<button type="submit" class="btn btn-primary" id="ybtn" name="button"
											value="remove">Poista k‰ytt‰j‰</button>
										<button type="button" data-dismiss="modal"
											class="btn btn-default" id="nbtn">Peruuta</button>
									</form>
									
								
								</div>
							</div>
						</div>
					</div></td>
			</tr>	
			</c:forEach>
			</tbody>
		</table>
		
		

	</div>
	<div class="leftnavigation">
		<div id="leftwrap">
			<ul class="nav nav-pills nav-stacked">
				<li><a href="index">Etusivu</a></li>
				<li><a href="list">Tuotteet</a></li>
				<li class="active"><a href="user">K‰ytt‰j‰t</a></li>
				<li><a href="sisalto">Aineosat</a></li>
				<li><a href="palaute">Palautteet</a></li>
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
