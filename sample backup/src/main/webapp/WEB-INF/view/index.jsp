<%-- <!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
	</head> 
	<body>
<form action="loginhere"method="get">
		<a href=loginhere>Click to enter</a></form>
		
<form action="submituser"method="get">		
		<a href=submituser>Click to enter user</a></form>
	</body>
</html>


 --%>
 
 
  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Premium Calculation</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="jquery.monthpicker.min.js"></script>
</head>
<body>

<table id="Table1"  border="0" cellspacing="0" cellpadding="0" runat="Server"  style="width:106%" >
               
               
		<tr align="left">
<!-- 		<td style="width: 100%; height: 105px;" align="right"></td> -->
			 <td style="margin-top:-5px; width:1365px; color:white; font-weight:lighter; font-family:Colonna MT; font-size:44pt;
                       margin-left:60px; background-color: #5dc6a5">Premium Calculation</td> 
		</tr>
</table>




<form action="viewdata.jsp"method="get">
<div style="height: 15px; width: 20;margin-top:55px; padding: 50px 600px 1px;font-weight:bold;font-size:15px" >Welcome Here</div>
		<div style="height: 15px;margin-top:-45px; width: 20; padding: 120px 600px 10px; size: 50px">
		<button class="button" style="color: white; background-color: #5dc6a5">View All Details</button>
				
		</div>
</form>


<div style="height:115px; border-top:1px solid #e5e5e5; padding:-20px; clear:both; bottom:0;position:absolute;width:106%;">
<div class="nine_font" style="padding:60px 50px 0 0; background-color: #5dc6a5" >© 2017 Cognizant Technology Solutions.<br />
        All rights reserved.</div>
</div>
</body>
</html>
 