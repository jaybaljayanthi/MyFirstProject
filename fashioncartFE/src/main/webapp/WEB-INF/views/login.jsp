<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="<c:url value='/resources/css/login.css'></c:url>" rel="stylesheet">

</head>
<body>
<span style="color:red">${error }</span><br>
${msg }<br>
<center><b>Login Page</b></center>
<c:url value="/j_spring_security_check" var="url"></c:url>
<form method="post" action="${url }">
<center>Enter Email :<input type="text" name="j_username"><br></center>
<br>
<center>Enter password : <input type="password" name="j_password"></center>
<br>
<center><input type="submit" value="Login"></center>

</form>
</body>
</html>
