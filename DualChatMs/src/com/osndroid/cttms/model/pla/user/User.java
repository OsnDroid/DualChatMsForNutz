package com.osndroid.cttms.model.pla.user;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.ioc.loader.annotation.IocBean;

/**
 * 
 * @author OsnDroid
 *
 */
@IocBean
public class User {
	@Column("openID")
	private String openID;
	@Column("phone")
	private String phone;
	
	public String getOpenID() {
		return openID;
	}
	public void setOpenID(String openID) {
		this.openID = openID;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
