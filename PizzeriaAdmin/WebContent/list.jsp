<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE>
<html>
<head>
<link href="css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" type="text/css" href="bootstrap-select.min.css">
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
	<%
		if (session.getAttribute("currentSessionUser") == null) {
			response.sendRedirect("Customer/index.jsp");

		}
	%>
	<script type="text/javascript">
		$(document).ready(function() {
			$('select').selectpicker();
		});
	</script>

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

		<div class="jumbotron">
			<h1>Hallitse tuotteita</h1>
			<p>
				Hei sinulla on t‰ll‰ hetkell‰
				<c:out value="${yht}" />
				tuottetta valikoimassa yhteens‰.
			</p>
			<c:out value="${yhtTil}" />
			niist‰ on tilattavissa <br> <br>
			<button class="btn btn-success" data-toggle="modal"
				data-target=".bs-example-modal-lg" id="addbtn">Lis‰‰ tuote</button>
		</div>



		<div class="modal fade bs-example-modal-lg" tabindex="-1"
			role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<!-- 
					<div class="form-group">
						<h1 class="hh">Lis‰‰ uusi tuote</h1>
						<form name="input" action="list" method="POST">
							<input type="text" class="form-control"
								placeholder="Tuotteen nimi" id="name" name="nimi" required=""><br>
							<input type="number" min="0" step="any" class="form-control"
								placeholder="Tuotteen hinta" id="name" name="hinta" required="">
							</textarea>
<div class="input-group">
							<label> <input type="checkbox" name="tilattavissa"
								value="1"> Tilattavissa
							</label>
							</div>
					
					<div class="input-group">
					<select name="selectpicker1" class="selectpicker1">
				
						<c:forEach items="${pizzatSisalto}" var="pSisalto">
							<option value="<c:out value="${pSisalto.tuote_id}"/>"><c:out
									value="${pSisalto.nimi}" /></option>
						</c:forEach>
					</select>
					</div>
					
					<div class="input-group">
					<select name="selectpicker2" class="selectpicker2">
					
						<c:forEach items="${pizzatSisalto}" var="pSisalto">
							<option value="<c:out value="${pSisalto.tuote_id}"/>"><c:out
									value="${pSisalto.nimi}" /></option>
						</c:forEach>
					</select>
					</div>
					
					<div class="input-group">
					<select name="selectpicker3" class="selectpicker3">
						
						<c:forEach items="${pizzatSisalto}" var="pSisalto">
							<option value="<c:out value="${pSisalto.tuote_id}"/>"><c:out
									value="${pSisalto.nimi}" /></option>
						</c:forEach>
					</select>
					</div>
					
					<div class="input-group">
					<select name="selectpicker4" class="selectpicker4">
				
						<c:forEach items="${pizzatSisalto}" var="pSisalto">
							<option value="<c:out value="${pSisalto.tuote_id}"/>"><c:out
									value="${pSisalto.nimi}" /></option>
						</c:forEach>
					</select>
					</div>
					</div>
					<div class="btnwrapper">
						<button type="submit" class="btn btn-primary" id="ybtn"
							value="Submit">Tallenna</button>
						<button type="button" data-dismiss="modal" class="btn btn-default"
							id="nbtn">Peruuta</button>
						</form>

					</div>
					-->

					<form class="form-horizontal" name="input" action="list"
						method="POST">
						<fieldset>

							<!-- Form Name -->
							<legend>Lis‰‰ uusi tuote</legend>

							<!-- Text input-->
							<div class="form-group">
								<label class="col-md-4 control-label" for="textinput">Nimi</label>
								<div class="col-md-6">
									<input id="textinput" name="nimi" placeholder="Tuotteen nimi"
										class="form-control input-md" type="text" required="">
								</div>
							</div>

							<!-- Text input-->
							<div class="form-group">
								<label class="col-md-4 control-label" for="textinput">Hinta</label>
								<div class="col-md-6">
									<input type="number" min="0" step="any"
										class="form-control input-md" placeholder="Tuotteen hinta"
										name="hinta" required=""><span class="help-block">K‰yt‰
										erottimena pistett‰(.)</span>
								</div>
							</div>

							<!-- Select Basic -->
							<div class="form-group">
								<label class="col-md-4 control-label" for="selectbasic">Aineosa
									1</label>
								<div class="col-md-6">
									<select id="selectbasic" name="selectpicker1"
										class="form-control">
										<c:forEach items="${pizzatSisalto}" var="pSisalto">
											<option value="<c:out value="${pSisalto.tuote_id}"/>"><c:out
													value="${pSisalto.nimi}" /></option>
										</c:forEach>
									</select>
								</div>
							</div>

							<!-- Select Basic -->
							<div class="form-group">
								<label class="col-md-4 control-label" for="selectbasic">Aineosa
									2</label>
								<div class="col-md-6">
									<select id="selectbasic" name="selectpicker2"
										class="form-control">
										<c:forEach items="${pizzatSisalto}" var="pSisalto">
											<option value="<c:out value="${pSisalto.tuote_id}"/>"><c:out
													value="${pSisalto.nimi}" /></option>
										</c:forEach>
									</select>
								</div>
							</div>

							<!-- Select Basic -->
							<div class="form-group">
								<label class="col-md-4 control-label" for="selectbasic">Aineosa
									3</label>
								<div class="col-md-6">
									<select id="selectbasic" name="selectpicker3"
										class="form-control">
										<c:forEach items="${pizzatSisalto}" var="pSisalto">
											<option value="<c:out value="${pSisalto.tuote_id}"/>"><c:out
													value="${pSisalto.nimi}" /></option>
										</c:forEach>
									</select>
								</div>
							</div>

							<!-- Select Basic -->
							<div class="form-group">
								<label class="col-md-4 control-label" for="selectbasic">Aineosa
									4</label>
								<div class="col-md-6">
									<select id="selectbasic" name="selectpicker4"
										class="form-control">
										<c:forEach items="${pizzatSisalto}" var="pSisalto">
											<option value="<c:out value="${pSisalto.tuote_id}"/>"><c:out
													value="${pSisalto.nimi}" /></option>
										</c:forEach>
									</select>
								</div>
							</div>

							<!-- Textarea -->
							<div class="form-group">
								<label class="col-md-4 control-label" for="textarea">Kuvaus</label>
								<div class="col-md-6">
									<textarea class="form-control" id="textarea" name="textarea">Tuotteen kuvaus</textarea>
								</div>
							</div>

							<!-- Multiple Checkboxes -->
							<div class="form-group">
								<label class="col-md-4 control-label" for="checkboxes">Tilattavissa</label>
								<div class="col-md-6">
									<div class="checkbox">
										<label for="checkboxes-0"> <input name="checkboxes"
											id="checkboxes-0" name="tilattavissa" value="1"
											type="checkbox">
										</label>
									</div>
								</div>
							</div>

						</fieldset>
						<div class="btnwrapper">
							<button type="submit" class="btn btn-primary" id="ybtn"
								value="Submit">Tallenna</button>
							<button type="button" data-dismiss="modal"
								class="btn btn-default" id="nbtn">Peruuta</button>

						</div>
					</form>



				</div>
			</div>
		</div>

		<br> <br>
		<c:forEach items="${pizzat}" var="p">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<c:out value="${p.nimi}" />
						<c:out value="${p.hinta}" />
						&#128;
					</h3>
					<!-- <span class="glyphicon glyphicon-remove" id="rmv"></span> -->
					<button class="glyphicon glyphicon-remove" id="rmv"
						data-toggle="modal"
						data-target=".bs-example-modal-sm<c:out value="${p.id}"/>"></button>
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
				<div class="panel-body">

					<c:out value="${p.sisalto}" />
				</div>


				<c:if test="${p.tilattavissa}">

					<form name="input"
						action="muokkaa?id=<c:out value="${p.id}"/>&action=0"
						method="POST">
						<div class="btn-group" role="group" aria-label="..." id="mod">
							<!--  <button type="submit" class="btn btn-success" name="action"
								value="Muokkaa">Muokkaa</button>-->

							<button class="btn btn-info" type="button" data-toggle="modal"
								data-target=".bs-example-modal-sm-muokkaa<c:out value="${p.id}"/>">Muokkaa</button>
							


							<button type="submit" class="btn btn-success" name="action"
								value="Tilattavissa">Tilattavissa</button>
						</div>



					</form>
					
					<div
								class="modal fade bs-example-modal-sm-muokkaa<c:out value="${p.id}"/>"
								tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel"
								aria-hidden="true">
								<div class="modal-dialog modal-sm">
									<div class="modal-content" id="del">


										<form class="form-horizontal" name="input" action="muokkaasisalto?id=<c:out value="${p.id}"/>"
											method="POST">
											<fieldset>

												<!-- Form Name -->
												<legend>
													Muokkaa tuotetta
													<c:out value="${p.nimi}" />
												</legend>

												<!-- Text input-->
												<div class="form-group">
													<label class="col-md-4 control-label" for="textinput">Nimi</label>
													<div class="col-md-6">
														<input id="textinput" name="nimi"
															placeholder="Tuotteen nimi" class="form-control input-md"
															type="text" required=""
															value="<c:out value="${p.nimi}"/>">
													</div>
												</div>

												<!-- Text input-->
												<div class="form-group">
													<label class="col-md-4 control-label" for="textinput">Hinta</label>
													<div class="col-md-6">
														<input type="number" min="0" step="any"
															class="form-control input-md"
															placeholder="Tuotteen hinta" name="hinta" required=""
															value="<c:out value="${p.hinta}"/>"><span
															class="help-block">K‰yt‰ erottimena pistett‰(.)</span>
													</div>
												</div>

												<!-- Select Basic -->
												<div class="form-group">
													<label class="col-md-4 control-label" for="selectbasic">Aineosa
														1</label>
													<div class="col-md-6">
														<select id="selectbasic" name="selectpicker1"
															class="form-control">
															<c:out value="${p.nimi}" />
															<c:set var="sisalto" value="${p.sisalto}"/>
															<%
															//Sisalto erottelu
															
															
															String sis = (String) pageContext.getAttribute("sisalto");
															String[] parts = sis.split(", ");
															String part1 = parts[0]; 
															String part2 = parts[1];
															String part3 = parts[2]; 
															String part4 = parts[3];
															pageContext.setAttribute("osa1", part1);
															pageContext.setAttribute("osa2", part2);
															pageContext.setAttribute("osa3", part3);
															pageContext.setAttribute("osa4", part4);
															
															
															%>
															
															<!-- 
																<option value="<c:out value="${osa1}"/>"><c:out
																		value="${osa1}" /></option>
																 -->		
																 
															<c:forEach items="${pizzatSisalto}" var="pSisalto">
															
														<c:if test="${pSisalto.nimi == osa1}">
													
																<option selected value="<c:out value="${pSisalto.tuote_id}"/>"><c:out
																		value="${pSisalto.nimi}" /></option>
																		
																	
																	
															</c:if>			
																	<c:if test="${pSisalto.nimi != osa1}">
																<option value="<c:out value="${pSisalto.tuote_id}"/>"><c:out
																		value="${pSisalto.nimi}" /></option>
															</c:if>				
																		
																		
															
															</c:forEach>
														</select>
														
														<c:forEach items="${pizzatSisalto}" var="pSisalto">
														<c:if test="${pSisalto.nimi == osa1}">
															<input type="hidden" name="osa1w" value="${pSisalto.tuote_id}" />
															</c:if>
															</c:forEach>
													</div>
												</div>

												<!-- Select Basic -->
												<div class="form-group">
													<label class="col-md-4 control-label" for="selectbasic">Aineosa
														2</label>
													<div class="col-md-6">
														<select id="selectbasic" name="selectpicker2"
															class="form-control">
															<c:forEach items="${pizzatSisalto}" var="pSisalto">
																<c:if test="${pSisalto.nimi == osa2}">
																<option selected value="<c:out value="${pSisalto.tuote_id}"/>"><c:out
																		value="${pSisalto.nimi}" /></option>
															</c:if>			
																	<c:if test="${pSisalto.nimi != osa2}">
																<option value="<c:out value="${pSisalto.tuote_id}"/>"><c:out
																		value="${pSisalto.nimi}" /></option>
															</c:if>				
																		
															</c:forEach>
														</select>
														
														<c:forEach items="${pizzatSisalto}" var="pSisalto">
														<c:if test="${pSisalto.nimi == osa2}">
															<input type="hidden" name="osa2w" value="${pSisalto.tuote_id}" />
															</c:if>
															</c:forEach>
													</div>
												</div>

												<!-- Select Basic -->
												<div class="form-group">
													<label class="col-md-4 control-label" for="selectbasic">Aineosa
														3</label>
													<div class="col-md-6">
														<select id="selectbasic" name="selectpicker3"
															class="form-control">
															
															<c:forEach items="${pizzatSisalto}" var="pSisalto">
																<c:if test="${pSisalto.nimi == osa3}">
																<option selected value="<c:out value="${pSisalto.tuote_id}"/>"><c:out
																		value="${pSisalto.nimi}" /></option>
															</c:if>			
																	<c:if test="${pSisalto.nimi != osa3}">
																<option value="<c:out value="${pSisalto.tuote_id}"/>"><c:out
																		value="${pSisalto.nimi}" /></option>
															</c:if>				
															</c:forEach>
														</select>
														
														<c:forEach items="${pizzatSisalto}" var="pSisalto">
														<c:if test="${pSisalto.nimi == osa3}">
															<input type="hidden" name="osa3w" value="${pSisalto.tuote_id}" />
															</c:if>
															</c:forEach>
													</div>
												</div>

												<!-- Select Basic -->
												<div class="form-group">
													<label class="col-md-4 control-label" for="selectbasic">Aineosa
														4</label>
													<div class="col-md-6">
														<select id="selectbasic" name="selectpicker4"
															class="form-control">
															<c:forEach items="${pizzatSisalto}" var="pSisalto">
																<c:if test="${pSisalto.nimi == osa4}">
																<option selected value="<c:out value="${pSisalto.tuote_id}"/>"><c:out
																		value="${pSisalto.nimi}" /></option>
															</c:if>			
																	<c:if test="${pSisalto.nimi != osa4}">
																<option value="<c:out value="${pSisalto.tuote_id}"/>"><c:out
																		value="${pSisalto.nimi}" /></option>
															</c:if>				
															</c:forEach>
														</select>
														
														<c:forEach items="${pizzatSisalto}" var="pSisalto">
														<c:if test="${pSisalto.nimi == osa4}">
															<input type="hidden" name="osa4w" value="${pSisalto.tuote_id}" />
															</c:if>
															</c:forEach>
													</div>
												</div>

												<!-- Textarea -->
												<div class="form-group">
													<label class="col-md-4 control-label" for="textarea">Kuvaus</label>
													<div class="col-md-6">
														<textarea class="form-control" id="textarea"
															name="textarea">Tuotteen kuvaus</textarea>
													</div>
												</div>

												<!-- Multiple Checkboxes -->
												<div class="form-group">
													<label class="col-md-4 control-label" for="checkboxes">Tilattavissa</label>
													<div class="col-md-6">
														<div class="checkbox">


															<label for="checkboxes-0"> <input
																name="checkboxes" id="checkboxes-0" name="tilattavissa"
																value="1" type="checkbox"
																<c:if test="${p.tilattavissa}">checked </c:if>>


<!-- 
																<label for="checkboxes-0"> <input
																	name="checkboxes" id="checkboxes-0" name="tilattavissa"
																	value="1" type="checkbox">
 -->
															</label>
														</div>
													</div>
												</div>

											</fieldset>
											<div class="btnwrapper">
												<button type="submit" class="btn btn-primary" id="ybtn"
													value="Submit">P‰ivit‰</button>
												<button type="button" data-dismiss="modal"
													class="btn btn-default" id="nbtn">Peruuta</button>

											</div>
										</form>









									</div>
								</div>
							</div>
					
					
				</c:if>
				<c:if test="${!p.tilattavissa}">
					<form name="input"
						action="muokkaa?id=<c:out value="${p.id}"/>&action=1"
						method="POST">
						<button type="submit" class="btn btn-warning" id="mod">Ei
							tilattavissa</button>
					</form>
				</c:if>


			</div>
		</c:forEach>
		<!-- 
						<form name="input" action="controller" method="POST">
						<input type="text" name="nimi"><br>
						<input type="text" name="hinta"><br>
						<input type="submit" value="Submit">
						</form> 
						 -->
		<%-- <ul>

		<h1>Tilattavissa olevat pizzat</h1>


		<c:forEach items="${pizzatTilattavissa}" var="ptilattavissa">

			<li>
				<div class="pizzawrapper">
					<h2>
						<c:out value="${ptilattavissa.nimi}" />
					</h2>

					<p class="info">

						<c:out value="${ptilattavissa.hinta}" />
						<c:out value="${ptilattavissa.tilattavissa}" />
						<c:out value="${ptilattavissa.sisalto}" />


					</p>
					<div class="btn-group">
					 
						<form name="input"
							action="muokkaa?id=<c:out value="${ptilattavissa.id}"/>&action=0"
							method="POST">
							 
							<button class="btn btn-alert">Piilota</button>
						</form>
						<button class="btn btn-danger" data-toggle="modal"
							data-target=".bs-example-modal-sm<c:out value="${ptilattavissa.id}"/>">Poista</button>
					</div>
					
					<div
						class="modal fade bs-example-modal-sm-muokkaa<c:out value="${ptilattavissa.id}"/>"
						tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel"
						aria-hidden="true">
						<div class="modal-dialog modal-sm">
							<div class="modal-content" id="del">
								<h1>Poista tuote</h1>
								<p>
									Oletko varma ett‰ haluat poistaa tuotteen <b><c:out
											value="${ptilattavissa.nimi}" /></b> ?
								</p>
								<div id="btn-group">
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
						<c:out value="${p.tilattavissa}" />
						<c:out value="${p.sisalto}" />


					</p>

<div class="btn-group">
					<form name="input"
						action="muokkaa?id=<c:out value="${p.id}"/>&action=1"
						method="POST">
						<button class="btn btn-alert">Nayta</button>
					</form>
					<button class="btn btn-danger" data-toggle="modal" data-target=".bs-example-modal-sm<c:out value="${p.id}"/>">Poista</button>
						</div>
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
	</ul> --%>
	</div>

	<div class="leftnavigation">
		<div id="leftwrap">
			<ul class="nav nav-pills nav-stacked">
				<li><a href="index">Etusivu</a></li>
				<li class="active"><a href="list">Tuotteet</a></li>
				<li><a href="user">K‰ytt‰j‰t</a></li>
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
	<script src="js/bootstrap-select.js"></script>
	<script src="js/bootstrap.js"></script>





</body>
</html>
