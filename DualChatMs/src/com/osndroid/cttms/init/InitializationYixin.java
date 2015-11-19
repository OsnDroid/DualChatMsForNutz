package com.osndroid.cttms.init;

import org.apache.log4j.Logger;

import com.osndroid.cttms.init.config.CustomMenuConfig;
import com.osndroid.cttms.init.config.ServerConfig;
import com.osndroid.cttms.init.service.MenuService;
import com.osndroid.cttms.init.service.PlatformService;

public class InitializationYixin {
	private static final Logger log = Logger
			.getLogger(InitializationYixin.class);
	private static PlatformService platformService = null;
	static {
		platformService = new PlatformService(PlatformService.PLF_YIXIN);
	}

	private static void createMenu() {
		String jsonTool = MenuService.getMenuJson(CustomMenuConfig.MENUS);
		log.info(jsonTool);
		String token = platformService.accessToken();
		String resp = platformService.menuOper(ServerConfig.OPER_MENU_INIT, token, jsonTool);
		log.info("创建菜单结束--结果：" + resp);
	}
	
	public static void createMenu(String[][][] menus) {
		String jsonTool = MenuService.getMenuJson(menus);
		log.info(jsonTool);
		String token = platformService.accessToken();
		String resp = platformService.menuOper(ServerConfig.OPER_MENU_INIT, token, jsonTool);
		log.info("创建菜单结束--结果：" + resp);
	}
	
	public static void main(String[] args) {
		InitializationYixin.createMenu();
	}

}