package com.osndroid.cttms.dao;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.IocBean;

import com.osndroid.cttms.model.pla.Articles;

/**
 * 
 * 图文消息
 * 
 * @author OsnDroid
 *
 */
@IocBean
public class ArticlesDao extends BasicDao {

	/**
	 * 查询图文列表
	 * 
	 * @param param
	 * @return
	 */
	public List<Articles> query(String param) {
		Cnd condition = Cnd.where("repkey", "=", param);// 条件查询例子
		return search(Articles.class, condition);

	}

}
