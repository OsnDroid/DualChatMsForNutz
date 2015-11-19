package com.osndroid.cttms.dispatcher;

/**
 * 
 * @author OsnDroid
 *
 */
public interface DisPatcher {

	/**
	 * 
	 * @param content
	 *            需要处理的内容
	 * @param source
	 *            来源 1是微信 0是易信
	 * @return 返回响应消息内容
	 */
	public String handle(String content, int source);

}
