package com.osndroid.cttms.model.pla.request;

import org.nutz.dao.entity.annotation.Table;

import com.osndroid.cttms.model.pla.News;



/**
 * 地理位置消息类
 * @author OsnDroid
 *
 */
@Table("OSN_USER_OPERATION")//用户操作记录表
public class LocationReq extends News{
	
	private String Location_X;
	private String Location_Y;
	private String Scale;
	private String Label;
	private String MsgId;
	
	public String getLocation_X() {
		return Location_X;
	}
	public void setLocation_X(String locationX) {
		Location_X = locationX;
	}
	public String getLocation_Y() {
		return Location_Y;
	}
	public void setLocation_Y(String locationY) {
		Location_Y = locationY;
	}
	public String getScale() {
		return Scale;
	}
	public void setScale(String scale) {
		Scale = scale;
	}
	public String getLabel() {
		return Label;
	}
	public void setLabel(String label) {
		Label = label;
	}
	public String getMsgId() {
		return MsgId;
	}
	public void setMsgId(String msgId) {
		MsgId = msgId;
	}

	
}
