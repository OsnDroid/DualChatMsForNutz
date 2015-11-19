package com.osndroid.cttms.controller.pms;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;

/**
 * 
 * 易信平台入口
 * 
 * @author OsnDroid
 *
 */
@IocBean
public class YXInceptAction extends InceptAction {

	@At("/yixin/handle")
	public void handle(HttpServletRequest request,
			HttpServletResponse response) {
		acceptHandle(request, response, Source.YIXIN);
	}

}
