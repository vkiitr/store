<%@ page import="com.app.common.StoreConstant" %>
<html lang="en-US">
<head>
<title>Store</title>
<link rel="stylesheet" type="text/css" href="static/css/storestyle.css">
<!-- All your script functions start here -->
<script src="static/js/store.js">
	
</script>
<!-- All your functions ends here--->

</head>

<body onload="readNumberOfApps();displayAllApps()">
	<div class="wrapper">
	<div id="header">
		<a href="<%= StoreConstant.BASE_URI %>">
			<img src="static/img/logo.png" alt="veritas.com" >
	    </a>
		<hr>
		<h1 style="text-align: center">Welcome to Store</h1>
		<hr>
	</div>
	<b id="appCount" style="font-size: 200%;"></b> apps are
	currently hosted on this Store


	<div id="apps">

		<table id="apptable" style="width: 100%">
			<caption>App Table</caption>
			<tr>
				<th style="width: 7%">ID</th>
				<th style="width: 16%">Name</th>
				<th style="width: 45%">Description</th>
				<th style="width: 16%">Developer Name</th>
				<th style="width: 16%">Download count</th>
			</tr>
		</table>

	</div>
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
