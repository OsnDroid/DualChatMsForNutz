package com.osndroid.cttms.init.config;

import com.osndroid.cttms.utils.OsnProperties;

/**
 * 
 * 易平台信息
 * 
 * @author OsnDroid
 *
 */
public class ServerConfig_YiXin extends ServerConfig {
	public static String TOKEN;
	public static String APPID;
	public static String APPSECRET;
	public static String URL_VOUCHER;
	public static String URL_MENU;

	static {
		if (TOKEN == null)
			TOKEN = OsnProperties.getParameter("osn.yixin.token");
		if (APPID == null)
			APPID = OsnProperties.getParameter("osn.yixin.appId");
		if (APPSECRET == null)
			APPSECRET = OsnProperties.getParameter("osn.yixin.appSecret");
		if (URL_VOUCHER == null)
			URL_VOUCHER = OsnProperties.getParameter("osn.yixin.voucher");
		if (URL_MENU == null)
			URL_MENU = OsnProperties.getParameter("osn.yixin.menu");
	}
}