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
public class TaskTimer {
	
	@Autowired
	private Task task1;
	
	@Autowired
	private Task task2;
	
	@Scheduled( initialDelay = 1000, fixedRate = 1000 )
	public void finishRate() {
		
		if( task1.getState() == true ) {
			task1.addDuration(1000L);
			if( task1.getDuration() >= 1800000L ) {
				task1.destory();
				System.out.println("task1 ended");
			}
		}
		
		if( task2.getState() == true ) {
			task2.addDuration(1000L);
			if( task2.getDuration() >= 1800000L ) {
				task2.destory();
				System.out.println("task2 ended");
			}
		}
    }
    
    
    @Scheduled( fixedRate = 1700000 )
    public void startRate() {
    	if( task1.getState() == false ) {
    		System.out.println("task1 started");
    		task1.exec();
    	}
    	else if( task2.getState() == false ) {
    		System.out.println("task2");
    		task2.exec();
    	}
    	
    }
}

