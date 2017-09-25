package com.app.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.bean.TotalAppCount;
import com.app.bean.StoreBean;
import com.app.bean.AppDownlaodCount;
import com.app.dao.table.StoreDao;
import com.app.service.StoreService;

@RestController
public class InfoResource {

	@Autowired
	private StoreService storeService;

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET, value = "/app/list")
	public List<StoreBean> getApplist() {
		List<StoreDao> storeList = this.storeService.getAppList();
		List<StoreBean> storeBeanList = new ArrayList<StoreBean>();
		for (StoreDao store : storeList) {
			StoreBean storeBean = new StoreBean(store);
			storeBeanList.add(storeBean);
		}
		return storeBeanList;
	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET, value = "/app/count")
	public TotalAppCount getTotalappCount() {
		return this.storeService.getTotalAppCount();
	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET, value = "/app/count/{fileName}")
	public AppDownlaodCount getAppCount(@PathVariable(value = "fileName") String fileName) {
		return this.storeService.getAppDownloadCount(fileName);
	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET, value = "/app/name/{appName}")
	public StoreBean getAppInfoByName(@PathVariable(value = "appName") String appName) {
		StoreDao uStore = this.storeService.getAppInfoBySName(appName);
		return new StoreBean(uStore);
	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET, value = "/app/id/{appID}")
	public StoreBean getAppInfoByID(@PathVariable(value = "appID") int appID) {
		StoreDao uStore = this.storeService.getAppInfoById(appID);
		return new StoreBean(uStore);
	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET, value = "/app/tag/{tag}")
	public List<StoreBean> getAppInfoByTag(@PathVariable(value = "tag") String tag) {
		List<StoreDao> storeList = this.storeService.getAppInfoByTag(tag);
		List<StoreBean> storeBeanList = new ArrayList<StoreBean>();
		for (StoreDao store : storeList) {
			StoreBean storeBean = new StoreBean(store);
			storeBeanList.add(storeBean);
		}
		return storeBeanList;
	}

}