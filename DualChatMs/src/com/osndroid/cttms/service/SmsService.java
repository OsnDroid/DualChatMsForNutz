package com.osndroid.cttms.service;

import java.text.SimpleDateFormat;

import org.nutz.ioc.loader.annotation.IocBean;

import com.osndroid.cttms.utils.HttpUtil;
import com.osndroid.cttms.utils.RandomUtils;
import com.osndroid.cttms.utils.TimeUtils;

/**
 * 发送短信
 * 
 * @author OsnDroid
 *
 */
@IocBean
public class SmsService {
	private final static String URL = "http://218.77.121.93:8002/interface/basicSendMsg";

	/**
	 * {"msg":"成功","ret":0}
	 * 
	 * @param phonenum
	 * @param code
	 * @return
	 */
	public String send(String phonenum, String code) {
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("尊敬的用户，您的验证码为").append(code);
		sBuilder.append("，本次验证码5分钟内有效，感谢您的使用！【豆你玩】");
		String randStr = RandomUtils.getRandomNumbers(5);
		String streamingNo = "201"
				+ TimeUtils.getCurrentTimeInString(new SimpleDateFormat(
						"yyMMddHHmmss")) + randStr;
		StringBuilder params = new StringBuilder();
		params.append("streamingNo=");
		params.append(streamingNo);
		params.append("&agentId=");
		params.append(phonenum);
		params.append("&message=");
		params.append(sBuilder.toString());
		return HttpUtil.doHttpReq(URL, params.toString(), HttpUtil.REQ_POST);
	}
	
	
	 
	
	public static void main(String[] args) {
		System.out.println(new SmsService().send("15399907323", "122311"));
	}

}
