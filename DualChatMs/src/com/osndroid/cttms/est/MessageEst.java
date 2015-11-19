package com.osndroid.cttms.est;

import java.util.List;

import org.nutz.ioc.loader.annotation.IocBean;

import com.osndroid.cttms.model.pla.Articles;
import com.osndroid.cttms.model.pla.News;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * 
 * 消息组装
 * 
 * @author OsnDroid
 *
 */
@IocBean
public abstract class MessageEst {

	/**
	 * 组装图文消息
	 * 
	 * @param list
	 *            需要组装的图文消息集合
	 * @param news
	 *            请求的消息基本信息
	 * @return
	 */
	public String estXml(List<Articles> list, News news) {
		return "";
	}

	/**
	 * 组装图文消息
	 * 
	 * @param list
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	public String estXml(List<Articles> list, String toUserName,
			String fromUserName) {
		return "";
	}

	/**
	 * 组装消息
	 * 
	 * @param xstream
	 *            xml工具类
	 * @param news
	 *            请求的消息基本信息
	 * @param postMsg
	 *            发送消息内容
	 * @return
	 */
	public String estXml(XStream xstream, News news, String postMsg) {
		return "";
	}

	/**
	 * 组装消息
	 * 
	 * @param news
	 *            请求的消息基本信息
	 * @param postMsg
	 *            发送消息内容
	 * @return
	 */
	public String estXml(News news, String postMsg) {
		return "";
	}

	/**
	 * 转化xml对象->news {@link News}
	 * 
	 * @param xml
	 * @param c
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T ConvByXml(String xml, Class<T> c) {
		XStream xstream = new XStream(new DomDriver());
		xstream.alias("xml", c);
		return (T) xstream.fromXML(xml);
	}
}
