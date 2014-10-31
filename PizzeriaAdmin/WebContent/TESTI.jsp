<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<sql:setDataSource var="snapshot" driver="org.mariadb.jdbc.Driver"
     url="jdbc:mariadb://localhost/a1303399"
     user="a1303399"  password="meSEUk52v"/>
 
<sql:query dataSource="${snapshot}" var="result">
select i.nimi from Sisalto i, Tuote p, Tuotteen_sisalto pi
where pi.tuote_id = p.tuote_id
and pi.sisalto_id = i.sisalto_id
and p.tuote_id = 3;
</sql:query>
<c:forEach var="row" items="${result.rows}">
<tr>
   <td><c:out value="${row.id}"/></td>
   <td><c:out value="${row.nimi}"/></td>
   <td><c:out value="${row.last}"/></td>
   <td><c:out value="${row.age}"/></td>
</tr>
</c:forEach>
</body>
</html>