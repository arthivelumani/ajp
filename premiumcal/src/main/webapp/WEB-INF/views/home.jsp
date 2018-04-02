<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Premium Calculation</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
 --%>
 
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Premium Calculation</title>

<style>
.button {
    background-color: #afe2ed;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
  .jumbotron {
      background-color: #f4511e;
      color: #fff;
      padding: 100px 25px;
      font-family: Montserrat, sans-serif;
  }
  .container-fluid {
      padding: 60px 50px;
      }
 .navbar {
      margin-bottom: 0;
      background-color: #7de0e8;
      z-index: 9999;
      border: 0;
      font-size: 12px !important;
      line-height: 1.42857143 !important;
      letter-spacing: 4px;
      border-radius: 0;
      font-family: Montserrat, sans-serif;
  }
  .navbar li a, .navbar .navbar-brand {
      color: #fff !important;
  }
  .navbar-nav li a:hover, .navbar-nav li.active a {
      color: #f4511e !important;
      background-color: #fff !important;
  }
  .navbar-default .navbar-toggle {
      border-color: transparent;
      color: #fff !important;
  }
   @media screen and (max-width: 768px) {
    .col-sm-4 {
      text-align: center;
      margin: 25px 0;
    }
    .btn-lg {
        width: 100%;
        margin-bottom: 35px;
    }
  }
  @media all and (max-width: 480px) {
    .logo {
        font-size: 150px;
    }
    .jumbotron
    {
      background-color:blue;
    }
	
  }

</style>

</head>
<body>
<%@include file="Header.jsp" %>

<table>
<tr>
 
<td width="618">
<img src="images/images.png" width="400" height="126"></td>
 <td width="670"><form name="form1" method="post" action="ShowALlRecords.jsp?page=1">
   <input class="button"type="submit" name="Submit" value="View All Records">
 </form>
 </td>
</tr>
<tr>
 
<td>
<p><img src="images/calc.png" width="400" height="283"></p></td>
 <td>&nbsp;</td>
</tr>
</table>
<p>
<%@include file="Footer.jsp" %>
</p>
</body>
</html>