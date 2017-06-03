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
	
	private Process process;
	
	private SimpleDateFormat toDay = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat toSec = new SimpleDateFormat("HH:mm:ss");
	
	private Date startDate = null;
    //每3秒执行一次
    @Scheduled(fixedRate = 3000)
    public void timerRate() {
    	
    	String[] commands = {"notepad"};
    	try {
    		
			if( process != null ) {
				process.destroy();
				
				Date finishDate = new Date();
				
				Video video = new Video();
				// 2015-11-28 
				video.setName( toDay.format(startDate) + " " +  toSec.format(startDate) + "-" + toSec.format(finishDate) );
				System.out.println(video.getName());
				// 12:28:24
				video.setStartDate(  toSec.format(startDate) );
				System.out.println(video.getStartDate());
				// 12:58:54
				video.setFinishDate( toSec.format(finishDate) );
				System.out.println(video.getFinishDate());
				// 2017-6-3 12:28:24.m3u8
				video.setFileName( toDay.format(startDate) + " " + video.getStartDate() + ".m3u8" );
				System.out.println(video.getFileName());
				videoRespository.save(video);
			}
			
			startDate = new Date();
			// 2017-6-3 12:28:24.m3u8
			process = Runtime.getRuntime().exec(commands);
			
//			System.out.println( videoConfig.getHttpUrl());
		} 
    	catch (Exception e) {
		}
    }
}
