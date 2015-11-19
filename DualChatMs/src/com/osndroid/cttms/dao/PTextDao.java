package com.osndroid.cttms.dao;

import org.nutz.dao.FieldFilter;
import org.nutz.dao.util.Daos;
import org.nutz.ioc.loader.annotation.IocBean;

import com.osndroid.cttms.model.pla.request.TextReq;

/**
 * 
 * 文本的DAO
 * 
 * @author OsnDroid
 *
 */
@IocBean
public class PTextDao extends BasicDao {

	public TextReq save(TextReq textReq) throws Exception {
		return Daos.ext(dao, FieldFilter.locked(TextReq.class, "MsgId"))
				.insert(textReq);
	}
}
