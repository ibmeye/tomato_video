package com.duapp.ibmeye.video;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="video")
public class VideoConfig {
	private String host;
	private String dirName;

	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getDirName() {
		return dirName;
	}
	public void setDirName(String dirName) {
		this.dirName = dirName;
	}
	public String getHttpUrl() {
		return "http://" + host + "/" + dirName;
	}
}
