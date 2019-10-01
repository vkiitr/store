<%@ page import="com.app.common.StoreConstant" %>
<!DOCTYPE html>
<html lang="en-US">
<head>
<title>Store</title>
<link rel="stylesheet" type="text/css" href="static/css/storestyle.css">
</head>
<body onload="displayAppDetails()">
	<!-- All your script functions start here -->
	<script src="static/js/store.js"></script>
	<div class="wrapper">
	<!-- All your functions ends here--->
	<a href="<%= StoreConstant.BASE_URI %>">
		<img src="static/img/logo.png" alt="xyz.com" >
	</a>
	<hr>
	<h1 style="text-align: center">Welcome to Store </h1>
	<hr>
	<br>
	<a href="<%= StoreConstant.BASE_URI %>"> Home </a>
	<br><br>
	<b id="appCount" style="font-size: 200%;">Details of apps
		are listed below</b><br>
	<div id="appDetails"></div>
	
	</div>
	<div class="push"></div>
	<hr>
	<p title="Other options">
		Click <a href="<%= StoreConstant.BASE_URI %>app/download">here</a>
		to download store setup script. it needs python 2.7 and above. <br>
		Click <a href="<%= StoreConstant.BASE_URI %>upload">here</a> to upload
		your app on to  Store. <br> Click <a
			href="<%= StoreConstant.BASE_URI %>register">here</a> to register to
		get updates from Store. <br><br>
		<a href="<%= StoreConstant.BASE_URI %>contact">Contact Us</a>
	</p>
	<hr>
	</div>
	<div class="footer">
		<p>Copyright (c) 2016</p>
	</div>
</body>
</html>
