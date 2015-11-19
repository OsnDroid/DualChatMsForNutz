package com.osndroid.cttms.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.nutz.ioc.loader.annotation.IocBean;

import com.alibaba.druid.util.StringUtils;
import com.osndroid.cttms.init.config.Event;
import com.osndroid.cttms.model.pla.Articles;
import com.osndroid.cttms.model.pla.request.EventReq;
import com.osndroid.cttms.model.pla.user.User;
import com.osndroid.cttms.utils.AES;
import com.osndroid.cttms.utils.TimeUtils;

/**
 * 
 * 用户点击事件处理
 * 
 * @author OsnDroid
 *
 */
@IocBean
public class UEventService extends BasicService {

	private static final Logger log = Logger.getLogger(UEventService.class);

	@SuppressWarnings("static-access")
	@Override
	public String handle(String xml, int source) throws Exception {
		if (StringUtils.isEmpty(xml))
			return "";
		EventReq req = articlesEst.ConvByXml(xml, EventReq.class);
		req.setCreateTime(TimeUtils.getCurrentTimeInString());
		uEventDao.save(req);
		String openId = req.getFromUserName();
		log.info("openId:" + openId);
		if (Event.SUBSCRIBE.equals(req.getEvent())) {
			return textEst.estXml(req, "欢迎关注豆你玩！");
		}
		if (Event.UNSUBSCRIBE.equals(req.getEvent())) {
			// ....
		}
		if (Event.Type.CLICK.equalsIgnoreCase(req.getEvent())) {
			String key = req.getEventKey();
			User user = queryUser(openId, source);
			if (Event.MENU3_BTN2.equals(key)) {
				boolean isBind = ensureBind(user);// 验证用户是否绑定过
				if (isBind) {
					return textEst.estXml(req,
							source == 1 ? "sorry，您已经绑定过该微信公众号": "sorry，您已经绑定过该易信公众号");
				}
			}
			List<Articles> list = articlesDao.query(key);
			if (list == null)
				return "";
			String aes_phone = AES.Encrypt(user.getPhone());
			for (int i = 0; i < list.size(); i++) {
				Articles articles = list.get(i);
				String url = articles.getUrl();
				int count = url.split("%").length;
				if (count > 1) {
					Object[] phones = new String[count - 1];
					for (int j = 0; j < phones.length; j++) {
						phones[j] = aes_phone;
					}
					String handleUrl = url.format(url, phones);
					list.get(i).setUrl(handleUrl);
				}
			}
			return articlesEst.estXml(list, req);
		}
		return "";
	}

}
