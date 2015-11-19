package com.osndroid.cttms.model.pla.request;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;

import com.osndroid.cttms.model.pla.News;

/**
 * 
 * 普通文本消息类
 * @author OsnDroid
 *
 */
@Table("OSN_USER_OPERATION")//用户操作记录表
public class TextReq extends News {
	
	@Column("content")
	private String Content;
	
	private String MsgId;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getMsgId() {
		return MsgId;
	}

	public void setMsgId(String msgId) {
		MsgId = msgId;
	}

}
