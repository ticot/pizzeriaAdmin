<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- 
████████╗██╗ ██████╗ ██████╗ ██╗     ██╗ ██████╗██╗ ██████╗ ██╗   ██╗███████╗
╚══██╔══╝██║██╔════╝██╔═══██╗██║     ██║██╔════╝██║██╔═══██╗██║   ██║██╔════╝
   ██║   ██║██║     ██║   ██║██║     ██║██║     ██║██║   ██║██║   ██║███████╗
   ██║   ██║██║     ██║   ██║██║     ██║██║     ██║██║   ██║██║   ██║╚════██║
   ██║   ██║╚██████╗╚██████╔╝███████╗██║╚██████╗██║╚██████╔╝╚██████╔╝███████║
   ╚═╝   ╚═╝ ╚═════╝ ╚═════╝ ╚══════╝╚═╝ ╚═════╝╚═╝ ╚═════╝  ╚═════╝ ╚══════╝
   Antti Eloranta, Heini Haatanen, Tanja Partanen, Péter Takács, Samu Tapanen
   2014
   
  rekisteröitymis-lomake avautuu jos käyttäjä painaa "rekisteröidy" nappia oikealta ylhäältä
   

   -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>	<!-- Sivujen yläreunasta "rekisteröidy"-nappia painamalla aukeaa tämä ikkuna -->
</head>
<body>
<div class="modal fade bs-example-modal-sm2" tabindex="-1" role="dialog"
	aria-labelledby="mySmallModalLabel2" aria-hidden="true">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">


				<h4 class="modal-title" id="myModalLabel">Rekisteröidy käyttäjäksi</h4>
				<button type="button" class="btn btn-default btn-sm"
					data-dismiss="modal" id="close">
					<span class="glyphicon glyphicon-remove"></span>
			</div>
			<form action="register" class="form-horizontal" role="form" method="POST"><!-- Rekisteröitymistä varten täytettävä formi
																						fi/omapizzeria/customer/controller/Register.java -->

				<div class="form-group">
					<label for="email" class="col-sm-2 control-label">E-mail</label>
					<div class="col-sm-10">
						<input type="email" class="form-control" id="email" name="email"
							placeholder="E-mail" required="">
					</div>
				</div>
				<div class="form-group">
					<label for="salasana" class="col-sm-2 control-label">Salasana</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="salasana" name="salasana"
							placeholder="Salasana" required="">
					</div>
				</div>
				<div class="form-group">
					<label for="salasana2" class="col-sm-2 control-label"></label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="salasana2" name="salasana2"
							placeholder="Salasana uudelleen" required="">
					</div>
				</div>
				<div class="form-group">
					<label for="etunimi" class="col-sm-2 control-label">Etunimi</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="etunimi" name="etunimi"
							placeholder="Etunimi" required="">
					</div>
				</div>
				<div class="form-group">
					<label for="sukunimi" class="col-sm-2 control-label">Sukunimi</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="sukunimi" name="sukunimi"
							placeholder="Sukunimi" required="">
					</div>
				</div>
				<div class="form-group">
					<label for="katuosoite" class="col-sm-2 control-label">Katuosoite</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="katuosoite" name="katuosoite"
							placeholder="Katuosoite" required="">
					</div>
				</div>
				<div class="form-group">
					<label for="postinumero" class="col-sm-2 control-label">Postinumero</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="postinumero" name="postinumero"
							placeholder="Postinumero" required="">
					</div>
				</div>
				<div class="form-group">
					<label for="postitoimipaikka" class="col-sm-2 control-label">Postitoimipaikka</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="postitoimipaikka" name="postitoimipaikka"
							placeholder="Postitoimipaikka" required="">
					</div>
				</div>
				<div class="form-group">
					<label for="puhelinnumero" class="col-sm-2 control-label">Puhelinnumero</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="puhelinnumero" name="puhelinnumero"
							placeholder="Puhelinnumero" required="">
					</div>
				</div>
				
				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" value="register" name="nappi" class="btn btn-default">Rekisteröidy</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>