package com.osndroid.cttms.controller.base;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.osndroid.cttms.dao.BasicDao;

/**
 * 基action
 * @author OsnDroid
 *
 */
@IocBean
public class BasicAction extends Action{

	@Inject
	protected BasicDao basicDao;
	
	public void setBasicDao(BasicDao basicDao) {
		this.basicDao = basicDao;
	}
	
}
