package com.osndroid.cttms.controller.base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.nutz.ioc.loader.annotation.IocBean;

import com.alibaba.druid.util.StringUtils;


/**
 * 
 * @author OsnDroid
 *
 */
@IocBean
public abstract class Action {
	
	private static final Logger log = Logger.getLogger(Action.class);
	

	protected void output(HttpServletResponse response,String cotent) {
		if(response==null) return;
		if(StringUtils.isEmpty(cotent)) cotent = "error";
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println(cotent);
			out.flush();
			out.close();
		} catch (IOException e) {
			log.error("IOException", e);
			e.printStackTrace();
		}
	}
}
