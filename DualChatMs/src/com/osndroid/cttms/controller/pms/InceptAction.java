package com.osndroid.cttms.controller.pms;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;

import com.osndroid.cttms.controller.base.Action;
import com.osndroid.cttms.dispatcher.DisPatcher;
import com.osndroid.cttms.utils.HttpUtil;

/**
 * 
 * 双信平台配置入口
 * 
 * @author OsnDroid
 *
 */
@IocBean
public class InceptAction extends Action {

	private static final Logger log = Logger.getLogger(InceptAction.class);

	@Inject
	public DisPatcher messageDispatcher;

	/**
	 * 处理请求
	 * 
	 * @param request
	 * @param response
	 * @param source
	 *            来源 1是微信 0是易信
	 */
	
	public void acceptHandle(HttpServletRequest request,
			HttpServletResponse response, int source) {
		if (request == null || response == null) return;
		String requestMethod = request.getMethod();
		if (HttpUtil.REQ_GET.equalsIgnoreCase(requestMethod)) {
			String echostr = request.getParameter("echostr");
			output(response, echostr);
			return;
		}
		BufferedReader reader = null;
		try {
			reader = request.getReader();
			if (reader == null) output(response, "error");
			String line;
			StringBuffer sb = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			output(response, messageDispatcher.handle(sb.toString(), source));
		} catch (IOException e) {
			log.error("IOException", e);
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
					reader = null;// 释放资源
				}
			} catch (Exception e2) {
				log.error("IOException", e2);
				e2.printStackTrace();
			}
		}

	}

	/**
	 * 来源 1是微信 0是易信
	 * 
	 * @author OsnDroid
	 *
	 */
	static class Source {
		static final int WEIXIN = 1;
		static final int YIXIN = 0;
	}

}
