<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.css" rel="stylesheet">
		 <link rel="stylesheet" type="text/css" href="style.css">
		 <link href='http://fonts.googleapis.com/css?family=Lora:400,400italic' rel='stylesheet' type='text/css'>
		  <link href="img/title.png" rel="shortcut icon" type="image/x-icon" />
		  <link href='http://fonts.googleapis.com/css?family=Lora:400,400italic' rel='stylesheet' type='text/css'>
		    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
		     <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		     <!--[if lt IE 9]>
		       <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		       <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
		<meta charset="UTF-8">
		<title>Melo e Castello</title>
<title>Insert title here</title>
</head>
<body>


					
<jsp:include page="login.jsp" />
			<div id="navigation">
				<ul>
					<li > <a href="index.html">Etusivu</a></li>
					<li class="active"><a href="pizzat.html">Pizzat</a></li>
					<li><a href="Yhteystiedot.html">Yhteystiedot</a></li>
					<li><a href="palaute.html">Palaute</a></li>
				</ul>
							

							<!-- Small modal -->
							<button class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-sm" data-keyboard="true" id="loginbtn">Kirjaudu</button>

								
				
			</div>
		
			<div id="center">
				<div class="menu">
					<img src="img/logo.png" class="pizzaclass">
				</div>
				<div class="banner">
				</div>
				<div class="ornament">
					<img src="img/pizzat.png" align="middle" >
				</div>
				<div class="content"> 

					<c:forEach items="${pizzat}" var="p">
						<div class="pizzawrapper">
								<h2><c:out value="${p.nimi}" /></h2><h2 id="price"><c:out value="${p.hinta}" /></h2>
								<p><c:out value="${p.sisalto}" /></p>
								<p class="collapse" id="viewdetails<c:out value="${p.id}" />">Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
								<p><a class="btn" data-toggle="collapse" data-target="#viewdetails<c:out value="${p.id}" />">Tuotekuvaus &raquo;</a></p>
								<form class="form">
								<input type="checkbox" name="glutein-free"> Gluteiiniton
								<input type="checkbox" name="lactose-free"> Laktoositon
								</form>
								<div class="buttonwrapper">
								 <div class="btn-group">
								 <button type="button" class="btn btn-default">Lis‰‰ ostoskoriin</button>
							 </div>
						</div>	 
						
						
					</div>
					
					
					</c:forEach>
						 
			
					</div>


			</div>
			  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
			    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
			    <!-- Include all compiled plugins (below), or include individual files as needed -->
						<script src="js/bootstrap.js"></script>
</body>
</html>