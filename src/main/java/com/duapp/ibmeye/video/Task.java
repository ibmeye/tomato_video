package com.duapp.ibmeye.video;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.duapp.ibmeye.config.TomatoConfig;
import com.duapp.ibmeye.domain.Video;
import com.duapp.ibmeye.repository.VideoRespository;

@Component
@Scope("prototype")
public class Task {
	
	@Autowired
	private TomatoConfig tomatoConfig;
	
	@Autowired
	private VideoRespository videoRespository;

	private String command;
	private Process process;
	private Video video;
	private Long duration;
	private Boolean state;
	
	
	public Task() {
		this.process = null;
		this.video = null;
		this.duration = 0L;
		this.state = false;
		
		
	}
	
	public void exec() {
		this.video = new Video();
		this.command = tomatoConfig.getTask().getCommand();
//		command = String.format(command, this.video.getName());
		try {
//			this.process = Runtime.getRuntime().exec(command);
			System.out.println(command);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.duration = 0L;
		this.state = true;
	}
	
	public void destory() {
//		this.process.destroy();
		System.out.println("process  destory" + " " + this.video.getName() + " " + this.duration );
		this.process = null;
		
		this.video.setFinishTime(new Date());
		videoRespository.save(this.video);
		
		this.video = null;
		this.duration = 0L;
		this.state = false;
		

	}

	public Boolean getState() {
		return state;
	}
	
	public void addDuration( Long add ) {
		this.duration += add;
	}
	
	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	

	public void setState(Boolean state) {
		this.state = state;
	}
}
