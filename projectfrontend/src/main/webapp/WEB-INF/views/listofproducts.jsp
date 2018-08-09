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


		<b>List of Products</b><br>
		
		<!--  ${productsList}-->
		<div class="container">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Product Name</th>
						<th>Price</th>
						<th>Action</th>
					</tr>
				</thead>
					<tbody>
					
						<c:forEach items="${productsList}" var="p">
							<tr>
								<td>${p.productname }</td><td>${p.price }</td>
								<td>
									<a><span class="glyphicon glyphicon-info-sign "></span></a>
									<a><span class="glyphicon glyphicon-trash"></span></a>
									<a><span class="glyphicon glyphicon-pencil"></span></a>
								</td>
							</tr>
							</c:forEach>
					</tbody>
			</table>
		</div>
		

</body>
</html>