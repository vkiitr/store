package com.app.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

	@RequestMapping("*")
	public String getHomeViewPage() {
		return "home";
	}

	@RequestMapping(value = "/upload")
	public String getUploadViewPage() {
		return "upload";
	}

	@RequestMapping(value = "/details")
	public String getdetailViewPage() {
		return "details";
	}

	@RequestMapping(value = "/contact")
	public String getdetailContactPage() {
		return "contact";
	}
}
