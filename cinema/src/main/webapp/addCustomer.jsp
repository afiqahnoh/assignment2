<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Customer</title>
<link rel="stylesheet" href="style.css">

</head>
<body>

<div class="topnav">
	
  <li class="title" style="float:left;">Malaysia Cinema Service</li>
  <a href="ListCustomerController" class="split" >List Customer</a>
</div>

<form action="AddCustomerController" method="post">


 <br><br><br>
<div class="container">
  <form action="/action_page.php">
 
        <h2>Customer Detail</h2>
	<p>Please fill in this form.</p>
	
	
    <div class="row">
      <div class="col-25">
        <label for="name">Name</label>
      </div>
      <div class="col-75">
        <input type="text" id="name" name="name" >
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="email">Email</label>
      </div>
      <div class="col-75">
        <input type="text" id="email" name="email" >
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="phoneNumber">Phone Number</label>
      </div>
      <div class="col-75">
        <input type="text" id="phoneNumber" name="phoneNumber" >
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="name">Title</label>
      </div>
      <div class="col-75">
        <input type="text" id="title" name="title" >
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="name">Quantity</label>
      </div>
      <div class="col-75">
        <input type="text" id="quantity" name="quantity">
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="price">Price</label>
      </div>
      <div class="col-75">
        <input type="text" id="price" name="price" >
      </div>
    </div>
    
    <div class="row">
      <div class="col-25">
        <label for="price">Report Date</label>
      </div>
      <div class="col-75">
      <input type="date" name="date" ><i class='fas fa-calendar'>
      </div>
    </div>

    <div class="row">
      <div class="col-25">
        <label for="category">Category</label>
      </div>
      <div class="col-75">
        <select id="cateory" name="category">
         <option value="Booking Issues">Booking Issues</option>
		<option value="Refund">Refund</option>
		<option value="Service">Service</option>
        </select>
      </div>
    </div>
  <br>
    <div class="row">
      <input type="submit" value="Submit">
    </div>
  </form>

</body>
</html>