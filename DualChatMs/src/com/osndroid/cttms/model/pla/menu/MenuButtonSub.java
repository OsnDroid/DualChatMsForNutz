package com.osndroid.cttms.model.pla.menu;

import java.util.List;

/**
 * 子菜单按钮 
 * 一个菜单下包含n个子菜单，
 * 一个子菜单下就是一个菜单
 * @author OsnDroid
 *
 */
public class MenuButtonSub extends Menu
{
  private List<MenuButton> sub_button;

  public List<MenuButton> getSub_button()
  {
    return this.sub_button;
  }

  public void setSub_button(List<MenuButton> sub_button)
  {
    this.sub_button = sub_button;
  }
}