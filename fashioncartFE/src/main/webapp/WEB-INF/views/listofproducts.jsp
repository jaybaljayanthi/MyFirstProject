<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
    <%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
$(document).ready(function(){
	var searchCondition='${searchCondition}'
	$('.table').DataTable({
		"lengthMenu":[[5,7,-1],[5,7,"All"]],
	    "oSearch" : {
		"sSearch" : searchCondition
		}
	})
})
</script>
</head>
<body>


		<b>List of Products</b><br>
		
		<!--  ${productsList}-->
		<div class="container">
			<table class="table table-striped" border="1">
				<thead>
					<tr>
						<th>Id</th>
						<th>Images</th>
						<th>Product Name</th>
						<th>Product Description</th>
						<th>Price</th>
						<th>Category</th>
						<th>Action</th>
					</tr>
				</thead>
					<tbody>
					
						<c:forEach items="${productsList}" var="p">
							<tr>
								<td><a href="<c:url value='/all/getproduct/${p.id }'></c:url>">${p.id }</a></td>
								
								<td><img src="<c:url value='/resources/images/${p.id }.png'></c:url>" height="30px" width="30px"></td>
								<td>${p.productname }</td>
								<td>${p.productdesc }</td>
								<td>${p.price }</td>
								<td>${p.category.categoryname }
								<td>
									
									
									<a href="<c:url value='/all/getproduct/${p.id }'></c:url>">
							<span
								class="glyphicon glyphicon-info-sign"></span></a> 
								<security:authorize access="hasRole('ROLE_ADMIN')">
								<a href="<c:url value='/admin/deleteproduct/${p.id }'></c:url>"><span
								class="glyphicon glyphicon-trash"></span></a> 
								
								<a href="<c:url value='/admin/getupdateform/${p.id }'></c:url>"><span
								class="glyphicon glyphicon-pencil"></span></a>
								  </security:authorize>
								  
								  
								</td>
							</tr>
							</c:forEach>
					</tbody>
			</table>
		</div>
		

</body>
</html>