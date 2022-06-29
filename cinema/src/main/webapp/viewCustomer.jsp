<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Customer</title>
<link rel="stylesheet" href="viewStyle.css">
</head>
<body>


<div class="topnav">
	
  <li class="title" style="float:left;">Malaysia Cinema Service</li>
  <a href="ListCustomerController" class="split" >List Customer</a>
  
</div>

<br><br><br>


<div class="containerView">
 
      <h2>Customer Detail</h2>

        <label for="name">Name: </label>
        <c:out value="${s.name}"/>
<br>
        <label for="email">Email: </label>
         <c:out value="${s.email}"/>
<br>
        <label for="phoneNumber">Phone Number: </label>
        <c:out value="${s.phoneNumber}"/>
 <br>   
        <label for="name">Title: </label>
        <c:out value="${s.title}"/>
<br>     
        <label for="name">Quantity: </label>
        <c:out value="${s.quantity}"/>
<br> 
        <label for="price">Price: RM </label>
        <c:out value="${s.price}"/>
 <br>    
        <label for="price">Report Date: </label>
      <c:out value="${s.date}"/>
<br>     
        <label for="category">Category: </label>
         <c:out value="${s.category}"/>


</body>
</html></html>