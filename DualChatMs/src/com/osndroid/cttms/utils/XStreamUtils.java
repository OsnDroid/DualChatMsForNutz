package com.osndroid.cttms.utils;

import com.osndroid.cttms.model.pla.Articles;
import com.osndroid.cttms.model.pla.respone.ArticlesResp;
import com.osndroid.cttms.model.pla.respone.MusicResp;
import com.osndroid.cttms.model.pla.respone.TextResp;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XStreamUtils {
	
	private static XStream xstream = new XStream(new DomDriver());
	
	
	/** 
	 * 文本消息对象转换成xml 
	 *  
	 * @param textMessage 文本消息对象 
	 * @return xml 
	 */
	public static String textMessageToXml(TextResp textMessage) {
		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
	}

	/** 
	 * 音乐消息对象转换成xml 
	 *  
	 * @param musicMessage 音乐消息对象 
	 * @return xml 
	 */
	public static String musicMessageToXml(MusicResp musicMessage) {
		xstream.alias("xml", musicMessage.getClass());
		return xstream.toXML(musicMessage);
	}

	/** 
	 * 图文消息对象转换成xml 
	 *  
	 * @param newsMessage 图文消息对象 
	 * @return xml 
	 */
	public static String newsMessageToXml(ArticlesResp newsMessage) {
		xstream.alias("xml", newsMessage.getClass());
		xstream.alias("item", new Articles().getClass());
		return xstream.toXML(newsMessage);
	}

}
