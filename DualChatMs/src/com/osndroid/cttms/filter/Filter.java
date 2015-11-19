package com.osndroid.cttms.filter;

import org.nutz.ioc.loader.annotation.IocBean;

import com.osndroid.cttms.model.pla.request.EventReq;

/**
 * 
 * @author OsnDroid
 *
 */
@IocBean
public abstract interface Filter {

	/**
	 * 检查哪些事件无需绑定即可以操作 
	 * @param req
	 * @return true代表无需绑定可以操作
	 */
	public boolean checkOperationBefore(EventReq req);
	
	
	/**
	 * 检查用户反馈内容哪些文本无需绑定即可操作
	 * @param param
	 * @return true代表无需绑定可以操作
	 */
	public boolean checkOperationBefore(String param);
}
