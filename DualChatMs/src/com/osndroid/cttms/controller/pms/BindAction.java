package com.osndroid.cttms.controller.pms;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.osndroid.cttms.controller.base.Action;
import com.osndroid.cttms.controller.pms.InceptAction.Source;
import com.osndroid.cttms.dao.UserDao;
import com.osndroid.cttms.model.pla.user.YXUser;
import com.osndroid.cttms.service.SmsService;
import com.osndroid.cttms.service.UserService;
import com.osndroid.cttms.utils.RandomUtils;
import com.osndroid.cttms.utils.TimeUtils;

/**
 * 
 * 绑定Action
 * 
 * @author OsnDroid
 *
 */
@IocBean
public class BindAction extends Action {
	private static final Logger log = Logger.getLogger(BindAction.class);

	@Inject
	protected SmsService smsService;
	
	@Inject
	protected UserService userService;
	
	/**
	 * 双信用户DAO
	 */
	@Inject
	protected UserDao userDao;
	

	@At("/binds/sendsms")
	public void sendsms(HttpServletRequest request,
			HttpServletResponse response, @Param("phone") String phone,
			@Param("openId") String openId, @Param("source") String source) {
		String code = RandomUtils.getRandomNumbers(6);
		String json = smsService.send(phone, code);
		try {
			JSONObject obj = JSONObject.parseObject(json);
			int ret = obj.getIntValue("ret");
			if (ret == 0) {
				request.getSession().setAttribute("code", code);
				request.getSession().setAttribute("openId", openId);
				request.getSession().setAttribute("codetime",TimeUtils.getCurrentTimeInLong());
				output(response, "验证码已经发送");
				response.setStatus(200);
			} else {
				output(response, "验证码发送失败");
				response.setStatus(200);
			}
		} catch (Exception e) {
			output(response, "验证码发送失败");
			response.setStatus(200);
			log.error("", e);
		}
	}

	
	@At("/binds/validate")
	public void validate(HttpServletRequest request,
			HttpServletResponse response, @Param("phone") String phone,
			@Param("openId") String openId, @Param("source") String source, @Param("code") String code) {
		String cancheOpenId = (String) request.getSession().getAttribute("openId");
		String canchecode = (String) request.getSession().getAttribute("code");
		if(StringUtils.isEmpty(cancheOpenId) || StringUtils.isEmpty(canchecode)) {
			output(response, "页面数据失效，请重新打开页面尝试提交！");
			return;
		}
		if(userService.ensureBind(cancheOpenId, Source.YIXIN)) {
			output(response, "抱歉该易信号已经被其他手机号绑定过");
			return;
		}
		
		if(userService.ensurePhone(cancheOpenId, Source.YIXIN)) {
			output(response, "抱歉该手机号已经被绑定过其他易信号");
			return;
		}

		try {
			long now = TimeUtils.getCurrentTimeInLong();
			long old = (Long) request.getAttribute("codetime");
			if (canchecode.equals(code) && openId.equals(cancheOpenId)
					&& (now - old) < 1000 * 60 * 5) {
				YXUser user = new YXUser();
				user.setOpenID(cancheOpenId);
				user.setPhone(phone);
				YXUser userRs = userDao.save(user);
				if (userRs != null) {
					output(response, "绑定成功");
					request.getSession().removeAttribute("code");
				}
			} else {
				output(response, "验证码输入错误");
			}
		} catch (Exception e) {
			output(response, "绑定异常，请稍后重试");
			log.error("", e);
		}
		
	}
}
