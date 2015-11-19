package com.osndroid.cttms.model.pla.menu;

/**
 * 菜单按钮
 * @author OsnDroid
 *
 */
public class MenuButton extends Menu {
	
	private String type;
	private String key;
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}