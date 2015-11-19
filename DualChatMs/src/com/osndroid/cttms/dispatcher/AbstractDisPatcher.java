package com.osndroid.cttms.dispatcher;

import org.nutz.ioc.loader.annotation.Inject;
import com.osndroid.cttms.service.Service;

/**
 * 
 * @author OsnDroid
 *
 */
public abstract class AbstractDisPatcher implements DisPatcher {

	/**
	 * 消息文本服务
	 */
	@Inject
	protected Service pTextService;

	/**
	 * 点击事件服务
	 */
	@Inject
	protected Service uEventService;
	
	/**
	 * 用户服务
	 */
	@Inject
	protected Service userService;
 
}
