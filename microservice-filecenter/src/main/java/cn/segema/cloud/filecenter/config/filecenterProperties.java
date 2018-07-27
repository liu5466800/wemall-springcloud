package cn.segema.cloud.filecenter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "segema.filecenter")
public class filecenterProperties {

	private String localDirectory = "/Users/wangyong/Downloads/test/testfiles/";

	private boolean dataSourceSave = false;

	public String getLocalDirectory() {
		return localDirectory;
	}

	public void setLocalDirectory(String localDirectory) {
		this.localDirectory = localDirectory;
	}

	public boolean isDataSourceSave() {
		return dataSourceSave;
	}

	public void setDataSourceSave(boolean dataSourceSave) {
		this.dataSourceSave = dataSourceSave;
	}

}
