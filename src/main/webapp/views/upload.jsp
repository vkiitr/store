<%@ page import="com.app.common.StoreConstant" %>
<html lang="en-US">
<head>
<title>Store</title>
<link rel="stylesheet" type="text/css" href="static/css/storestyle.css">
<!-- All your script functions start here -->
<script src="static/js/store.js">
	
</script>
</head>

<body>
	<div class="wrapper">
		<div id="header">
			<a href="<%= StoreConstant.BASE_URI %>">
				<img src="static/img/logo.png" alt="xyz.com" >
			</a>
			<hr>
			<h1 style="text-align: center">Welcome to Store </h1>
			<hr>
		</div>
		<br>
	<a href="<%= StoreConstant.BASE_URI %>"> Home </a>
	<br><br>
		<span
			style="font-weight: 600; font-size: 20px; color: #666; line-height: 250%; text-transform: uppercase; letter-spacing: 1.5px;">Upload
			your apps </span> 
		<br>

		<form action="app/upload" method="post"
			enctype="multipart/form-data">

			<span
				style="font-weight: 600; font-size: 15px; color: #666; line-height: 250%; text-transform: uppercase; letter-spacing: 1.5px;">App
				Name : </span><input type="text" name="uname" id="uname" required><br>
			<span
				style="font-weight: 600; font-size: 15px; color: #666; line-height: 250%; text-transform: uppercase; letter-spacing: 1.5px;">Author
				: </span><input type="text" name="uauthor" id="uauthor"><br> <span
				style="font-weight: 600; font-size: 15px; color: #666; line-height: 250%; text-transform: uppercase; letter-spacing: 1.5px;">Mail
				id : </span><input type="email" name="umail" id="umail"> (will be
			used to send notifications)<br> <span
				style="font-weight: 600; font-size: 15px; color: #666; line-height: 250%; text-transform: uppercase; letter-spacing: 1.5px;">Searching
				Tags : </span><input type="tag" name="searchtag" id="tag"> (enter
			comma separated list of tags)<br> <span
				style="font-weight: 600; font-size: 15px; color: #666; line-height: 250%; text-transform: uppercase; letter-spacing: 1.5px;">Supported
				Platforms : </span> <input type="checkbox" name="os" value="windows"
				id="uwin"><span
				style="font-weight: 600; font-size: 12px; color: #666; line-height: 250%; text-transform: uppercase; letter-spacing: 1.5px;">Windows
			</span> <input type="checkbox" name="os" value="unix" id="uwin"><span
				style="font-weight: 600; font-size: 12px; color: #666; line-height: 250%; text-transform: uppercase; letter-spacing: 1.5px;">Unix
			</span> <br> <span
				style="font-weight: 600; font-size: 15px; color: #666; line-height: 250%; text-transform: uppercase; letter-spacing: 1.5px;">Description
				: </span><br>
			<textarea name="udesc" id="udesc" rows="10" cols="30" required></textarea>
			<br> <br> <span
				style="font-weight: 600; font-size: 15px; color: #666; line-height: 250%; text-transform: uppercase; letter-spacing: 1.5px;">Upload
				file : </span><input type="file" name="file" id="utility_input"
				onchange="checkFile(this)" required><br>(Upload files
			in only tar.gz format) <br> <br> <input type="submit"
				value="Upload app" /> <br> <br>
		</form>
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
