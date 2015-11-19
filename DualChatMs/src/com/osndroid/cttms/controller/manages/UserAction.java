package com.osndroid.cttms.controller.manages;

import java.util.List;
import org.nutz.dao.QueryResult;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import com.osndroid.cttms.config.Constants;
import com.osndroid.cttms.controller.base.BasicAction;
import com.osndroid.cttms.model.pla.user.User;

/**
 * 
 * @author OsnDroid
 *
 */

@IocBean
@At("/user")
public class UserAction extends BasicAction {

	private static final Log log = Logs.getLog(UserAction.class);

	@At("list")
	@Ok("json")
	public Object query(@Param("..") Pager pager,
			@Param("currentPage") int currentPage) {
		log.info("currentPage:" + currentPage);
		log.info(pager == null ? "" : pager.toString());
		List<User> dualBinds = basicDao.searchByPage(User.class, currentPage,
				Constants.PAGE_SIZE, "id");
		int count = basicDao.searchCount(User.class);
		QueryResult qr = new QueryResult();
		qr.setList(dualBinds);
		pager.setRecordCount(count);
		qr.setPager(pager);
		return qr;
	}

}
