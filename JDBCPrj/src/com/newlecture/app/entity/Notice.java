package com.newlecture.app.entity;

import java.util.Date;

public class Notice {
	private int id;
	private String title;
	private String writed_id;
	private String content;
	private Date regdate;
	private int hit;
	private String files;
	


	
	
	public Notice(int id, String title, String writed_id, String content, Date regdate, int hit, String files) {
		this.id = id;
		this.title = title;
		this.writed_id = writed_id;
		this.content = content;
		this.regdate = regdate;
		this.hit = hit;
		this.files = files;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWrited_id() {
		return writed_id;
	}
	public void setWrited_id(String writed_id) {
		this.writed_id = writed_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getFiles() {
		return files;
	}
	public void setFiles(String files) {
		this.files = files;
	}



	public Date getRegdate() {
		return regdate;
	}



	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
}
