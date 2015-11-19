package com.osndroid.cttms.dispatcher;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.alibaba.druid.util.StringUtils;
import com.osndroid.cttms.dao.ArticlesDao;
import com.osndroid.cttms.est.MessageEst;
import com.osndroid.cttms.filter.Filter;
import com.osndroid.cttms.init.config.Event;
import com.osndroid.cttms.model.pla.Articles;
import com.osndroid.cttms.model.pla.MsgType;
import com.osndroid.cttms.model.pla.request.EventReq;
import com.osndroid.cttms.utils.PraseXML;

/**
 * 消息分发处理
 * 
 * @author OsnDroid
 *
 */
@IocBean
public class MessageDispatcher extends AbstractDisPatcher {

	private static final Logger log = Logger.getLogger(MessageDispatcher.class);

	/**
	 * 事件过滤
	 */
	@Inject
	protected Filter eventFilter;

	/**
	 * 图文DAO
	 */
	@Inject
	protected ArticlesDao articlesDao;
	/**
	 * 图文消息组装
	 */
	@Inject
	protected MessageEst articlesEst;

	/**
	 * 消息文本的处理，返回响应消息内容
	 */
	@SuppressWarnings("static-access")
	@Override
	public String handle(String content, int source) {
		if (StringUtils.isEmpty(content))
			return "";
		String respXml = "";
		try {
			List<Map<String, String>> list = PraseXML.iterateWholeXML(content);
			String msgType = PraseXML.getParamer("MsgType", list);
			String openId = PraseXML.getParamer("FromUserName", list);
			boolean isBind = userService.ensureBind(openId, source);// 验证用户是否绑定过
			boolean check = false;
			if (MsgType.TYPE_EVENT.equals(msgType)) {
				EventReq req = articlesEst.ConvByXml(content, EventReq.class);
				check = eventFilter.checkOperationBefore(req);
			}
			if (isBind || check || MsgType.TYPE_TEXT.equals(msgType)) {
				if (MsgType.TYPE_TEXT.equals(msgType)) {
					respXml = pTextService.handle(content, source);
				} else if (MsgType.TYPE_EVENT.equals(msgType)) {
					respXml = uEventService.handle(content, source);
				}
			} else {// 未绑定
				String toUserName = PraseXML.getParamer("ToUserName", list);
				List<Articles> aLists = articlesDao.query(Event.MENU3_BTN2);
				for (int i = 0; i < aLists.size(); i++) {
					Articles articles = aLists.get(i);
					String url = articles.getUrl();
					int count = url.split("%").length;
					if (count > 1) {
						aLists.get(i).setUrl(url.format(url, openId));
					}
				}
				respXml = articlesEst.estXml(aLists, toUserName, openId);
			}

		} catch (Exception e) {
			log.error("Exception", e);
			e.printStackTrace();
		}
		return respXml;
	}

}
