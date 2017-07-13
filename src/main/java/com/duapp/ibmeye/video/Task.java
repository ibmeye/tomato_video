package com.duapp.ibmeye.video;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.duapp.ibmeye.config.TomatoConfig;
import com.duapp.ibmeye.domain.Video;
import com.duapp.ibmeye.repository.VideoRespository;

@Component
public class Task {
	
	@Autowired
	private TomatoConfig tomatoConfig;
	
	@Autowired
	private VideoRespository videoRespository;
	
	private String command;
	private Long duration;
	
	public Task() {
		this.command = tomatoConfig.getTask().getCommand();
		this.duration = tomatoConfig.getTask().getDuration();
	}
	public void run() {
		new Thread() {
			public void run() {
				Video video = new Video();
				
				initCommand(video);
				runCommand();
				
				video.setFinishTime(new Date());
				
				videoRespository.save(video);

			}

			private void initCommand( Video video ) {
				command = command + video.getName();
				
			}
			private void runCommand() {
				try {
					final Process process = Runtime.getRuntime().exec(command);
					new Thread() {
						public void run() {
							InputStream is = process.getInputStream();
							byte[] bits = new byte[1024]; 
							try {
								while(is.read(bits) != -1) {}
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}.start();
					new Thread() {
						public void run() {
							InputStream es = process.getErrorStream();
							byte[] bits = new byte[1024];
							try {
								
								while(es.read(bits) != -1 ) {}
							}
							catch (Exception e) {
								e.printStackTrace();
							}
						}
					}.start();
					Thread.sleep(duration);
					process.destroy();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
		
	}
}
