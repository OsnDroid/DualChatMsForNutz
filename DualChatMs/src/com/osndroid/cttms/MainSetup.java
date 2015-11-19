package com.osndroid.cttms;

import org.apache.log4j.Logger;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;


/**
 * 
 * 程序主入口
 * @author OsnDroid
 *
 */
public class MainSetup implements Setup {
	private static final Logger log = Logger.getLogger(MainSetup.class);
	
    public void init(NutConfig conf) {
//    	Ioc ioc = conf.getIoc();
//      Dao dao = ioc.get(Dao.class);
    	//这里可以初始化一些数据，如双信菜单
//    	InitializationWeixin.createMenu();
//    	InitializationYixin.createMenu();
    	log.info("初始化项目各参数配置...");
        
    }

    public void destroy(NutConfig conf) {
    	
    }

}
