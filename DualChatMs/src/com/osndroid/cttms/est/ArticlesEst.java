package com.osndroid.cttms.est;

import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import com.osndroid.cttms.model.pla.MsgType;
import com.osndroid.cttms.model.pla.News;
import com.osndroid.cttms.model.pla.Articles;
import com.osndroid.cttms.model.pla.respone.ArticlesResp;
import com.osndroid.cttms.utils.XStreamUtils;

/**
 * 
 * 图文-消息组装
 * 
 * @author OsnDroid
 *
 */
@IocBean
public class ArticlesEst extends MessageEst {

	private static final Logger log = Logger.getLogger(ArticlesEst.class);

	@Inject
	protected ArticlesResp articlesResp;

	@Override
	public String estXml(List<Articles> list, News news) {
		if (list == null || list.size() == 0) {
			log.error("estXml方法参数List<Articles> list 为空或者无数据");
			return "";
		}
		if (news == null) {
			log.error("estXml方法参数news为空或者无数据");
			return "";
		}

		articlesResp.setFromUserName(news.getToUserName());
		articlesResp.setToUserName(news.getFromUserName());
		articlesResp.setCreateTime(String.valueOf(new Date().getTime()));
		articlesResp.setMsgType(MsgType.TYPE_NEWS);
		articlesResp.setArticleCount(list.size());
		articlesResp.setArticles(list);
		return XStreamUtils.newsMessageToXml(articlesResp);
	}
	
	@Override
	public String estXml(List<Articles> list, String toUserName,String fromUserName) {
		News news = new News();
		news.setToUserName(toUserName);
		news.setFromUserName(fromUserName);
		return estXml(list, news);
	}

}
