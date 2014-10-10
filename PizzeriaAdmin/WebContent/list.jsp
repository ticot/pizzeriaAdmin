<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
<!--  
<c:if test="${not empty param.added}">Uusi Pizza lisätty<br></c:if>
<c:out value="${aloitusaika}"/>
<c:forEach items="${piz}" var="pizza">
    <p><b>${pizza.nimi}</b>
    	${pizza.hinta}e</p>
</c:forEach>
 -->

 <c:forEach items="${pizzat}" var="p">
	<tr>
		<td><c:out value="${p.id}"/></td>
		<td><c:out value="${p.nimi}"/></td>
		<td><c:out value="${p.hinta}"/></td>
	</tr>
</c:forEach>
<!-- 
<form name="input" action="controller" method="POST">
<input type="text" name="nimi"><br>
<input type="text" name="hinta"><br>
<input type="submit" value="Submit">
</form> 
	 -->	
</body>
</html>