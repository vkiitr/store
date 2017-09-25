package com.app.resource;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.common.StoreConstant;
import com.app.dao.table.StoreDao;
import com.app.service.StoreService;

@RestController
public class MainResource {

	@Autowired
	private StoreService storeService;

	@RequestMapping(value = "/app/upload", method = RequestMethod.POST)
	public @ResponseBody String uploadapp(@RequestParam("file") MultipartFile file,
			@RequestParam("uname") String name, @RequestParam("udesc") String udesc,
			@RequestParam("umail") String umail, @RequestParam("os") List<String> os,
			@RequestParam("uauthor") String uauthor, @RequestParam("searchtag") String searchingTag) {
		
		StoreDao store = new StoreDao();
		store.setSName(name);
		store.setDescription(udesc);
		store.setDeveloperEmail(umail);
		store.setDeveloperName(uauthor);
		store.setPlatformSupported(store.getPlatformStringFromList(os));
		store.setFileName(file.getOriginalFilename());
		if (searchingTag.equals("")) {
			searchingTag = " ";
		}
		store.setSearchingTag(searchingTag);

		if (!file.isEmpty()) {
			this.storeService.saveInfoIntoDB(store);
			// saving file
			return this.storeService.uploadApp(file);
		} else {
			return "Unable to upload. File is empty.";
		}
	}

	@RequestMapping(value = "/app/download", method = RequestMethod.GET)
	public void downloadDefaultApp(HttpServletResponse response) throws IOException {
		this.storeService.downloadAppByName(response, StoreConstant.DEFAULT_STORE_SCRIPT);
	}

	@RequestMapping(value = "/app/download/{fileName}", method = RequestMethod.GET)
	public void downloadApp(HttpServletResponse response, @PathVariable("fileName") String fileName)
			throws IOException {
		fileName += ".gz";
		this.storeService.downloadAppByName(response, fileName);
	}
}
