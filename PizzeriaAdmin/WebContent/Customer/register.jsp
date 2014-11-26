<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
							sisään</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>