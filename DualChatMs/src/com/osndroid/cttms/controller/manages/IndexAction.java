package com.osndroid.cttms.controller.manages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.View;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.GET;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.view.ServerRedirectView;


/**
 * 
 * @author OsnDroid
 *
 */
@IocBean
public class IndexAction {
	
	@Fail("redirect:/404.html")
	@GET
	@At("/index")
	public View index(HttpServletRequest request,
			HttpServletResponse response,@Param("type") int type) {  
		if(type == 1) {
			return new ServerRedirectView("/table.html?uid="+request.getSession().getId());  
		}
		return new ServerRedirectView("/login.html");  
	}

}
