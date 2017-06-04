package com.duapp.ibmeye.domain;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "video")
public class Video {
	
	@Id
	@Column(name = "vid_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name = "vid_name")
	private String name;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "vid_date")
	private Date date;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "vid_start_time")
	private Date startTime;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "vid_finish_time")
	private Date finishTime;
	
	

	public Video() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HHmmss");
		this.startTime = new Date();
		this.date = (Date) startTime.clone();
		this.name = sdf.format(startTime) + ".m3u8";
		
	}
	
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Date getStartTime() {
		return startTime;
	}


	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}


	public Date getFinishTime() {
		return finishTime;
	}


	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	
}
