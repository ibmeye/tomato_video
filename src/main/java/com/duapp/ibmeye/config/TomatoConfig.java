package com.duapp.ibmeye.config;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@ConfigurationProperties(prefix="tomato")
@Validated
public class TomatoConfig {
	@Valid
	private Task task = new Task();
	@Valid
	private Video video = new Video();
	
	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public static class Task {
		@NotEmpty
		private String command;

		public String getCommand() {
			return command;
		}

		public void setCommand(String command) {
			this.command = command;
		}
	}
	
	public static class Video {
		@NotEmpty
		private String recordHlsBaseUrl;
		
		@NotEmpty
		private String liveRtmpUrl;

		public String getRecordHlsBaseUrl() {
			return recordHlsBaseUrl;
		}

		public void setRecordHlsBaseUrl(String recordHlsBaseUrl) {
			this.recordHlsBaseUrl = recordHlsBaseUrl;
		}

		public String getLiveRtmpUrl() {
			return liveRtmpUrl;
		}

		public void setLiveRtmpUrl(String liveRtmpUrl) {
			this.liveRtmpUrl = liveRtmpUrl;
		}
	}
}
