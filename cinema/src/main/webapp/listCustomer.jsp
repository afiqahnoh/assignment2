<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Customer</title>
<link rel="stylesheet" href="styleList.css">
</head>
<body>
<div class="topnav">
	
  <li class="title" style="float:left;">Malaysia Cinema Service</li>
  <a href="addCustomer.jsp" class="split">Add Customer</a><br>
</div>
<br><br>

<h2>List of Customer</h2>
<table >

		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Phone Number</th>
			<th>Title</th>
			<th>Quantity</th>
			<th>Price</th>
			<th>Date</th>
			<th>Category</th>
	
			<th colspan="3">Action</th>
		</tr>

		<c:forEach items="${customers}" var="s" varStatus="customers">
		<tr>
			<td><c:out value="${s.id}"/></td>
			<td><c:out value="${s.name}"/></td>
			<td><c:out value="${s.email}"/></td>
			<td><c:out value="${s.phoneNumber}"/></td>
			<td><c:out value="${s.title}"/></td>
			<td><c:out value="${s.quantity}"/></td>
			<td><c:out value="${s.price}"/></td>
			<td><c:out value="${s.date}"/></td>
			<td><c:out value="${s.category}"/></td>

			<td><a class="btn btn-primary" href="ViewCustomerController?id=<c:out value="${s.id}"/>">View</a></td>
			<td><a class="btn btn-primary" href="UpdateCustomerController?id=<c:out value="${s.id}"/>">Update</a></td>
			<td><button id="<c:out value="${s.id}"/>" onclick ="confirmation(this.id)">Delete</button></td>
		</tr>
		</c:forEach>
	</table>
	
	<script>
function confirmation(id){
	console.log(id);
	var r = confirm("Are you sure want to delete?");
	if (r ==true){
		location.href ='DeleteCustomerController?id=' +id;
		alert("Successfully deleted");
	}else{
		return false;
	}
}

</script>

</body>
</html>