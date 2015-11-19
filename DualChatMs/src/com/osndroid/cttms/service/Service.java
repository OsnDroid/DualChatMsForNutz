package com.osndroid.cttms.service;

import com.osndroid.cttms.model.pla.user.User;


/**
 * 
 * 业务处理服务
 * @author OsnDroid
 *
 */
public interface Service {

	/**
	 * 处理封装xml
	 * @param xml
	 * @param source 来源1是微信，0是易信
	 * @return
	 * @throws Exception
	 */
	public String handle(String xml,int source) throws Exception;
	
	/**
	 * 查询绑定信息
	 * @param openId
	 * @param source
	 * @return
	 */
	public User queryUser(String openId, int source);
	
	/**
	 * 确定该用户是否绑定
	 * @param user
	 * @return
	 */
	public boolean ensureBind(User user);
	
	/**
	 * 查询确并确定该openId是否被绑定过
	 * @param openId
	 * @param source
	 * @return true代表绑定过
	 */
	public boolean ensureBind(String openId, int source);
	
	/**
	 * 确定号码是否被使用
	 * @param openId
	 * @param source
	 * @return
	 */
	public boolean ensurePhone(String openId, int source);
	
}
