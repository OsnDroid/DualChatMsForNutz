package com.osndroid.cttms.controller.manages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.View;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.view.JspView;

import com.osndroid.cttms.controller.base.Action;


/**
 * 
 * @author OsnDroid
 *
 */
@IocBean
public class AccountAction extends Action{
	
	
	@At("/test/acceptHandle")
	public View AcceptHandle(HttpServletRequest request,
			HttpServletResponse response,int source) {
		return new JspView("jsp:/bind.jsp");
	}
	
	 
}
