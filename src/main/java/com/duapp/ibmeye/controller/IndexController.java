package com.duapp.ibmeye.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.duapp.ibmeye.config.TomatoConfig;
import com.duapp.ibmeye.domain.Video;
import com.duapp.ibmeye.repository.VideoRespository;


@Controller
public class IndexController {

	@Autowired
	VideoRespository videoRespository ;
	
	@Autowired
	TomatoConfig tomatoConfig;
	
	@RequestMapping("/")
	public String index( Model model ) {		
		ArrayList<Video> videos = (ArrayList<Video>)videoRespository.findAll();
		model.addAttribute("videos", videos);
		
		return "index";
	}
	
	@RequestMapping("/video/{video_id}")
	public String video(@PathVariable("video_id")String videoId, Model model) {
		
		Video video = videoRespository.findOne(Long.parseLong(videoId));
	
                model.addAttribute("video_url", tomatoConfig.getVideo().getRecordHlsBaseUrl() + video.getName() );
		return "video";
		
	}
	
	
	@RequestMapping("/live")
	public String video(Model model) {
		model.addAttribute("video_url", tomatoConfig.getVideo().getLiveRtmpUrl() );
		return "live";
		
	}
}
