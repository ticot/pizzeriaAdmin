<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="style.css">
<link href="img/title.png" rel="shortcut icon" type="image/x-icon" />
<link href='http://fonts.googleapis.com/css?family=Lora:400,400italic'
	rel='stylesheet' type='text/css'>
</head>
<body>
<form class="form-horizontal" action="order" method="post" >
			 	
<fieldset>

<!-- Form Name -->
<h3>Yhteystiedot</h3>

<!-- Text input-->


<div class="control-group">
  <label class="control-label" for="Etunimi"><h5>Etunimi</h5></label>
  <div class="controls">
    <input value="<c:out value="${currentSessionUser.etunimi}" />" id="Etunimi" name="Etunimi" placeholder="" class="input-medium" required="" type="text" autofocus>
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="Sukunimi"><h5>Sukunimi</h5></label>
  <div class="controls">
    <input value="<c:out value="${currentSessionUser.sukunimi}" />" id="Sukunimi" name="Sukunimi" placeholder="" class="input-medium" required="" type="text">
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="Osoite"><h5>Osoite</h5></label>
  <div class="controls">
    <input value="<c:out value="${currentSessionUser.katuosoite}" />" id="Osoite" name="Osoite" placeholder="" class="input-medium" required="" type="text">
    
  </div>
</div>
<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="Postinro"><h5>Postinro</h5></label>
  <div class="controls">
    <input value="<c:out value="${currentSessionUser.postinumero}" />" id="Postinro" name="Postinro" placeholder="" class="input-medium" required="" type="text">
    
  </div>
</div>
<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="Postitoimipaikka"><h5>Postitoimipaikka</h5></label>
  <div class="controls">
    <input value="<c:out value="${currentSessionUser.postitoimipaikka}" />" id="Postitoimipaikka" name="Postitoimipaikka" placeholder="" class="input-medium" required="" type="text">
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="Puhelin.nro"><h5>Puhelin.nro</h5></label>
  <div class="controls">
    <input value="<c:out value="${currentSessionUser.puhelinnumero}" />" id="Puhelin.nro" name="Puhelin.nro" placeholder="" class="input-medium" type="text">
    
  </div>
</div>
<!-- Multiple Radios -->
<div class="control-group">
  <label class="control-label" for="toimitustapa">Toimitustapa</label>
  <div class="controls">
    <label class="radio" for="toimitustapa-0">
      <input type="radio" name="toimitustapa" id="toimitustapa-0" value="Nouto" checked="checked">
      Nouto
    </label>
    <label class="radio" for="toimitustapa-1">
      <input type="radio" name="toimitustapa" id="toimitustapa-1" value="Toimitus">
      Toimitus
    </label>
  </div>
</div>

<!-- Multiple Radios -->
<div class="control-group">
  <label class="control-label" for="maksutapa">Maksutapa</label>
  <div class="controls">
    <label class="radio" for="maksutapa-0">
      <input type="radio" name="maksutapa" id="maksutapa-0" value="Käteinen" checked="checked">
      Käteinen
    </label>
    <label class="radio" for="maksutapa-1">
      <input type="radio" name="maksutapa" id="maksutapa-1" value="Paypal">
      Paypal
    </label>
    <label class="radio" for="maksutapa-2">
      <input type="radio" name="maksutapa" id="maksutapa-2" value="Luottokortti">
      Luottokortti
    </label>
  </div>
</div>
	
</fieldset>
<button type="button" class="btn btn-success" id="confirmation" >Vahvista tilaus</button>
</form>
</body>
</html>