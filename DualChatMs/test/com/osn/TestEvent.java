package com.osn;

import java.util.ArrayList;
import java.util.List;

import org.nutz.json.Json;

import com.alibaba.fastjson.JSONObject;
import com.osndroid.cttms.dao.UEventDao;
import com.osndroid.cttms.model.pla.request.EventReq;
import com.osndroid.cttms.utils.AES;
import com.osndroid.cttms.utils.HttpUtil;

public class TestEvent {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws Exception {
		// UEventDao eventReqDao = new UEventDao();
		// EventReq eventReq = new EventReq();
		// eventReq.setCreateTime("2015-02-21 12:22:22");
		// eventReq.setEvent("ss");
		// eventReq.setEventKey("dsada");
		// eventReq.setFromUserName("dsadad");
		// eventReq.setToUserName("dsadasd");
		// eventReq.setMsgType("dsadas");
		// eventReqDao.save(eventReq);
//	

//		String url = "http://218.77.121.93:8070/front/hndxwx/wpAction.do?method=queryUseTC&menuId=20002&signId=4002&uid=%s&openId=%s&initId=aojbdabdkakbhijehadhomodfjkgbdmoo";
//		int count = url.split("%").length;
//		if(count>1) {
//			String[] phones = new String[count-1];
//			for (int j = 0; j < phones.length; j++) {
//				phones[j] = "gjalidkcbbcmdgkbfjcgikfgjcefcnmi";
//			}
//			System.out.println(url.format(url, phones));
//		}
		
		System.out.println("dasda=3".endsWith("="));
	}
}
