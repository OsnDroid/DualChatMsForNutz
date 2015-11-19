package com.osndroid.cttms.est;

import java.util.Date;

import org.apache.log4j.Logger;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.alibaba.druid.util.StringUtils;
import com.osndroid.cttms.model.pla.MsgType;
import com.osndroid.cttms.model.pla.News;
import com.osndroid.cttms.model.pla.respone.TextResp;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * 文本-消息组装
 * 
 * @author OsnDroid
 *
 */
@IocBean
public class TextEst extends MessageEst {
	private static final Logger log = Logger.getLogger(TextEst.class);

	@Inject
	private TextResp textResp;

	@Override
	public String estXml(News news, String postMsg) {
		XStream xstream = new XStream(new DomDriver());
		return estXml(xstream, news, postMsg);
	}

	@Override
	public String estXml(XStream xstream, News news, String postMsg) {
		if (xstream == null) {
			log.error("xstream方法参数List<Articles> list 为空或者无数据");
			return "";
		}
		if (news == null) {
			log.error("estXml方法参数news为空或者无数据");
			return "";
		}
		if (StringUtils.isEmpty(postMsg)) {
			log.error("estXml方法参数postMsg为空或者无数据");
			return "";
		}
		textResp.setFromUserName(news.getToUserName());
		textResp.setToUserName(news.getFromUserName());
		textResp.setCreateTime(String.valueOf(new Date().getTime()));
		textResp.setMsgType(MsgType.TYPE_TEXT);
		textResp.setFuncFlag("0");
		textResp.setContent(postMsg);
		xstream.alias("xml", TextResp.class);
		return xstream.toXML(textResp);
	}

}
