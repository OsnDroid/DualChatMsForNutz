package com.osndroid.cttms.dao;

import org.nutz.dao.FieldFilter;
import org.nutz.dao.util.Daos;
import org.nutz.ioc.loader.annotation.IocBean;

import com.osndroid.cttms.model.pla.request.EventReq;

/**
 * 
 * 事件的DAO
 * 
 * @author OsnDroid
 *
 */
@IocBean
public class UEventDao extends BasicDao {

	public EventReq save(EventReq eventReq) throws Exception {
		return Daos.ext(dao, FieldFilter.locked(EventReq.class, "MsgId"))
				.insert(eventReq);
	}
}
