package com.osndroid.cttms.init.service;

import java.util.ArrayList;
import java.util.List;
import org.nutz.json.Json;
import com.osndroid.cttms.model.pla.menu.Menu;
import com.osndroid.cttms.model.pla.menu.MenuButton;
import com.osndroid.cttms.model.pla.menu.MenuButtonSub;
import com.osndroid.cttms.model.pla.menu.ToolBar;

/**
 * 
 * 创建菜单
 * 
 * @author OsnDroid
 *
 */
public class MenuService {

	private static ArrayList<MenuButton> assembleMBtn(String[][] params) {
		ArrayList<MenuButton> buttonItem = new ArrayList<MenuButton>();
		for (int i = 0; i < params.length; i++) {
			if (i == 0)
				continue;
			String iconf[] = params[i];
			MenuButton menuButton = new MenuButton();
			menuButton.setName(iconf[0]);
			menuButton.setType(iconf[1]);
			menuButton.setKey(iconf[2]);
			menuButton.setUrl(iconf[3]);
			buttonItem.add(menuButton);
		}
		return buttonItem;
	}

	/**
	 * 获取json菜单
	 * 
	 * @return
	 */
	public static String getMenuJson(String[][][] menus) {
		if (menus == null)
			return "";
		List<Menu> button = new ArrayList<Menu>();
		int len = menus.length;
		for (int i = 0; i < len; i++) {
			String[][] keys = menus[i];
			if (keys.length == 1) {
				MenuButton menuButton = new MenuButton();
				menuButton.setName(keys[0][0]);
				menuButton.setType(keys[0][1]);
				menuButton.setKey(keys[0][2]);
				menuButton.setUrl(keys[0][3]);
				button.add(menuButton);
			} else {
				MenuButtonSub menu = new MenuButtonSub();
				menu.setName(keys[0][0]);
				List<MenuButton> buttonItem = assembleMBtn(keys);
				menu.setSub_button(buttonItem);
				button.add(menu);
			}

		}
		ToolBar bar = new ToolBar(button);
		return Json.toJson(bar);
	}

}
