package com.duapp.ibmeye;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.duapp.ibmeye.video.Task;

@SpringBootApplication
@EnableScheduling
public class GaokaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GaokaoApplication.class, args);
	}
}
