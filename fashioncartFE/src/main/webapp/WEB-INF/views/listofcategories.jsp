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
<center><b>List of Categories</b></center><br>

<div class="container">



			<table class="table table-striped" border="1">
				<thead>
					<tr>
						<th>Id</th>
						<th>Category Name</th>
						
						<th>Action</th>
					</tr>
				</thead>
				
				<tbody>
					
						<c:forEach items="${categoryList}" var="c">
							<tr>
								<td>${c.id }</td>
								
								<td>${c.categoryname }</td>
								
								<td>
									
									
							
							
								<a href="<c:url value='/admin/deletecategories/${c.id }'></c:url>"><span
								class="glyphicon glyphicon-trash"></span></a> 
								
								<a href="<c:url value='/admin/getupdatecategoryform/${c.id }'></c:url>"><span
								class="glyphicon glyphicon-pencil"></span></a>
								  
								  
								  
								</td>
								</tr>
								</c:forEach>
								</tbody>
			</table>
			<a href="<c:url value='/admin/getcategoryform'></c:url>"> Add Categories</a>
</div>
</body>
</html>