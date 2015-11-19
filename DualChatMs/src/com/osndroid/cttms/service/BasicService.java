package com.osndroid.cttms.service;

import org.nutz.ioc.loader.annotation.Inject;
import com.alibaba.druid.util.StringUtils;
import com.osndroid.cttms.dao.ArticlesDao;
import com.osndroid.cttms.dao.PTextDao;
import com.osndroid.cttms.dao.UEventDao;
import com.osndroid.cttms.dao.UserDao;
import com.osndroid.cttms.est.MessageEst;
import com.osndroid.cttms.model.pla.user.User;

/**
 * 
 * @author OsnDroid
 *
 */
public abstract class BasicService implements Service {

	/**
	 * 图文消息组装
	 */
	@Inject
	protected MessageEst articlesEst;
	/**
	 * 文本消息组装
	 */
	@Inject
	protected MessageEst textEst;
	/**
	 * 文本消息DAO
	 */
	@Inject
	protected PTextDao pTextDao;
	/**
	 * 事件记录DAO
	 */
	@Inject
	protected UEventDao uEventDao;
	/**
	 * 图文DAO
	 */
	@Inject
	protected ArticlesDao articlesDao;
	/**
	 * 双信用户DAO
	 */
	@Inject
	protected UserDao userDao;

	@Override
	public User queryUser(String openId, int source) {
		User user = null;
		switch (source) {
		case 1:
			user = userDao.queryWxByOpenID(openId);
			break;
		case 0:
			user = userDao.queryYxByOpenID(openId);
			break;
		default:
			break;
		}
		return user;
	}

	@Override
	public boolean ensureBind(User user) {
		return user != null && !StringUtils.isEmpty(user.getPhone());
	}

	@Override
	public boolean ensureBind(String openId, int source) {
		return ensureBind(queryUser(openId, source));
	}

	@Override
	public boolean ensurePhone(String openId, int source) {
		User user = null;
		switch (source) {
		case 1:
			user = userDao.queryYxByPhone(openId);
			break;
		case 0:
			user = userDao.queryYxByPhone(openId);
			break;
		default:
			break;
		}
		return user != null && !StringUtils.isEmpty(user.getOpenID());
	}

}
