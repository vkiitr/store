package com.app.bean;

import java.util.ArrayList;
import java.util.List;

import com.app.dao.table.StoreDao;

public class StoreBean {

	private int sId;
	private String name;
	private String fileName;
	private String description;
	private String developerName;
	private String developerEmail;
	private double version;
	private String searchingTag;
	private int downloadCount;
	private List<String> platformSupported;
	private Long createTime;
	private Long updatedTime;

	public StoreBean() {
		// TODO Auto-generated constructor stub
	}

	public StoreBean(int sId, String name, String fileName, String description, String developerName,
			String developerEmail, double version, String searchingTag, int downloadCount,
			List<String> platformSupported, Long createTime, Long updatedTime) {
		super();
		this.sId = sId;
		this.name = name;
		this.fileName = fileName;
		this.description = description;
		this.developerName = developerName;
		this.developerEmail = developerEmail;
		this.version = version;
		this.searchingTag = searchingTag;
		this.downloadCount = downloadCount;
		this.platformSupported = platformSupported;
		this.updatedTime = updatedTime;
		this.createTime = createTime;
	}

	public StoreBean(StoreDao store) {
		this.sId = store.getSId();
		this.name = store.getSName();
		this.fileName = store.getFileName();
		this.description = store.getDescription();
		this.developerName = store.getDeveloperName();
		this.developerEmail = store.getDeveloperEmail();
		this.version = store.getVersion();
		this.searchingTag = store.getSearchingTag();
		this.downloadCount = store.getDownloadCount();
		this.platformSupported = getPlatformListFromString(store.getPlatformSupported());
		this.createTime = store.getCreateTime();
		this.updatedTime = store.getUpdatedTime();
	}

	public int getSId() {
		return this.sId;
	}

	public void setSId(int sId) {
		this.sId = sId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDeveloperName() {
		return this.developerName;
	}

	public void setDeveloperName(String developerName) {
		this.developerName = developerName;
	}

	public String getDeveloperEmail() {
		return this.developerEmail;
	}

	public void setDeveloperEmail(String developerEmail) {
		this.developerEmail = developerEmail;
	}

	public List<String> getPlatformSupported() {
		return this.platformSupported;
	}

	public void setPlatformSupported(List<String> os) {
		this.platformSupported = os;
	}

	
	public double getVersion() {
		return this.version;
	}

	public void setVersion(double version) {
		this.version = version;
	}

	public String getSearchingTag() {
		return this.searchingTag;
	}

	public void setSearchingTag(String searchingTag) {
		this.searchingTag = searchingTag;
	}

	public Long getUpdatedTime() {
		return this.updatedTime;
	}

	public void setUpdatedTime(Long updatedTime) {
		this.updatedTime = updatedTime;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getDownloadCount() {
		return this.downloadCount;
	}

	public void setDownloadCount(int downloadCount) {
		this.downloadCount = downloadCount;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public List<String> getPlatformListFromString(String platform) {
		List<String> platformSupported = new ArrayList<String>();
		String platformSupportedArr[] = platform.split(":");
		for (String plat : platformSupportedArr) {
			platformSupported.add(plat);
		}
		return platformSupported;
	}

	public String getPlatformStringFromList(List<String> platform) {
		StringBuilder platformSupported = new StringBuilder();
		for (String plat : platform) {
			platformSupported.append(plat).append(":");
		}
		return platformSupported.toString();
	}

	@Override
	public String toString() {
		return "StoreBean [sId=" + sId + ", name=" + name + ", fileName=" + fileName + ", description="
				+ description + ", developerName=" + developerName + ", developerEmail=" + developerEmail + ", version="
				+ version + ", searchingTag=" + searchingTag + ", downloadCount=" + downloadCount
				+ ", platformSupported=" + platformSupported + ", createTime=" + createTime + ", updatedTime="
				+ updatedTime + "]";
	}
}
