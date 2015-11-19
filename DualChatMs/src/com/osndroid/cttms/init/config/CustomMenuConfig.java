package com.osndroid.cttms.init.config;

import com.osndroid.cttms.annotation.ScanArray;


/**
 * 
 * 自定义菜单 
 * <p>type=Type.CLICK表示key有参数，url为空字符串
 * <p>type=Type.VIEW表示url有参数，key为空字符串
 * 
 * @author OsnDroid
 *
 */

public class CustomMenuConfig {

	//|- name -|-type -|- key -|- url -|
	@ScanArray 
	public static final String[][][] MENUS = 
		{
			{ 
					{ "xxxx" }, 
					{ "xxxx", Event.Type.CLICK, Event.MENU1_BTN1, "" },
					{ "xxxx", Event.Type.CLICK, Event.MENU1_BTN2, "" },
//					{ "xxxx", Event.Type.CLICK, Event.MENU1_BTN3, "" },
					{ "xxxx", Event.Type.CLICK, Event.MENU1_BTN4, "" } 
			}
			,
			{
					{ "xxxx" },
					{ "xxxx", Event.Type.CLICK, Event.MENU2_BTN1, "" },
					{ "xxxx", Event.Type.VIEW, "","https://www.baidu.com/" },
					{ "xxxx", Event.Type.VIEW, "","https://www.baidu.com/" },
					{ "xxxx", Event.Type.CLICK, Event.MENU2_BTN4, "" },
					{ "xxxx", Event.Type.CLICK, Event.MENU2_BTN5, "" } 
			}
			,
			{
					{ "xxxx" },
					{ "xxxx", Event.Type.CLICK, Event.MENU3_BTN1, "" },
					{ "xxxx", Event.Type.CLICK, Event.MENU3_BTN2, "" }
			}
			// .....
		};

}
