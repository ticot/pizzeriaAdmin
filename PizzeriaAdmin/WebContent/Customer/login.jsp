<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link href="css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="style.css">
<link href="img/title.png" rel="shortcut icon" type="image/x-icon" />
<link href='http://fonts.googleapis.com/css?family=Lora:400,400italic'
	rel='stylesheet' type='text/css'>
<!-- 
████████╗██╗ ██████╗ ██████╗ ██╗     ██╗ ██████╗██╗ ██████╗ ██╗   ██╗███████╗
╚══██╔══╝██║██╔════╝██╔═══██╗██║     ██║██╔════╝██║██╔═══██╗██║   ██║██╔════╝
   ██║   ██║██║     ██║   ██║██║     ██║██║     ██║██║   ██║██║   ██║███████╗
   ██║   ██║██║     ██║   ██║██║     ██║██║     ██║██║   ██║██║   ██║╚════██║
   ██║   ██║╚██████╗╚██████╔╝███████╗██║╚██████╗██║╚██████╔╝╚██████╔╝███████║
   ╚═╝   ╚═╝ ╚═════╝ ╚═════╝ ╚══════╝╚═╝ ╚═════╝╚═╝ ╚═════╝  ╚═════╝ ╚══════╝
   Antti Eloranta, Heini Haatanen, Tanja Partanen, Péter Takács, Samu Tapanen
   2014
   
   Login sivu on includettu jokaiselle asiakaspuolen sivulle oikeaan yläreunaan. Se on ihan vain lomake jossa kysytään email ja salasana.
   -->	
	
<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog"
	aria-labelledby="mySmallModalLabel" aria-hidden="true">	<!-- Sivujen yläreunasta "kirjaudu"-nappia painamalla aukeaa tämä ikkuna -->
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">


				<h4 class="modal-title" id="myModalLabel">Kirjaudu sisään</h4>
				<button type="button" class="btn btn-default btn-sm"
					data-dismiss="modal" id="close">
					<span class="glyphicon glyphicon-remove"></span>
			</div>
			<form action="login" class="form-horizontal" role="form"> <!-- 	Kirjautumista varten täytettävä lomake
																			fi/omapizzeria/customer/controller/Login.java -->

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
							sisään</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>