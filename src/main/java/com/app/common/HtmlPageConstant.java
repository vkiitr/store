package com.app.common;

public class HtmlPageConstant {
	
	public static final String HEADER = "<html lang=\"en-US\">"
			+ "<head>"
			+ "<title>Store</title>"
			+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"../static/css/storestyle.css\">"
			+ "<!-- All your script functions start here -->"
			+ "<script src=\"../static/js/store.js\">	</script>"
			+ "	</head>"
			+ "<body>"
			+ "<div class=\"wrapper\"> <a href=" + StoreConstant.BASE_URI + ">"
			+ "<img src=\"../static/img/logo.png\" alt=\"xyz.com\"></a><hr>"
			+ "<h1 style=\"text-align: center\">Welcome to App Store</h1> <hr> <br> "
			+ "<a href=" + StoreConstant.BASE_URI + "> Home </a> <br> <br> ";
	
	public static final String BOTTOM =	"<div class=\"push\"></div> <hr> "
			+ "<p title=\"Other options\">"
			+ "Click <a href=" + StoreConstant.BASE_URI + "/app/download>here</a>"
			+ "to download Store setup script. it needs python 2.7 and above. <br>"
			+ "Click <a href=" + StoreConstant.BASE_URI + "/upload>here</a> to upload your app on to Store. <br> "
			+ "Click <a href=" + StoreConstant.BASE_URI + "/register>here</a> to register to get updates from Store. "
			+ "<br><br> <a href=" + StoreConstant.BASE_URI + "/contact\">Contact Us</a></p> <hr> </div>"
			+ "<div class=\"footer\"> <p>Copyright (c) 2017</p> </div>"
			+ "</body>"
			+ "</html>";
	
	public static final String DOWNLOAD_ERROR_NOT_FOUND =	HEADER	+ "<h3> 404 NOT FOUND!!" + " <h3>" 
			+ "<p>Sorry, The file you are looking for does not exist.</div>" + BOTTOM;
	
	public static String uploadSuccessMessage(String fileName) {
		return HEADER	+ "<h3> 200 OK!!" + " <h3>" 
				+ "<p>You have successfully uploaded " + fileName + ".</div>" + BOTTOM;
	}
	
	public static String uploadFailMessage(String fileName) {
		return HEADER	+ "<h3> Error!!" + " <h3>" 
				+ "<p> Unable to upload " + fileName + ".</div>" + BOTTOM;
	}
}
