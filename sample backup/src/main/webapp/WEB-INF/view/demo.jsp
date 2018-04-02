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

<table id="Table1"  border="0" cellspacing="0" cellpadding="0" runat="Server"  style="width:100%" >
               
               
		<tr align="left">
<!-- 		<td style="width: 100%; height: 105px;" align="right"></td> -->
			 <td style="margin-top:-5px; width:1365px; color:white; font-weight:lighter; font-family:Colonna MT; font-size:44pt;
                       margin-left:60px; background-color: #15592e">Premium Calculation</td> 
		</tr>
</table>




<form action="demo"method="post">
<div style="height: 15px; width: 500;margin-top:55px; padding: 50px 300px 40px 490px;font-weight:bold;font-size:23px;font-family:Colonna MT" >Welcome TO The Premium Calculator</div>
		<div style="height: 15px;margin-top:-45px; width: 20; padding: 120px 200px 10px 500px; size: 50px">
		<label style = "font-family:Colonna MT; font-size: 19px;">Enter Policy number</label>
		
		
		
		<input type=text name=policynumber style="font-size: 11px;font-weight: bold">
		
		
		
		
	<label style = "font-family:Colonna MT; font-size: 19px;">Premium Value from DB</label>
		
		
		<input type=text name=premiumamount style="font-size: 11px;font-weight: bold"> 
		</div>
		<div style="color: white; padding:50px 200px 40px 620px">
		<button class="button" style="color: white; background-color: #22914b;">Show Premium</button>
		<!-- <button class="btn btn-primary" style="background-color:#52949b" onclick="editAssociate({{AssociateID}})"><span title="edit"
							class="glyphicon glyphicon-pencil" style="color:white;background-color:#52949b"></span></button> -->
		</div>
</form>


<div style="height:80px; border-top:1px solid #e5e5e5; padding:-20px; clear:both; bottom:0;position:absolute;width:100%;">
<div class="nine_font" style="padding:30px 20px 30px 20px; text-align:center; background-color: #15592e;color: white" >© 2017 Cognizant Technology Solutions.<br />
        All rights reserved.</div>
</div>
</body>
</html>
 