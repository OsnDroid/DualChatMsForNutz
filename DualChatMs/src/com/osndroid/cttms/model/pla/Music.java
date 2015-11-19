package com.osndroid.cttms.model.pla;

/**
 * 音乐实体
 * @author OsnDroid
 *
 */
public class Music {

	private String title;
	private String description;
	//音乐链接
	private String musicUrl;
	//高品质音乐链接
	private String hQMusicUrl;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMusicUrl() {
		return musicUrl;
	}
	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}
	public String gethQMusicUrl() {
		return hQMusicUrl;
	}
	public void sethQMusicUrl(String hQMusicUrl) {
		this.hQMusicUrl = hQMusicUrl;
	}
	
	
}
