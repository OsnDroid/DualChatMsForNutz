package com.osndroid.cttms.model.pla;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.ioc.loader.annotation.IocBean;

/**
 * 图文实体
 * 
 * @author OsnDroid
 *
 */
@IocBean
@Table("OSN_ARTICLES")
public class Articles {

	@Column("title")
	private String Title;
	@Column("description")
	private String Description;
	@Column("picUrl")
	private String PicUrl;
	@Column("url")
	private String Url;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

}
