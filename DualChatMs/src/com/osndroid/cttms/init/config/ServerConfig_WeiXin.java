package com.osndroid.cttms.init.config;

import com.osndroid.cttms.utils.OsnProperties;

/**
 * 
 * 微信平台信息
 * 
 * @author OsnDroid
 *
 */
public class ServerConfig_WeiXin extends ServerConfig {
	public static String TOKEN;
	public static String APPID;
	public static String APPSECRET;
	public static String URL_VOUCHER;
	public static String URL_MENU;

	static {
		if (TOKEN == null)
			TOKEN = OsnProperties.getParameter("osn.weixin.token");
		if (APPID == null)
			APPID = OsnProperties.getParameter("osn.weixin.appId");
		if (APPSECRET == null)
			APPSECRET = OsnProperties.getParameter("osn.weixin.appSecret");
		if (URL_VOUCHER == null)
			URL_VOUCHER = OsnProperties.getParameter("osn.weixin.voucher");
		if (URL_MENU == null)
			URL_MENU = OsnProperties.getParameter("osn.weixin.menu");
	}
}