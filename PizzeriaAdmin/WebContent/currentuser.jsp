<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<ul class="nav navbar-nav" id="loginbtn">

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><span class="step size-21"> <i
								class="icon ion-ios7-bell"></i>
						</span><b class="caret"></b></a>
						</li>



					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span>
							<c:out value="${currentSessionUser.email}" /> <b class="caret"></b></a><!-- käyttäjän sähköposti otetaan sessioon tallenetusta user-oliosta -->
						<ul class="dropdown-menu dropdown-menu-right">
							<li><a href="#"><span class="glyphicon glyphicon-user"></span>
									Profiili</a></li>
							<li><a href="#"><span class="step size-12"> <i
										class="icon ion-android-settings"></i>
								</span>Asetukset</a></li>
							<li role="presentation" class="divider"></li>
							<li><a href="logout.jsp"><span class="step size-14">
										<i class="icon ion-log-out"></i>
								</span>Kirjaudu ulos</a></li>
						</ul></li>

				</ul>