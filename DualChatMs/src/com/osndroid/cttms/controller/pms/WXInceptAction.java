package com.osndroid.cttms.controller.pms;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;

/**
 * 
 * 微信平台入口
 * 
 * @author OsnDroid
 *
 */
@IocBean
public class WXInceptAction extends InceptAction {

	@At("/wexin/handle")
	public void handle(HttpServletRequest request, 
			HttpServletResponse response) {
		acceptHandle(request, response, Source.WEIXIN);
	}
}
