<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bill</title>
</head>
<body>
<h2>Create Bill</h2>
     <form action="saveBill" method="post">
      <pre> 
      First Name<input type="text" name="firstName" value="${contact.firstName}"/>
      Last Name<input type="text" name="lastName" value="${contact.lastName}"/>
      Email<input type="text" name="email" value="${contact.email}"/>
      Mobile<input type="text" name="mobile" value="${contact.mobile}"/>
      Product<input type="text" name="product"/>
      Amount<input type="text" name="price"/>
       <input type="hidden"  name="id" value="${contact.id}"/>
      
      
       
      <input type="submit" value="generate bill"/>
      </pre>
     </form>

</body>
</html>