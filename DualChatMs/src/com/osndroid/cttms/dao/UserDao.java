package com.osndroid.cttms.dao;

import org.nutz.ioc.loader.annotation.IocBean;
import com.osndroid.cttms.model.pla.user.WXUser;
import com.osndroid.cttms.model.pla.user.YXUser;

/**
 * 
 * 双信用户
 * 
 * @author OsnDroid
 *
 */
@IocBean
public class UserDao extends BasicDao {

	/**
	 * 查询用户
	 * 
	 * @param param
	 * @return
	 */
	public WXUser queryWxByOpenID(String openID) {
		return findByCondition(WXUser.class, "openID", openID);
	}

	public YXUser queryYxByOpenID(String openID) {
		return findByCondition(YXUser.class, "openID", openID);
	}
	
	
	public WXUser queryWxByPhone(String openID) {
		return findByCondition(WXUser.class, "openID", openID);
	}

	public YXUser queryYxByPhone(String openID) {
		return findByCondition(YXUser.class, "openID", openID);
	}
	

	/**
	 * 
	 * @param user
	 * @return
	 */
	public WXUser save(WXUser user) {
		return save(user);
	}

	public YXUser save(YXUser user) {
		return save(user);
	}

}
