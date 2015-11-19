package com.osndroid.cttms.model.pla;

import org.nutz.dao.entity.annotation.Column;

/**
 * 
 * 消息基本信息
 * @author OsnDroid
 *
 */
public class News {
	
	@Column("toUser")
	protected String ToUserName;
	@Column("fromUser")
	protected String FromUserName;
	@Column("createTime")
	protected String CreateTime;
	@Column("msgType")
	protected String MsgType;
	
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public String getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
}
