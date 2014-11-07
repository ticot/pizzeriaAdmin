<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
	<html>
		<head>
		 <link href="css/bootstrap.css" rel="stylesheet">
		 <link rel="stylesheet" type="text/css" href="style.css">
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
		</head>
		<body>
		<jsp:include page="login.jsp" />
			<div id="navigation" >
				<ul>
					<li class="active"> <a href="index.html">Etusivu</a></li>
					<li><a href="pizzat.html">Pizzat</a></li>
					<li><a href="Yhteystiedot.html">Yhteystiedot</a></li>
					<li><a href="palaute.html">Palaute</a></li>
				</ul>
							

							<!-- Small modal -->
							<button class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-sm" data-keyboard="true" id="loginbtn">Kirjaudu</button>

								
				
			</div>
		
			<div id="center">
				<div class="menu">
					
				</div>
				<div class="banner">
				<img src="img/logo.png" class="imglogo">
				</div>
				<div class="ornament">
					<img src="img/hello.png" align="middle">
				</div>
				<div class="content">
					<p>
						T‰m‰ on t‰yteteksti‰ ettei kenellekk‰‰n tulisi paha mieli niin 
						t‰ss‰ ei lue mit‰‰n t‰rke‰‰.P‰invastoin t‰m‰ on vain turhaa lˆpin‰‰, jotta
						t‰m‰ div olisi sen n‰kˆinen niinkuin asiakas julkaissessaan haluaa. H‰n p‰‰tt‰‰ mit‰ kirjoittaa
						t‰h‰n. Ja kehitystiimin‰ olemme vain kirjoitelleet sit‰ sun t‰t‰. Teksti ei tarkoita mit‰‰n ja 
						t‰m‰kin lause on vain t‰yttˆlause jotta koko kappale n‰ytt‰isi pidemm‰lt‰.
						Kirjoitin t‰m‰n itse enk‰ kopioinut internetist‰.
					</p>
				</div>
			</div>




			  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
			    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
			    <!-- Include all compiled plugins (below), or include individual files as needed -->
						<script src="js/bootstrap.js"></script>

		</body>
</html>
