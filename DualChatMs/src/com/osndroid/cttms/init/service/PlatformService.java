package com.osndroid.cttms.init.service;

import org.apache.log4j.Logger;
import com.alibaba.fastjson.JSONObject;
import com.osndroid.cttms.init.config.ServerConfig_WeiXin;
import com.osndroid.cttms.init.config.ServerConfig_YiXin;
import com.osndroid.cttms.utils.HttpUtil;

/**
 * 
 * 双信平台菜单服务操作
 * 
 * @author OsnDroid
 *
 */
public class PlatformService {
	public static final int PLF_WEIXIN = 1;
	public static final int PLF_YIXIN = 2;
	
	private String url_voucher = "";
	private String appid = "";
	private String appsecret = "";
	private String url_menu = "";
	private static final Logger log = Logger.getLogger(PlatformService.class);

	static {

	}

	public PlatformService(int source) {
		switch (source) {
			case 1:
				log.info("加载微信配置...");
				url_voucher = ServerConfig_WeiXin.URL_VOUCHER;
				appid = ServerConfig_WeiXin.APPID;
				appsecret = ServerConfig_WeiXin.APPSECRET;
				url_menu = ServerConfig_WeiXin.URL_MENU;
				break;
			case 2:
				log.info("加载易信配置...");
				url_voucher = ServerConfig_YiXin.URL_VOUCHER;
				appid = ServerConfig_YiXin.APPID;
				appsecret = ServerConfig_YiXin.APPSECRET;
				url_menu = ServerConfig_YiXin.URL_MENU;
				break;
			default:
				break;
		}
		log.info("url_voucher："+url_voucher);
		log.info("appid："+appid);
		log.info("appsecret："+appsecret);
		log.info("url_menu："+url_menu);
	}

	/**
	 * 获取token
	 * @return
	 */
	public String accessToken() {
		StringBuilder url = new StringBuilder(url_voucher);
		url.append("?grant_type=client_credential&");
		url.append("appid=" + appid);
		url.append("&secret=");
		url.append(appsecret);
		String resp = HttpUtil.doHttpReq(url.toString(), "", HttpUtil.REQ_GET);
		JSONObject objResp = JSONObject.parseObject(resp);
		return objResp.getString("access_token");
	}

	/**
	 * 菜单操作
	 * @param oper
	 * @param accessToken
	 * @param arg
	 * @param reqMethod
	 * @return
	 */
	public String menuOper(String opermethod, String accessToken, String menujson) {
		log.info("url_menu:"+url_menu);
		StringBuilder url = new StringBuilder(url_menu);
		url.append(opermethod);
		url.append("?access_token=");
		url.append(accessToken);
		String resp = HttpUtil.doHttpReq(url.toString(), menujson, HttpUtil.REQ_POST);
		return resp;
	}
}
