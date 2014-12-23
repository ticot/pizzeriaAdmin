
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
   
    -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
session.removeAttribute("currrentUser");//Poistetaan käyttäjä sessiosta 
session.invalidate(); 
response.sendRedirect("Customer/index.jsp"); //palautetaan käyttäjä asiakaspuolen index-sivulle.
%>
</body>
</html>