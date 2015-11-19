package com.osndroid.cttms.model.pla.respone;

import org.nutz.ioc.loader.annotation.IocBean;

import com.osndroid.cttms.model.pla.News;


/**
 * 普通文本消息响应类
 * @author OsnDroid
 *
 */
@IocBean
public class TextResp extends News{
	private String Content;
	private String FuncFlag;
	
	 
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getFuncFlag() {
		return FuncFlag;
	}
	public void setFuncFlag(String funcFlag) {
		FuncFlag = funcFlag;
	}
	
}
