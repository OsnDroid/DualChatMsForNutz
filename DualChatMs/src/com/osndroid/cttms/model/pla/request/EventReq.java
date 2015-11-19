package com.osndroid.cttms.model.pla.request;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;
import com.osndroid.cttms.model.pla.News;

/**
 * 事件消息类
 * @author OsnDroid
 *
 */
@Table("OSN_USER_OPERATION")//用户操作记录表
public class EventReq extends News {

	@Column("eventType")
	private String Event;
	@Column("eventKey")
	private String EventKey;
	
	private String MsgId;


	public String getMsgId() {
		return MsgId;
	}

	public void setMsgId(String msgId) {
		MsgId = msgId;
	}

	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

}
