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
<title>Melo e Castello</title><!-- Katso pohjaan kuuluvat kommentit index.jsp -->
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
	<!-- N‰ytet‰‰n ilmoituslaatikko jos sis‰ltˆ poistettiin onnistuneesti tai tuli virhe -->
<%
		
				if (request.getParameter("poistettu") != null) {
		%>
		<div class="alert alert-info alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert">
				<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
			</button>
			Aineosa poistettu!
		</div>
		<%
			}else if (request.getParameter("error") != null){
				
		%>
<div class="alert alert-danger alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert">
				<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
			</button>
			Hups ! Aineosaa ei voitu poistaa. Aineosa on t‰ll‰ hetkell‰ k‰ytˆss‰ jossain tuotteessa.
		</div>
	
<% }
%>

		<div class="jumbotron">
			<h1>Lis‰‰ uusia aineosia</h1>
			<p>T‰n‰‰n on kaunis p‰iv‰!</p>
		</div>



		<form class="form-horizontal" name="input" action="sisalto" method="POST"> <!-- lomake ainesosan lis‰yst‰ varten
		fi/omapizzeria/admin/controller/SisaltoLisays.java -->
			<fieldset>

				<!-- Form Name -->
				<legend>Lis‰‰ uusi aineosa</legend>

				<!-- Email input -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="email">Aineosan nimi</label>
					<div class="col-md-4">
						<input id="sisalto" name="sisalto" placeholder="Nimi"
							class="form-control input-md" required="" type="text">

					</div>
				</div>

				<button type="submit" class="btn btn-primary" id="ybtn"
					value="Submit">Lis‰‰ aineosa</button>
				<button type="button" data-dismiss="modal" class="btn btn-default"
					id="nbtn">Peruuta</button>

			</fieldset>
		</form>
<legend>Olemassa olevat aineosat</legend>
<ul class="list-group"> <!-- Listataan ainesosat -->
<c:forEach items="${pizzatSisalto}" var="pSisalto">
							  <li class="list-group-item"><c:out
									value="${pSisalto.nimi}" /><button class="glyphicon glyphicon-remove" id="rmv2"
						data-toggle="modal"
						data-target=".bs-example-modal-sm-<c:out value="${pSisalto.tuote_id}"/>"></button>
					<div class="modal fade bs-example-modal-sm-<c:out value="${pSisalto.tuote_id}"/>"
						tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel"
						aria-hidden="true"> 
						<div class="modal-dialog modal-sm"> <!-- Varmistava kysymys ainesosan poistoon -->
							<div class="modal-content" id="del">
								<h1>Poista tuote</h1>
								<p>
									Oletko varma ett‰ haluat poistaa tuotteen <b><c:out
											value="${pSisalto.nimi}" /></b> ?
								</p>
								<div id="btnwrap2">
									<form name="input" action="sisaltopoisto?id=<c:out value="${pSisalto.tuote_id}"/>"
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
					</div></li>
						</c:forEach>
</ul>

	</div>
	<div class="leftnavigation">
		<div id="leftwrap">
			<ul class="nav nav-pills nav-stacked">
				<li><a href="index">Etusivu</a></li>
				<li><a href="list">Tuotteet</a></li>
				<li><a href="user">K‰ytt‰j‰t</a></li>
				<li class="active"><a href="sisalto">Aineosat</a></li>
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
