package com.app.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.app.bean.TotalAppCount;
import com.app.bean.AppDownlaodCount;
import com.app.common.HtmlPageConstant;
import com.app.common.StoreConstant;
import com.app.dao.repository.StoreRepository;
import com.app.dao.table.StoreDao;

@Service
public class StoreServiceImp implements StoreService {

	private static final String LOCATION = StoreConstant.STORE_DB;

	@Autowired
	private StoreRepository SRepository;

	@Override
	public String uploadApp(MultipartFile file) {
		String fileName = "";

		if (!file.isEmpty()) {
			try {
				fileName = file.getOriginalFilename();
				String fileLocation = LOCATION + fileName;
				byte[] bytes = file.getBytes();
				BufferedOutputStream buffStream = new BufferedOutputStream(
						new FileOutputStream(new File(fileLocation)));
				buffStream.write(bytes);
				buffStream.close();
				return HtmlPageConstant.uploadSuccessMessage(fileName);
			} catch (Exception e) {
				return HtmlPageConstant.uploadFailMessage(fileName);
			}
		} else {
			return HtmlPageConstant.uploadFailMessage(fileName);
		}
	}

	@Override
	public void saveInfoIntoDB(StoreDao store) {
		StoreDao storeExists = getAppInfoBySName(store.getSName());

		if (storeExists == null) {
			store.setVersion(1.0);
			store.setDownloadCount(0);
			long current_time = System.currentTimeMillis();
			store.setCreateTime(current_time);
			store.setUpdatedTime(current_time);
			SRepository.save(store);
			System.out.println("Created");
		} else {
			// TODO ustore data from request and existing data should be in sync
			double version = storeExists.getVersion();
			version = version + 0.1;
			int scale = (int) Math.pow(10, 1);
			version = (double) Math.round(version * scale) / scale;
			storeExists.setVersion(version);
			storeExists.setUpdatedTime(System.currentTimeMillis());
			SRepository.save(storeExists);
			System.out.println("Updated");
		}
	}

	// Download App
	@Override
	public void downloadAppByName(HttpServletResponse response, String fileName) throws IOException {

		String FILE_PATH = LOCATION + fileName;
		File file = new File(FILE_PATH);

		if (!file.exists()) {
			String errorMessage = HtmlPageConstant.DOWNLOAD_ERROR_NOT_FOUND;
			System.out.println(errorMessage);
			OutputStream outputStream = response.getOutputStream();
			outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
			outputStream.close();
			return;
		}

		String mimeType = URLConnection.guessContentTypeFromName(file.getName());
		if (mimeType == null) {
			System.out.println("mimetype is not detectable, will take default");
			mimeType = "application/octet-stream";
		}

		System.out.println("mimetype : " + mimeType);

		response.setContentType(mimeType);

		/*
		 * "Content-Disposition : inline" will show viewable types [like
		 * images/text/pdf/anything viewable by browser] right on browser while
		 * others(zip e.g) will be directly downloaded [may provide save as
		 * popup, based on your browser setting.]
		 */
		response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));

		/*
		 * "Content-Disposition : attachment" will be directly download, may
		 * provide save as pop up, based on your browser setting
		 */
		// response.setHeader("Content-Disposition", String.format("attachment;
		// filename=\"%s\"", file.getName()));

		response.setContentLength((int) file.length());

		InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

		// Copy bytes from source to destination, closes both streams.
		FileCopyUtils.copy(inputStream, response.getOutputStream());

		incrementDownloadCount(fileName);

	}

	synchronized private boolean incrementDownloadCount(String fileName) {
		StoreDao storeExists = getAppByFileName(fileName);
		if (storeExists != null) {
			storeExists.setDownloadCount(storeExists.getDownloadCount() + 1);
			SRepository.save(storeExists);
			System.out.println("find");
			return true;
		} else {
			System.out.println("Given App Doesn't exists.");
			return false;
		}
	}

	@Override
	public List<StoreDao> getAppList() {
		List<StoreDao> storeList = new ArrayList<StoreDao>();
		Iterable<StoreDao> storeItr = SRepository.findAll();
		for (StoreDao store : storeItr) {
			storeList.add(store);
		}
		return storeList;
	}

	@Override
	public List<StoreDao> getAppInfoByTag(String tag) {
		List<StoreDao> storeList = new ArrayList<StoreDao>();
		Iterable<StoreDao> storeItr = SRepository.findAll();

		for (StoreDao store : storeItr) {
			String tags = store.getSearchingTag();
			if (tags.contains(tag)) {
				storeList.add(store);
			}
		}
		return storeList;
	}

	@Override
	public AppDownlaodCount getAppDownloadCount(String fileName) {
		StoreDao storeExists = getAppByFileName(fileName);

		if (storeExists != null) {
			System.out.println("find");
		} else {
			System.out.println("Given app Doesn't exists.");
		}

		if (storeExists != null) {
			return new AppDownlaodCount(storeExists.getDownloadCount());
		}
		// No file exists with this name
		return new AppDownlaodCount(0);
	}

	@Override
	public TotalAppCount getTotalAppCount() {
		return new TotalAppCount(SRepository.count());
	}

	@Override
	public StoreDao getAppInfoBySName(String appName) {
		StoreDao storeExists = null;
		try {
			storeExists = SRepository.findBySNameIgnoreCase(appName);
		} catch (Exception e) {
			System.out.println("DBException: fetching utlityInfo");
			throw e;
		}
		if (storeExists != null) {
			System.out.println("find");
		} else {
			System.out.println("Given app Doesn't exists.");
		}
		return storeExists;
	}

	@Override
	public StoreDao getAppInfoById(int sId) {
		StoreDao storeExists = null;
		try {
			storeExists = SRepository.findBySId(sId);
		} catch (Exception e) {
			System.out.println("DBException: fetching utlityInfo");
			throw e;
		}

		if (storeExists != null) {
			System.out.println("find");
		} else {
			System.out.println("Given app Doesn't exists.");
		}
		return storeExists;

	}

	@Override
	public StoreDao getAppByFileName(String fileName) {
		StoreDao storeExists = null;
		try {
			storeExists = SRepository.findByFileNameIgnoreCase(fileName);
		} catch (Exception e) {
			System.out.println("DBException: fetching utlityInfo");
			throw e;
		}

		if (storeExists != null) {
			System.out.println("find");
		} else {
			System.out.println("Given app Doesn't exists.");
		}
		return storeExists;
	}
}
