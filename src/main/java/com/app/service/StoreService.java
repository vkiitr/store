package com.app.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.app.bean.TotalAppCount;
import com.app.bean.AppDownlaodCount;
import com.app.dao.table.StoreDao;

public interface StoreService {

	public String uploadApp(MultipartFile file);

	public void saveInfoIntoDB(StoreDao ustore);

	public void downloadAppByName(HttpServletResponse response, String fileName) throws IOException;

	public List<StoreDao> getAppList();

	public List<StoreDao> getAppInfoByTag(String tag);

	public AppDownlaodCount getAppDownloadCount(String fileName);

	public TotalAppCount getTotalAppCount();

	public StoreDao getAppInfoBySName(String appName);

	public StoreDao getAppByFileName(String fileName);

	public StoreDao getAppInfoById(int appId);
}
