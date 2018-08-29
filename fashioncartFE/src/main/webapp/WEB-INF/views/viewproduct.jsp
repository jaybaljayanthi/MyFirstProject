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
								<img src="<c:url value='/resources/images/${productobj.id }.png'></c:url>"><br>
							<b>Product Name:</b>${productobj.productname }<br>
							<b>Product Desc:</b>${productobj.productdesc }<br>
							<b>Price:</b>${productobj.price }<br>
							<b>Quantity:</b>${productobj.quantity }<br>
							<b>Category:</b>${productobj.category.categoryname }<br>
							
							
							
							<button class="btn btn"><span class="glyphicon glyphicon-shopping-cart"></span></button>
						</div>
				</div>
		</div>
		
		<a href="<c:url value='/all/getallproducts'></c:url>"> Browse all Products</a>
</body>
</html>