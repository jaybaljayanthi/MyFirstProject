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


		<div class="container">
			Product Details
				<div class="panel-info">
					<div class="panel panel-heading">Product Details</div>
						<div class="panel panel-body">
						
						<c:url value="/cart/addtocart/${productobj.id}" var="url"></c:url>
							<form action="${url}">
								<img src="<c:url value='/resources/images/${productobj.id }.png'></c:url>" height="50%" width="50%"><br>
							<b>Product Name:</b>${productobj.productname }<br>
							<b>Product Desc:</b>${productobj.productdesc }<br>
							<b>Price:</b>${productobj.price }<br>
							<b>Quantity:</b>${productobj.quantity }<br>
							<b>Category:</b>${productobj.category.categoryname }<br>
							
							
							<security:authorize access="hasRole('ROLE_USER')">
							Enter Quantity:<input type="number" min="1" max="${productobj.id}" name="requestedQuantity">
							<button class="btn btn-primary btn-lg" type="submit"><span class="glyphicon glyphicon-shopping-cart">AddToCart</span></button>
							</security:authorize>
							
							</form>
						</div>
				</div>
		</div>
		
		<a href="<c:url value='/all/getallproducts'></c:url>"> Browse all Products</a>
</body>
</html>