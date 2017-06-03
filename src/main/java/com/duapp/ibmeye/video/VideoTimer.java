package com.duapp.ibmeye.video;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.SimpleFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.duapp.ibmeye.domain.Video;
import com.duapp.ibmeye.repository.VideoRespository;

@Component 
public class VideoTimer {
	
	@Autowired
	private VideoConfig videoConfig;
	
	@Autowired
	private VideoRespository videoRespository;
	
	private Process curProcess;
	private Video curVideo;
	
	private SimpleDateFormat toDay = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat toSec = new SimpleDateFormat("HH:mm:ss");
	
	private Date startDate = null;
    //每3秒执行一次
    @Scheduled(fixedRate = 3000)
    public void timerRate() {
    	
    	
    	try {
    		
			if( curProcess != null ) {
			    
				curProcess.destroy();
				
				Date finishDate = new Date();
				
				// 12:58:54
				curVideo.setFinishDate( toSec.format(finishDate) );	
				
				videoRespository.save( curVideo );
			}
			
			startDate = new Date();
			
			curVideo = new Video();
			
			// 2015-11-28 12:38:24
			curVideo.setName( toDay.format(startDate) + " " +  toSec.format(startDate) );
			// 12:28:24
			curVideo.setStartDate( toSec.format(startDate) );
			// 2017-6-3 12:28:24.m3u8
		    curVideo.setFileName( curVideo.getName() + ".m3u8" );
		    String[] commands = {"sudo ffmpeg -re -i video.mp4 -codec:v libx264 -codec:a aac -map 0 -f hls  -hls_list_size 6 -hls_wrap 10 -hls_time 10 ", "/var/www/html/" + curVideo.getName() };
			curProcess = Runtime.getRuntime().exec(commands);
		    
		    // save
		    videoRespository.save(curVideo);
		} 
    	catch (Exception e) {
		}
    }
}
