package cn.segema.cloud.filecenter.domain;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "FILE_FILECENTER")
@Entity
public class Filecenter {
	@Id
	@Column(name="FILEID")
	private BigInteger fileId;
	
	@Column(name="FILENAME")
	private String fileName;
	
	@Column(name="BUSINESSID")
	private BigInteger businessId;
	
	@Column(name="BUSINESSCODE")
	private String businessCode;
	
	@Column(name="ABSOLUTEPATH")
	private String absolutePath;
	
	@Column(name="RELATIVEPATH")
	private String relativePath;
	
	@Column(name="SUFFIX")
	private String suffix;
	
	@Column(name="FIILETYPE")
	private String fileType;
	
	@Column(name="TOTALSIZE")
	private BigDecimal totalSize;
	
	@Column(name="FILECONTENT")
	private byte[] fileContent;
	
	@Column(name="DESCRIPTION")
	private String description;

	public BigInteger getFileId() {
		return fileId;
	}

	public void setFileId(BigInteger fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public BigInteger getBusinessId() {
		return businessId;
	}

	public void setBusinessId(BigInteger businessId) {
		this.businessId = businessId;
	}

	public String getBusinessCode() {
		return businessCode;
	}

	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}

	public String getAbsolutePath() {
		return absolutePath;
	}

	public void setAbsolutePath(String absolutePath) {
		this.absolutePath = absolutePath;
	}

	public String getRelativePath() {
		return relativePath;
	}

	public void setRelativePath(String relativePath) {
		this.relativePath = relativePath;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public BigDecimal getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(BigDecimal totalSize) {
		this.totalSize = totalSize;
	}

	public byte[] getFileContent() {
		return fileContent;
	}

	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
