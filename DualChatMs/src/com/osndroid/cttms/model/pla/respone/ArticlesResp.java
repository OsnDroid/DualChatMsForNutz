package com.osndroid.cttms.model.pla.respone;

import java.util.List;

import org.nutz.ioc.loader.annotation.IocBean;

import com.osndroid.cttms.model.pla.News;
import com.osndroid.cttms.model.pla.Articles;



/**
 *  图文消息响应类
 * @author OsnDroid
 *
 */
@IocBean
public class ArticlesResp extends News {
	 
	private int ArticleCount;
	private List<Articles> Articles;
	
	 
	public int getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}
	public List<Articles> getArticles() {
		return Articles;
	}
	public void setArticles(List<Articles> articles) {
		Articles = articles;
	}
	
}
