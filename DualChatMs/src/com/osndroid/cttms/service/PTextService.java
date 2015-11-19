package com.osndroid.cttms.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.nutz.ioc.loader.annotation.IocBean;

import com.alibaba.druid.util.StringUtils;
import com.osndroid.cttms.model.pla.Articles;
import com.osndroid.cttms.model.pla.request.TextReq;
import com.osndroid.cttms.utils.TimeUtils;

/**
 * 
 * 用户返回内容业务处理
 * @author OsnDroid
 *
 */
@IocBean
public class PTextService extends BasicService{
	
	private static final Logger log = Logger.getLogger(PTextService.class);

	
	@Override
	public String handle(String xml,int source) throws Exception
	{
		if(StringUtils.isEmpty(xml)) return "";
		TextReq req = textEst.ConvByXml(xml, TextReq.class);
		req.setCreateTime(TimeUtils.getCurrentTimeInString());//重置时间
		pTextDao.save(req);
		String openId = req.getFromUserName();	//用户的openId
		String reqContent = req.getContent().trim().toUpperCase();//用户请求内容
		log.info("openId:"+openId+"  reqContent:"+reqContent);
		if(StringUtils.isEmpty(reqContent)) return "";
		if(reqContent.equals("答题"))//根据reqContent抓取对应的关键回复文本
		{
			return textEst.estXml(req,"测试-你当前请求的消息体为【答题】！！");
		}
		if(reqContent.equals("活动"))
		{
			//图文或多图文回复
			List<Articles> list = new ArrayList<Articles>();
			return articlesEst.estXml(list, req);
		}
		return textEst.estXml(req,"无效回复");
	}
}
