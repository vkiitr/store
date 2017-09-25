package com.app.dao.table;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Store")
public class StoreDao {

	@Id
	@Column(name = "SId", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sId;

	@Column(name = "SName")
	private String sName;

	@Column(name = "FileName")
	private String fileName;

	@Column(name = "Description")
	private String description;

	@Column(name = "DeveloperName")
	private String developerName;

	@Column(name = "DeveloperEmail")
	private String developerEmail;

	@Column(name = "Version")
	private double version;

	@Column(name = "SearchingTag")
	private String searchingTag;

	@Column(name = "DownloadCount")
	private int downloadCount;

	@Column(name = "PlatformSupported")
	private String platformSupported;

	@Column(name = "CreatedDateTime")
	private Long createTime;

	@Column(name = "LastUpdatedDateTime")
	private Long updatedTime;

	public StoreDao() {
		// TODO Auto-generated constructor stub
	}

	public int getSId() {
		return sId;
	}

	public void setSId(int sId) {
		this.sId = sId;
	}

	public String getSName() {
		return sName;
	}

	public void setSName(String sName) {
		this.sName = sName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDeveloperName() {
		return developerName;
	}

	public void setDeveloperName(String developerName) {
		this.developerName = developerName;
	}

	public String getDeveloperEmail() {
		return developerEmail;
	}

	public void setDeveloperEmail(String developerEmail) {
		this.developerEmail = developerEmail;
	}

	public double getVersion() {
		return version;
	}

	public void setVersion(double version) {
		this.version = version;
	}

	public String getSearchingTag() {
		return searchingTag;
	}

	public void setSearchingTag(String searchingTag) {
		this.searchingTag = searchingTag;
	}

	public Long getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Long updatedTime) {
		this.updatedTime = updatedTime;
	}

	public int getDownloadCount() {
		return downloadCount;
	}

	public void setDownloadCount(int downloadCount) {
		this.downloadCount = downloadCount;
	}

	public String getPlatformSupported() {
		return platformSupported;
	}

	public void setPlatformSupported(String platformSupported) {
		this.platformSupported = platformSupported;
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
		return "Store [sId=" + sId + ", sName=" + sName + ", fileName=" + fileName
				+ ", description=" + description + ", developerName=" + developerName + ", developerEmail="
				+ developerEmail + ", version=" + version + ", searchingTag=" + searchingTag + ", downloadCount="
				+ downloadCount + ", platformSupported=" + platformSupported + ", createTime=" + createTime
				+ ", updatedTime=" + updatedTime + "]";
	}

}
