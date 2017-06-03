package com.duapp.ibmeye.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.duapp.ibmeye.domain.Video;
import com.duapp.ibmeye.repository.VideoRespository;
import com.duapp.ibmeye.video.VideoConfig;


@Controller
public class IndexController {

	@Autowired
	VideoRespository videoRespository ;
	
	@Autowired
	VideoConfig videoConfig;
	
	@RequestMapping("/")
	public String index( Model model ) {		
		ArrayList<Video> videos = (ArrayList<Video>)videoRespository.findAll();
		model.addAttribute("videos", videos);
		return "index";
	}
	
	@RequestMapping("/video/{video_id}")
	public String video(@PathVariable("video_id")String videoId, Model model) {
		
		Video video = videoRespository.findOne(Long.parseLong(videoId));
	

		model.addAttribute( "video_url", videoConfig.getHttpUrl() + "/" + video.getFileName() );
		System.out.println(videoConfig.getHttpUrl() + "/" + video.getFileName());
		return "video";
		
	}
}
