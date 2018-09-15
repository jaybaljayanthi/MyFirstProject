<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
            <%@ include file="header.jsp" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
update category form
<div class="container">

<c:url value="/admin/updatecategory" var="url"></c:url>
		<form:form modelAttribute="category" action="${url}" >
			<table>
				                <tr><td><form:hidden path="id"></form:hidden></td></tr>
								
								<tr><td>Enter Category Name</td>
									<td><form:input path="categoryname"></form:input>
										<form:errors path="categoryname" cssStyle="color:red"></form:errors>
									</td>
			
			
								</tr>
								<tr><td><input type="submit" value="Edit Category"></td></tr>
								
								
								
			</table>	
		</form:form>
	
</div>						
</body>
</html>