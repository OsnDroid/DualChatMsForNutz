package com.osndroid.cttms.init.config;

/**
 * 点击事件 menu*_btn* 第几个菜单第几个按钮
 * 
 * @author OsnDroid
 *
 */
public class Event {

	/**
	 * menu*_btn* 第几个菜单第几个按钮
	 */
	public static final String MENU1_BTN1 = "menu1_btn1";
	/**
	 * menu*_btn* 第几个菜单第几个按钮
	 */
	public static final String MENU1_BTN2 = "menu1_btn2";
	public static final String MENU1_BTN3 = "menu1_btn3";
	public static final String MENU1_BTN4 = "menu1_btn4";
	public static final String MENU1_BTN5 = "menu1_btn5";
	public static final String MENU1_BTN6 = "menu1_btn6";
	public static final String MENU1_BTN7 = "menu1_btn7";
	public static final String MENU1_BTN8 = "menu1_btn8";
	public static final String MENU1_BTN9 = "menu1_btn9";

	public static final String MENU2_BTN1 = "menu2_btn1";
	public static final String MENU2_BTN2 = "menu2_btn2";
	public static final String MENU2_BTN3 = "menu2_btn3";
	public static final String MENU2_BTN4 = "menu2_btn4";
	public static final String MENU2_BTN5 = "menu2_btn5";

	public static final String MENU3_BTN1 = "menu3_btn1";
	/**
	 * 点击绑定事件
	 */
	public static final String MENU3_BTN2 = "menu3_btn2";

	/**
	 * 关注事件
	 */
	public static final String SUBSCRIBE = "subscribe";// 关注事件
	/**
	 * 取消关注
	 */
	public static final String UNSUBSCRIBE = "unsubscribe";// 关注事件

	/**
	 * 事件类型 click是图文消息，view是网址连接
	 * 
	 * @author OsnDroid
	 *
	 */
	public static class Type {
		/**
		 * 网络地址连接
		 */
		public static final String VIEW = "view";
		/**
		 * 点击事件
		 */
		public static final String CLICK = "click";
	}
}
