package com.osndroid.cttms.filter;

import java.util.Arrays;
import org.nutz.ioc.loader.annotation.IocBean;
import com.alibaba.druid.util.StringUtils;
import com.osndroid.cttms.init.config.Event;
import com.osndroid.cttms.model.pla.request.EventReq;

/**
 * 
 * 事件过滤器
 * 
 * @author OsnDroid
 *
 */
@IocBean
public class EventFilter implements Filter {

	/**
	 * 无需绑定即可响应的按钮
	 */
	private final static String[] FILTER_KEY = { Event.MENU1_BTN4,
			Event.MENU2_BTN1, Event.MENU2_BTN4 };

	/**
	 * 
	 */
	private final static String[] FILTER_TEXT = { "" };

	@Override
	public boolean checkOperationBefore(EventReq req) {
		if (req == null)
			return false;
		boolean tmp = false;
		if (Event.Type.CLICK.equalsIgnoreCase(req.getEvent())) {
			String key = req.getEventKey();
			tmp = Arrays.asList(FILTER_KEY).contains(key);
		}
		return tmp;
	}

	@Override
	public boolean checkOperationBefore(String param) {
		if (StringUtils.isEmpty(param))
			return false;
		return Arrays.asList(FILTER_TEXT).contains(param);
	}

}
