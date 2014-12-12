<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="style.css">
<link href='http://fonts.googleapis.com/css?family=Lora:400,400italic'
	rel='stylesheet' type='text/css'>
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
<!-- pohjan kommentit index.jsp -->
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="login.jsp" />
	<jsp:include page="register.jsp" />
	<div id="navigation">
		<ul>
			<li><a href="index.jsp">Etusivu</a></li>
			<li class="active"><a href="pizzat">Pizzat</a></li>
			<li><a href="yhteystiedot.jsp">Yhteystiedot</a></li>
			<li><a href="palaute">Palaute</a></li>
		</ul>
		
		<jsp:include page="navigation.jsp" />
	

	</div>


	<!-- Small modal -->
	<button class="btn btn-primary" data-toggle="modal"
		data-target=".bs-example-modal-sm" data-keyboard="true" id="loginbtn">Kirjaudu</button>



	</div>

	<div id="center">
		<div class="menu">
			<img src="img/logo.png" class="pizzaclass">
		</div>
		<div class="banner"></div>
		<div class="ornament">
			<img src="img/pizzat.png" align="middle">
		</div>
		<div class="content">
	<%
			if (request.getParameter("added") != null) { 
		%>
		<div class="alert alert-success alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert">
				<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
			</button>
			Pitsa <c:out value="${p.nimi}" /> lis‰tty! Mene <a href="ostoskori" class="alert-link">kassalle</a>
		</div>

		<%
			}
			
		%>
			<c:forEach items="${pizzat}" var="p">
			<form method="post" class="form-horizontal" name="input" action="ostoskori?id=<c:out value="${p.id}"/>">
				<!-- Listataan valikoimasta lˆytyv‰t tilattavissa olevat tuotteet -->
				<div class="pizzawrapper">
					<h2>
						<c:out value="${p.nimi}" />
						<input name="nimi" value="<c:out value="${p.nimi}" />" type="hidden"/>
					</h2>
					<h2 id="price">
						<c:out value="${p.hinta}" />
						<input name="hinta" value="<c:out value="${p.hinta}" />" type="hidden"/>
						&#8364;
					</h2>
					<p>
						<c:out value="${p.sisalto}" />
					</p>
					<p class="collapse" id="viewdetails<c:out value="${p.id}" />">Donec
						id elit non mi porta gravida at eget metus. Fusce dapibus, tellus
						ac cursus commodo, tortor mauris condimentum nibh, ut fermentum
						massa justo sit amet risus. Etiam porta sem malesuada magna mollis
						euismod. Donec sed odio dui.</p>
					<p>
						<!-- nappi joka laajentaa pizzan alta lˆytyv‰n kuvauksen --> <a class="btn"
							data-toggle="collapse"
							data-target="#viewdetails<c:out value="${p.id}" />">Tuotekuvaus
							&raquo;</a>
					</p>
						
						<input type="checkbox" name="glutein-free" value="true"> Gluteiiniton <input
							type="checkbox" name="lactose-free" value="true"> Laktoositon
				
					<div class="buttonwrapper">
					
							<button type="submit" class="btn btn-default">Lis‰‰
								ostoskoriin</button>
									</form>
					
					</div>


				</div>


			</c:forEach>


		</div>


	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.js"></script>
</body>
</html>