package com.osndroid.cttms.model.pla.menu;

import java.util.List;

/**
 * 整条菜单栏
 * @author OsnDroid
 *
 */
public class ToolBar
{
  private List<Menu> button;

  public ToolBar(List<Menu> button)
  {
    this.button = button;
  }

  public List<Menu> getButton()
  {
    return this.button;
  }

  public void setButton(List<Menu> button)
  {
    this.button = button;
  }

}