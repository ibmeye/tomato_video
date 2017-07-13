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
	private Task task;

    @Scheduled( fixedRate = 60000 )
    public void startRate() {
    	task.run();
    }
}

