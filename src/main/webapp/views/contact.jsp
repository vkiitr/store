<%@ page import="com.utility.common.StoreConstant" %>
<html lang="en-US">
<head>
<title>Store</title>
<link rel="stylesheet" type="text/css" href="static/css/storestyle.css">
<!-- All your script functions start here -->
<script src="static/js/store.js">
	
</script>
<!-- All your functions ends here--->

</head>
<body>
<div class="wrapper">
    <a href="<%= StoreConstant.BASE_URI %>">
		<img src="static/img/logo.png" alt="xyz.com" >
	</a>
	<hr>
	<h1 style="text-align: center">Welcome to Store </h1>
	<hr>
	<br>
	<a href="<%= StoreConstant.BASE_URI %>"> Home </a>
	<br> <br>
	<p>
		Contact me at my mail id for any issues <br> <br> <a
			href="mailto:vkiitr@gmail.com">Vikas Kumar</a><br>
	</p>
</div>
<div class="push"></div>
	<hr>
	<p title="Other options">
		Click <a href="<%= StoreConstant.BASE_URI %>app/download">here</a>
		to download Utility setup script. it needs python 2.7 and above. <br>
		Click <a href="<%= StoreConstant.BASE_URI %>upload">here</a> to upload
		your app on to Store. <br> Click <a
			href="<%= StoreConstant.BASE_URI %>register">here</a> to register to
		get updates from Store. <br><br>
	</p>
	<hr>
	</div>
	<div class="footer">
		<p>Copyright (c) 2017</p>
	</div>
</body>
</html>